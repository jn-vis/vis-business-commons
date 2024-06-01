package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntityResumeOpinion extends JnAuditableEntity{
	private VisEntityResumeOpinion() {
		super(Fields.values());
	}
	
	public static final VisEntityResumeOpinion INSTANCE = new VisEntityResumeOpinion();
	
	public static enum Fields implements CcpEntityField{
		recruiter(true), email(true), timestamp(false),
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
