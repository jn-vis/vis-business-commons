package com.jn.vis.commons.utils;

import com.jn.commons.utils.JnTopic;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisPosition;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisPositionId;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisPositionReceivingResumes;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisPositionSendResumesToEmail;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisRecruiterReceivingResumes;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisResume;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisResumeOpinion;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisResumeViewAdd;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisSkillsSuggest;

public enum VisAsyncBusiness implements JnTopic{
	resumeOpinionChange(JsonFieldsValidationsVisResumeOpinion.class), 
	resumeOpinionSave(JsonFieldsValidationsVisResumeOpinion.class), 
	resume(JsonFieldsValidationsVisResume.class),
	groupResumesOpinionsByResume, 
	groupResumeViewsByResume, 
	resumeStatusChange, 
	resumeBucketSave, 
	resumeDelete, 
	resumeSave,

	groupResumeViewsByRecruiter, 
	groupResumesOpinionsByRecruiter, 
	positionSave(JsonFieldsValidationsVisPosition.class),
	positionStatusChange(JsonFieldsValidationsVisPositionId.class), 
	positionResumesSend(JsonFieldsValidationsVisPositionSendResumesToEmail.class), 
	positionResumesReceivingByFrequency(JsonFieldsValidationsVisPositionReceivingResumes.class),

	recruiterReceivingResumes(JsonFieldsValidationsVisRecruiterReceivingResumes.class), 

	skillsSuggest(JsonFieldsValidationsVisSkillsSuggest.class), 
	resumeViewSave(JsonFieldsValidationsVisResumeViewAdd.class), 
	
	getRecentLoggedUsers, 
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
