package com.jn.vis.commons.status;

import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.especifications.db.bulk.CcpBulkItem;
import com.ccp.especifications.db.bulk.CcpEntityOperationType;
import com.ccp.process.CcpProcessStatus;
import com.vis.commons.entities.VisEntityResumeViewFailed;

public enum SuggestNewSkillStatus implements CcpProcessStatus{
	rejectedSkill(420),
	approvedSkill(200),
	pendingSkill(202), 
	alreadyExists(409),
	;
	
	final int status;
	
	private SuggestNewSkillStatus(int status) {
		this.status = status;
	}

	public int status() {
		return this.status;
	}

	public CcpBulkItem toBulkItemCreate(CcpJsonRepresentation json) {
		CcpBulkItem bulkItem = VisEntityResumeViewFailed.INSTANCE.toBulkItem(json, CcpEntityOperationType.create);
		return bulkItem;
	}
}
