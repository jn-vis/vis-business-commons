package com.vis.commons.business.position;

import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.jn.commons.mensageria.JnTopic;
import com.vis.commons.utils.VisAsyncUtils;

public class VisBusinessGroupPositionsGroupedByRecruiters implements JnTopic{

	public static final VisBusinessGroupPositionsGroupedByRecruiters INSTANCE = new VisBusinessGroupPositionsGroupedByRecruiters();
	
	private VisBusinessGroupPositionsGroupedByRecruiters() {}
	
	
	public CcpJsonRepresentation apply(CcpJsonRepresentation json) {
		CcpJsonRepresentation groupPositionsGroupedByRecruiters = VisAsyncUtils.groupPositionsGroupedByRecruiters(json);
		return groupPositionsGroupedByRecruiters;
	}

}
