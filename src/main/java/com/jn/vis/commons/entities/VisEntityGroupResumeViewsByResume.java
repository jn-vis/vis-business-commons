package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntityGroupResumeViewsByResume extends JnAuditableEntity{
	
	private VisEntityGroupResumeViewsByResume() {
		super(Fields.values());
	}

	public static final VisEntityGroupResumeViewsByResume INSTANCE = new VisEntityGroupResumeViewsByResume();

	public static enum Fields implements CcpEntityField{
		recruiter(true), email(true), date(false), viewDetails(false)
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
