package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntitySkill extends JnAuditableEntity{
	private VisEntitySkill() {
		super(Fields.values());
	}
	
	public static final VisEntitySkill INSTANCE = new VisEntitySkill();
	
	public static enum Fields implements CcpEntityField{
		skill(true), synonym(false), prerequisite(false), ranking(false)
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
