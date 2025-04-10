package com.ccp.vis.schedulling;

import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.jn.commons.mensageria.JnTopic;
import com.vis.commons.entities.VisEntityGroupResumesPerceptionsByRecruiter;
import com.vis.commons.entities.VisEntityResumePerception;
import com.vis.commons.utils.VisAsyncUtils;

public class VisAsyncBusinessGroupResumesOpinionsByRecruiter implements JnTopic{

	private VisAsyncBusinessGroupResumesOpinionsByRecruiter() {}
	
	public static final VisAsyncBusinessGroupResumesOpinionsByRecruiter INSTANCE = new VisAsyncBusinessGroupResumesOpinionsByRecruiter();
	
	public CcpJsonRepresentation apply(CcpJsonRepresentation json) {
		CcpJsonRepresentation groupDetailsByMasters = VisAsyncUtils.groupDetailsByMasters(
				json, 
				VisEntityResumePerception.ENTITY, 
				VisEntityGroupResumesPerceptionsByRecruiter.ENTITY, 
				VisEntityResumePerception.Fields.email, 
				VisEntityResumePerception.Fields.timestamp
				);
		
		return groupDetailsByMasters;
	}

}
