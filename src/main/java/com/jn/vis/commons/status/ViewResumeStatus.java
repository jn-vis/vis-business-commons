package com.jn.vis.commons.status;

import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.especifications.db.bulk.CcpBulkItem;
import com.ccp.especifications.db.bulk.CcpEntityOperationType;
import com.ccp.process.CcpProcessStatus;
import com.vis.commons.entities.VisEntityResumeViewFailed;

public enum ViewResumeStatus implements CcpProcessStatus{
	inactiveResume(301),
	insufficientFunds(402),
	resumeNotFound(404),
	notAllowedRecruiter(420),
	missingFee(421), 
	missingBalance(423), 
	negativatedResume(0), 
	;
	
	final int status;
	
	private ViewResumeStatus(int status) {
		this.status = status;
	}

	public int status() {
		return this.status;
	}

	public CcpBulkItem toBulkItemCreate(CcpJsonRepresentation json) {
		CcpBulkItem bulkItem = VisEntityResumeViewFailed.ENTITY.toBulkItem(json, CcpEntityOperationType.create);
		return bulkItem;
	}
}
