package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpFactoryEntity;

//super(Fields.values());
public class VisEntitySkillApproved{
	private VisEntitySkillApproved() {
	}
	
	public static final CcpEntity ENTITY = CcpFactoryEntity.getEntityInstance(VisEntityVirtualHashGrouper.class);
	
	public static enum Fields implements CcpEntityField{
		skill(true), synonym(false), prerequiste(false), ranking(false)
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
