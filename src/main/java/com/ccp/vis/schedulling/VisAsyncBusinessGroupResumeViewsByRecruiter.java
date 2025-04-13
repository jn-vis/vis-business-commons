package com.ccp.vis.schedulling;

import com.ccp.decorators.CcpJsonRepresentation;
import com.jn.mensageria.JnTopic;
import com.vis.commons.entities.VisEntityGroupResumeViewsByRecruiter;
import com.vis.commons.entities.VisEntityResumeFreeView;
import com.vis.commons.utils.VisAsyncUtils;

public class VisAsyncBusinessGroupResumeViewsByRecruiter implements JnTopic{

	private VisAsyncBusinessGroupResumeViewsByRecruiter() {}
	
	public static final VisAsyncBusinessGroupResumeViewsByRecruiter INSTANCE = new VisAsyncBusinessGroupResumeViewsByRecruiter();
	
	public CcpJsonRepresentation apply(CcpJsonRepresentation json) {
		CcpJsonRepresentation groupDetailsByMasters = VisAsyncUtils.groupDetailsByMasters(
				json, 
				VisEntityResumeFreeView.ENTITY, 
				VisEntityGroupResumeViewsByRecruiter.ENTITY, 
				VisEntityResumeFreeView.Fields.email, 
				VisEntityResumeFreeView.Fields.timestamp
				);
		
		return groupDetailsByMasters;
	}

}
