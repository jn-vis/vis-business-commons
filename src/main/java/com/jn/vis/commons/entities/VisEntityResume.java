package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntityResume extends JnAuditableEntity{
	
	public static final VisEntityResume INSTANCE = new VisEntityResume();
	
	private VisEntityResume() {
		super(Fields.values());
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

		
		public boolean isPrimaryKey() {
			return this.primaryKey;
		}

	}
}
