package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntityResumeViewFailed extends JnAuditableEntity{
	private VisEntityResumeViewFailed() {
		super(Fields.values());
	}
	
	public static final VisEntityResumeViewFailed INSTANCE = new VisEntityResumeViewFailed();
	
	public static enum Fields implements CcpEntityField{
		recruiter(true), email(true), status(true), json(false), timestamp(false),date(false),
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
