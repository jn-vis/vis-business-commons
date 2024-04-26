package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.CcpTimeOption;
import com.jn.commons.entities.base.JnBaseEntity;

public class VisEntityHashGrouper extends JnBaseEntity{
	private VisEntityHashGrouper() {
		super(false, CcpTimeOption.none, Fields.values());
	}
	
	public static final VisEntityHashGrouper INSTANCE = new VisEntityHashGrouper();

	public static enum Fields implements CcpEntityField{
		resumeWord(true), seniority(true), synonym(true),
		disponibility(true), pcd(true), moneyValue(true), moneyType(true), 
		
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
