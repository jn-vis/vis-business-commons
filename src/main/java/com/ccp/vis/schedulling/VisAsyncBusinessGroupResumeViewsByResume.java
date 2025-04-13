package com.ccp.vis.schedulling;

import com.ccp.decorators.CcpJsonRepresentation;
import com.jn.mensageria.JnTopic;
import com.vis.commons.entities.VisEntityGroupResumeViewsByResume;
import com.vis.commons.entities.VisEntityResumeFreeView;
import com.vis.commons.utils.VisAsyncUtils;

public class VisAsyncBusinessGroupResumeViewsByResume implements JnTopic{

	private VisAsyncBusinessGroupResumeViewsByResume() {}
	
	public static final VisAsyncBusinessGroupResumeViewsByResume INSTANCE = new VisAsyncBusinessGroupResumeViewsByResume();
	
	public CcpJsonRepresentation apply(CcpJsonRepresentation json) {
		CcpJsonRepresentation groupDetailsByMasters = VisAsyncUtils.groupDetailsByMasters(
				json, 
				VisEntityResumeFreeView.ENTITY, 
				VisEntityGroupResumeViewsByResume.ENTITY, 
				VisEntityResumeFreeView.Fields.email, 
				VisEntityResumeFreeView.Fields.timestamp
				);
		
		return groupDetailsByMasters;
	}

}
