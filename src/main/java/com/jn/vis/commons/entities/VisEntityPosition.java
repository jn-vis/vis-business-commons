package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableAndStatusChangebleEntity;

public class VisEntityPosition extends JnAuditableAndStatusChangebleEntity{
	private VisEntityPosition() {
		super("inactivate_position", Fields.values());
	}
	
	public static final VisEntityPosition INSTANCE = new VisEntityPosition();

	public static enum Fields implements CcpEntityField{
		title(true), email(true), seniority(true), description(false), contactChannel(false), 
		expireDate(false), mandatorySkill(false), desiredSkill(false), ddd(false), pcd(false), 
		disponibility(false), sortFields(false), frequency(false), channel(false), pj(false),  
		btc(false), clt(false), experience(false), synonym(false), timestamp(false), date(false)
		
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
