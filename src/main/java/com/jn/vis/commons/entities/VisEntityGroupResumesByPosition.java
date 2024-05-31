package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntityGroupResumesByPosition extends JnAuditableEntity{
	private VisEntityGroupResumesByPosition() {
		super(Fields.values());
	}
	
	public static final VisEntityGroupResumesByPosition INSTANCE = new VisEntityGroupResumesByPosition();
	
	public static enum Fields implements CcpEntityField{
		email(true), title(true), from(true), listSize(true), resume(false), 
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
