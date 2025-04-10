package com.vis.commons.business.position;

import java.util.function.Function;

import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.jn.commons.mensageria.JnTopic;
import com.vis.commons.entities.VisEntityPosition;
import com.vis.commons.utils.VisAsyncBusinessPositionUpdateGroupingByRecruitersAndSendResumes;
import com.vis.commons.utils.VisAsyncUtils;

public class VisAsyncBusinessPositionStatusChange implements JnTopic{

	private VisAsyncBusinessPositionStatusChange() {}
	
	public static final VisAsyncBusinessPositionStatusChange INSTANCE = new VisAsyncBusinessPositionStatusChange();
	
	public CcpJsonRepresentation apply(CcpJsonRepresentation json) {
		Function<CcpJsonRepresentation, CcpJsonRepresentation> whenPositionIsInactivated = data -> VisAsyncUtils.groupPositionsGroupedByRecruiters(data.duplicateValueFromField(VisEntityPosition.Fields.email.name(), "masters"));
		VisAsyncBusinessPositionUpdateGroupingByRecruitersAndSendResumes whenPositionIsReactivated = VisAsyncBusinessPositionUpdateGroupingByRecruitersAndSendResumes.INSTANCE;
		VisAsyncUtils.changeStatus(json, VisEntityPosition.ENTITY, whenPositionIsReactivated, whenPositionIsInactivated);
		return json;
	}

}
