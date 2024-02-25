package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.CcpTimeOption;
import com.jn.commons.entities.base.JnBaseEntity;

public class VisEntityPositionMonthlySendingResumes extends JnBaseEntity{
	public VisEntityPositionMonthlySendingResumes() {
		super(false, CcpTimeOption.ddMM, Fields.values());
	}
	public static enum Fields implements CcpEntityField{
		
		title(false), email(false), recruiter(false);
	
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
