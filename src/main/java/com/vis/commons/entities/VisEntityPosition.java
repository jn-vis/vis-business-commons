package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableAndStatusChangebleEntity;

public class VisEntityPosition extends JnAuditableAndStatusChangebleEntity{
	private VisEntityPosition() {
		super("inactive_position", Fields.values());
	}
	
	public static final VisEntityPosition INSTANCE = new VisEntityPosition();

	public static enum Fields implements CcpEntityField{
		btc(false), 
		channel(false), 
		clt(false), 
		contactChannel(false), 
		date(false),
		ddd(false), 
		description(false), 
		desiredSkill(false), 
		disponibility(false), 
		email(true), 
		expireDate(false), 
		frequency(false), 
		pcd(false), 
		pj(false),  
		requiredSkill(false), 
		seniority(true), 
		sortFields(false), 
		timestamp(false), 
		title(true), 
		
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
