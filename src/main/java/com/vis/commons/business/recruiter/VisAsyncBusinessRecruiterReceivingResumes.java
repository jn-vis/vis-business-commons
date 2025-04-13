package com.vis.commons.business.recruiter;

import com.ccp.decorators.CcpJsonRepresentation;
import com.jn.mensageria.JnTopic;

public class VisAsyncBusinessRecruiterReceivingResumes implements JnTopic{

	private VisAsyncBusinessRecruiterReceivingResumes() {}
	
	public static final VisAsyncBusinessRecruiterReceivingResumes INSTANCE = new VisAsyncBusinessRecruiterReceivingResumes();
	
	public CcpJsonRepresentation apply(CcpJsonRepresentation json) {
		return json;
	}

}
