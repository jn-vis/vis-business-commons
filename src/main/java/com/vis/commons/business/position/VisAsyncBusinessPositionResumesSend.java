package com.vis.commons.business.position;

import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.jn.commons.mensageria.JnTopic;

public class VisAsyncBusinessPositionResumesSend implements JnTopic{

	private VisAsyncBusinessPositionResumesSend() {}
	
	public static final VisAsyncBusinessPositionResumesSend INSTANCE = new VisAsyncBusinessPositionResumesSend();
	
	public CcpJsonRepresentation apply(CcpJsonRepresentation json) {
		return json;
	}

}
