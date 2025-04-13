package com.ccp.vis.schedulling;

import java.util.List;
import java.util.function.Function;

import com.ccp.decorators.CcpJsonRepresentation;
import com.jn.mensageria.JnTopic;
import com.vis.commons.entities.VisEntityPosition;
import com.vis.commons.entities.VisEntityResume;
import com.vis.commons.utils.FrequencyOptions;
import com.vis.commons.utils.VisAsyncUtils;

public class VisAsyncBusinessPositionResumesReceivingByFrequency  implements JnTopic{

	private VisAsyncBusinessPositionResumesReceivingByFrequency() {}
	
	public static final VisAsyncBusinessPositionResumesReceivingByFrequency INSTANCE = new VisAsyncBusinessPositionResumesReceivingByFrequency();
	
	public CcpJsonRepresentation apply(CcpJsonRepresentation schedullingPlan) {

		Function<CcpJsonRepresentation, List<CcpJsonRepresentation>> getLastUpdatedResumes = x -> VisAsyncUtils.getLastUpdated(VisEntityResume.ENTITY, FrequencyOptions.valueOf(x.getAsString(VisEntityPosition.Fields.frequency.name())), VisEntityPosition.Fields.timestamp.name());

		Function<String, CcpJsonRepresentation> getLastUpdatedPositions = frequency -> VisAsyncUtils.getAllPositionsGroupedByRecruiters(FrequencyOptions.valueOf(frequency));

		VisAsyncUtils.sendFilteredAndSortedResumesAndTheirStatisByEachPositionToEachRecruiter(schedullingPlan, getLastUpdatedResumes, getLastUpdatedPositions);
	
		return schedullingPlan;
	}
}
