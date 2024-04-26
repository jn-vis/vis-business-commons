package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.CcpTimeOption;
import com.jn.commons.entities.base.JnBaseEntity;

public class VisEntityResume extends JnBaseEntity{
	
	public static final VisEntityResume INSTANCE = new VisEntityResume();
	
	private VisEntityResume() {
		super(false, CcpTimeOption.none, Fields.values());
	}
	public static enum Fields implements CcpEntityField{
		ddd(false), email(true), disabilities(false), companiesNotAllowed(false), disponibility(false), 
		observations(false), pj(false), desiredJob(false), lastJob(false), btc(false), clt(false), experience(false), skill(false), 
		synonym(false), lastUpdate(false)
		,
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
