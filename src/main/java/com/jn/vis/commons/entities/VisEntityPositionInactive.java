package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntityPositionInactive extends JnAuditableEntity{
	private VisEntityPositionInactive() {
		super(Fields.values());
	}

	public static final VisEntityPositionInactive INSTANCE = new VisEntityPositionInactive();

	public static enum Fields implements CcpEntityField{
		title(true), email(true), description(false), contactChannel(false), expireDate(false), 
		mandatorySkill(false), desiredSkill(false), ddd(false), seniority(false), pcd(false), 
		disponibility(false), sortFields(false), frequency(false), channel(false), pj(false),  
		btc(false), clt(false), experience(false), synonym(false), hash(false),
		
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
