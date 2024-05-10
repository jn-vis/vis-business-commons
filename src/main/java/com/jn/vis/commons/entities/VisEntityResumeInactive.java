package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntityResumeInactive extends JnAuditableEntity{
	private VisEntityResumeInactive() {
		super(Fields.values());
	}

	public static final VisEntityResumeInactive INSTANCE = new VisEntityResumeInactive();

	public static enum Fields implements CcpEntityField{
		ddd(false), email(true), disabilities(false), companiesNotAllowed(false), disponibility(false), 
		observations(false), resumeBase64(false), resumeWords(false), resumeText(false),pj(false),
		desiredJob(false), lastJob(false), btc(false), clt(false), experience(false), hash(false), 
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
