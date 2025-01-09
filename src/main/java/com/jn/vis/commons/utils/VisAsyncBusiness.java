package com.jn.vis.commons.utils;

import com.jn.commons.utils.JnTopic;
import com.vis.commons.json.validations.VisJsonValidationPosition;
import com.vis.commons.json.validations.VisJsonValidationPositionId;
import com.vis.commons.json.validations.VisJsonValidationPositionReceivingResumes;
import com.vis.commons.json.validations.VisJsonValidationPositionSendResumesToEmail;
import com.vis.commons.json.validations.VisJsonValidationRecruiterReceivingResumes;
import com.vis.commons.json.validations.VisJsonValidationResume;
import com.vis.commons.json.validations.VisJsonValidationResumeOpinion;
import com.vis.commons.json.validations.VisJsonValidationResumeViewAdd;
import com.vis.commons.json.validations.VisJsonValidationSkillsSuggest;

public enum VisAsyncBusiness implements JnTopic{
	resumeOpinionChange(VisJsonValidationResumeOpinion.class), 
	resumeOpinionSave(VisJsonValidationResumeOpinion.class), 
	resume(VisJsonValidationResume.class),
	groupResumesOpinionsByResume, 
	groupResumeViewsByResume, 
	resumeStatusChange, 
	resumeBucketSave, 
	resumeDelete, 
	resumeSave,

	groupResumeViewsByRecruiter, 
	groupResumesOpinionsByRecruiter, 
	positionSave(VisJsonValidationPosition.class),
	positionStatusChange(VisJsonValidationPositionId.class), 
	positionResumesSend(VisJsonValidationPositionSendResumesToEmail.class), 
	positionResumesReceivingByFrequency(VisJsonValidationPositionReceivingResumes.class),

	recruiterReceivingResumes(VisJsonValidationRecruiterReceivingResumes.class), 

	skillsSuggest(VisJsonValidationSkillsSuggest.class), 
	resumeViewSave(VisJsonValidationResumeViewAdd.class), 
	
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
