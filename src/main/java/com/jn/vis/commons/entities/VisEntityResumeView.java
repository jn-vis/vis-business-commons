package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntityResumeView extends JnAuditableEntity{
	
	private VisEntityResumeView() {
		super(Fields.values());
	}

	public static final VisEntityResumeView INSTANCE = new VisEntityResumeView();

	public static enum Fields implements CcpEntityField{
		recruiter(true), email(true), date(false), timestamp(false)
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
