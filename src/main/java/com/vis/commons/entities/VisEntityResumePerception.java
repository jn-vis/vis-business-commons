package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntityResumePerception extends JnAuditableEntity{
	private VisEntityResumePerception() {
		super(Fields.values());
	}
	
	public static final VisEntityResumePerception INSTANCE = new VisEntityResumePerception();
	
	public static enum Fields implements CcpEntityField{
		recruiter(true), email(true), timestamp(false),date(false),
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
