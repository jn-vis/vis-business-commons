package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.CcpTimeOption;
import com.jn.commons.entities.base.JnBaseEntity;

public class VisEntityResume extends JnBaseEntity{
	public VisEntityResume() {
		super(false, CcpTimeOption.none, Fields.values());
	}
	public static enum Fields implements CcpEntityField{
		ddd(false), email(true), disabilities(false), companiesNotAllowed(false), disponibility(false), 
		observations(false), resumeBase64(false), resumeWords(false), resumeText(false),
		desiredJob(false), lastJob(false), btc(false), clt(false),
		pj(false), experience(false),
		;
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
