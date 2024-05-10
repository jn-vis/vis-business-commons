package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntityResumeReputation extends JnAuditableEntity{
	private VisEntityResumeReputation() {
		super(Fields.values());
	}

	public static final VisEntityResumeReputation INSTANCE = new VisEntityResumeReputation();

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
