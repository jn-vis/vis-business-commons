package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntityResumeLastView extends JnAuditableEntity{
	
	private VisEntityResumeLastView() {
		super(Fields.values());
	}

	public static final VisEntityResumeLastView INSTANCE = new VisEntityResumeLastView();

	public static enum Fields implements CcpEntityField{
		recruiter(true), email(true), date(false), timestamp(false), negativatedResume(false), 
		inactivePosition(false), resume(false), position(false)
		;
		private final boolean primaryKey;

		private Fields(boolean primaryKey) {
			this.primaryKey = primaryKey;
		}

		
		public boolean isPrimaryKey() {
			return this.primaryKey;
		}

	}
}
