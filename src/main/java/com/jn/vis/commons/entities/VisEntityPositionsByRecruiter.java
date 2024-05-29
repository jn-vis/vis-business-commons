package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntityPositionsByRecruiter extends JnAuditableEntity{
	private VisEntityPositionsByRecruiter() {
		super(Fields.values());
	}
	
	public static final VisEntityPositionsByRecruiter INSTANCE = new VisEntityPositionsByRecruiter();
	
	public static enum Fields implements CcpEntityField{
		email(true), position(false), 
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
