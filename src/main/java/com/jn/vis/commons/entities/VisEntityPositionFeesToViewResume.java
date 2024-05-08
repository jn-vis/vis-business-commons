package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnBaseEntity;

public class VisEntityPositionFeesToViewResume extends JnBaseEntity{
	private VisEntityPositionFeesToViewResume() {
		super(Fields.values());
	}

	public static final VisEntityPositionFeesToViewResume INSTANCE = new VisEntityPositionFeesToViewResume();

	public static enum Fields implements CcpEntityField{
		fee(false), frequency(true)
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
