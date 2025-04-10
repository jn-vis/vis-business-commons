package com.vis.commons.business.position;

import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.jn.commons.mensageria.JnTopic;
import com.vis.commons.entities.VisEntityPosition;
import com.vis.commons.utils.VisAsyncBusinessPositionUpdateGroupingByRecruitersAndSendResumes;

public class VisAsyncBusinessPositionSave implements  JnTopic{

	private VisAsyncBusinessPositionSave() {}
	
	public static final VisAsyncBusinessPositionSave INSTANCE = new VisAsyncBusinessPositionSave();
	
	public CcpJsonRepresentation apply(CcpJsonRepresentation json) {
		
		VisEntityPosition.ENTITY.createOrUpdate(json);
		
		CcpJsonRepresentation apply = VisAsyncBusinessPositionUpdateGroupingByRecruitersAndSendResumes.INSTANCE.apply(json);
		
		return apply;
	}

}
