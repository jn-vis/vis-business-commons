package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntitySkillPending extends JnAuditableEntity{
	private VisEntitySkillPending() {
		super(Fields.values());
	}
	
	public static final VisEntitySkillPending INSTANCE = new VisEntitySkillPending();
	
	public static enum Fields implements CcpEntityField{
		skill(true), synonym(false), prerequiste(false), ranking(false)
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
