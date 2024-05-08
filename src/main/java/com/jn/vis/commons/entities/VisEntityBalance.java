package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnBaseEntity;

public class VisEntityBalance extends JnBaseEntity{
	private VisEntityBalance() {
		super(Fields.values());
	}
	
	public static final VisEntityBalance INSTANCE = new VisEntityBalance();
	
	public static enum Fields implements CcpEntityField{
		owner(true), balance(false),
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
