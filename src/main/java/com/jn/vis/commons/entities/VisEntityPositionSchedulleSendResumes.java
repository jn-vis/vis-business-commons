package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.CcpTimeOption;
import com.jn.commons.entities.base.JnBaseEntity;

public class VisEntityPositionSchedulleSendResumes extends JnBaseEntity{
	public VisEntityPositionSchedulleSendResumes() {
		super(false, CcpTimeOption.none, Fields.values());
	}
	public static enum Fields implements CcpEntityField{
		
		title(false), email(false), frequency(true);
	
		private final boolean primaryKey;

		private Fields(boolean primaryKey) {
			this.primaryKey = primaryKey;
		}

		@Override
		public boolean isPrimaryKey() {
			return this.primaryKey;
		}

	}
}
