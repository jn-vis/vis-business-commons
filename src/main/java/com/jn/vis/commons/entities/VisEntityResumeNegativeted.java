package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntityResumeNegativeted extends JnAuditableEntity{
	private VisEntityResumeNegativeted() {
		super(Fields.values());
	}

	public static final VisEntityResumeNegativeted INSTANCE = new VisEntityResumeNegativeted();

	public static enum Fields implements CcpEntityField{
		company(true), email(true),
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
