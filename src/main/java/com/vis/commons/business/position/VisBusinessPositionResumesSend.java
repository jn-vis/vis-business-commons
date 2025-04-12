package com.vis.commons.business.position;

import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.jn.commons.mensageria.JnTopic;

public class VisBusinessPositionResumesSend implements JnTopic{

	private VisBusinessPositionResumesSend() {}
	
	public static final VisBusinessPositionResumesSend INSTANCE = new VisBusinessPositionResumesSend();
	
	public CcpJsonRepresentation apply(CcpJsonRepresentation json) {
		return json;
	}

}
