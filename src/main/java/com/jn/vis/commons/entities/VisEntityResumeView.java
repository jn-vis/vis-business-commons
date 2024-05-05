package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.CcpTimeOption;
import com.jn.commons.entities.base.JnBaseEntity;

public class VisEntityResumeView extends JnBaseEntity{
	private VisEntityResumeView() {
		super(false, CcpTimeOption.none, Fields.values());
	}

	public static final VisEntityResumeView INSTANCE = new VisEntityResumeView();

	public static enum Fields implements CcpEntityField{
		recruiter(true), email(true), date(false)
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
