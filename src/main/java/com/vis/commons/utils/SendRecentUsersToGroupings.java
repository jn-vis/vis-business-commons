package com.vis.commons.utils;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.ccp.constantes.CcpOtherConstants;
import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.jn.commons.mensageria.JnMensageriaSender;
import com.ccp.vis.schedulling.VisAsyncBusinessGroupResumeViewsByRecruiter;
import com.ccp.vis.schedulling.VisAsyncBusinessGroupResumeViewsByResume;
import com.ccp.vis.schedulling.VisAsyncBusinessGroupResumesOpinionsByRecruiter;
import com.ccp.vis.schedulling.VisAsyncBusinessGroupResumesOpinionsByResume;
import com.jn.commons.entities.JnEntityDisposableRecord;
import com.jn.commons.entities.JnEntityLoginSessionValidation;

public class SendRecentUsersToGroupings implements Consumer<List<CcpJsonRepresentation>> {
	
	private SendRecentUsersToGroupings() {}
	
	public final static SendRecentUsersToGroupings INSTANCE = new SendRecentUsersToGroupings();

	public void accept(List<CcpJsonRepresentation> records) {
		List<String> emails = records.stream()
		.map(rec ->	rec.getAsString(JnEntityDisposableRecord.Fields.id.name()))
		.map(id -> new CcpJsonRepresentation(id))
		.map(json -> json.getAsString(JnEntityLoginSessionValidation.Fields.email.name()))
		.collect(Collectors.toList());
		
		CcpJsonRepresentation message = CcpOtherConstants.EMPTY_JSON.put("masters", emails);
		
		new JnMensageriaSender(VisAsyncBusinessGroupResumesOpinionsByRecruiter.INSTANCE).send(message);
		VisAsyncBusinessGroupResumesOpinionsByResume.INSTANCE.sendToMensageria(message);
		VisAsyncBusinessGroupResumeViewsByRecruiter.INSTANCE.sendToMensageria(message);
		VisAsyncBusinessGroupResumeViewsByResume.INSTANCE.sendToMensageria(message);
	}

}
