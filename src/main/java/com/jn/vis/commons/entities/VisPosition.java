package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.CcpTimeOption;
import com.jn.commons.entities.base.JnBaseEntity;

public class VisPosition extends JnBaseEntity{
	public VisPosition() {
		super(false, CcpTimeOption.ddMMyyyyHHmmssSSS, Fields.values());
	}
	public static enum Fields implements CcpEntityField{
		title(true), email(true), description(false), contactChannel(false), expireDate(false), 
		mandatorySkill(false), desiredSkill(false), ddd(false), seniority(false),
		disponibility(false), pcd(false), sortFields(false), frequency(false),
		channel(false), btc(false), clt(false), pj(false), experience(false),
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
