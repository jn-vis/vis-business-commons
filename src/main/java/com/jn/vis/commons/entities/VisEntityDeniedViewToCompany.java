package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnBaseEntity;

public class VisEntityDeniedViewToCompany extends JnBaseEntity{
	private VisEntityDeniedViewToCompany() {
		super(Fields.values());
	}
	public static final VisEntityDeniedViewToCompany INSTANCE = new VisEntityDeniedViewToCompany();

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
