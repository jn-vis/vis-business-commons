package com.jn.vis.commons.utils;

import com.jn.commons.utils.JnTopic;
import com.jn.commons.validations.JsonFieldsValidationJnEmail;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisPosition;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisPositionId;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisPositionReceivingResumes;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisPositionSendResumesToEmail;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisRecruiterReceivingResumes;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisResume;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisResumeFiles;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisResumeOpinion;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisSkillsSuggest;

public enum VisAsyncBusiness implements JnTopic{
	resumeOpinionChange(JsonFieldsValidationsVisResumeOpinion.class), 
	resumeOpinionSave(JsonFieldsValidationsVisResumeOpinion.class), 
	resumeBucketSave(JsonFieldsValidationsVisResumeFiles.class), 
	resumeStatusChange(JsonFieldsValidationJnEmail.class), 
	resumeBucketGet(JsonFieldsValidationJnEmail.class), 
	resumeDelete(JsonFieldsValidationJnEmail.class), 
	resumeSave(JsonFieldsValidationsVisResume.class), 
	resumeViewsRecruiterGrouper(), 
	resumeNotificationsGrouper(), 

	positionSave(JsonFieldsValidationsVisPosition.class),
	positionResumesSend(JsonFieldsValidationsVisPositionSendResumesToEmail.class), 
	positionResumesReceivingByFrequency(JsonFieldsValidationsVisPositionReceivingResumes.class),
	positionResumesListing(JsonFieldsValidationsVisPosition.class), 
	positionStatusChange(JsonFieldsValidationsVisPositionId.class), 
	positionNotificationsGrouper(), 
	positionRecruiterGrouper(),

	recruiterReceivingResumes(JsonFieldsValidationsVisRecruiterReceivingResumes.class), 

	skillsSuggest(JsonFieldsValidationsVisSkillsSuggest.class), 
	;

	private final Class<?> validationClass;
	
	private VisAsyncBusiness(Class<?> validationClass) {
		this.validationClass = validationClass;
	}

	private VisAsyncBusiness() {
		this.validationClass = this.getClass();
	}



	public Class<?> validationClass() {
		return this.validationClass;
	}

}
