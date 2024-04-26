package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.CcpTimeOption;
import com.jn.commons.entities.base.JnBaseEntity;

public class VisEntityPosition extends JnBaseEntity{
	private VisEntityPosition() {
		super(false, CcpTimeOption.none, Fields.values());
	}
	
	public static final VisEntityPosition INSTANCE = new VisEntityPosition();

	public static enum Fields implements CcpEntityField{
		title(true), email(true), seniority(true), description(false), contactChannel(false), 
		expireDate(false), mandatorySkill(false), desiredSkill(false), ddd(false), pcd(false), 
		disponibility(false), sortFields(false), frequency(false), channel(false), pj(false),  
		btc(false), clt(false), experience(false), synonym(false)
		
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
