package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntityGroupResumeViewsByRecruiter extends JnAuditableEntity{
	
	private VisEntityGroupResumeViewsByRecruiter() {
		super(Fields.values());
	}

	public static final VisEntityGroupResumeViewsByRecruiter INSTANCE = new VisEntityGroupResumeViewsByRecruiter();

	public static enum Fields implements CcpEntityField{
		recruiter(true), email(true), date(false)
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
