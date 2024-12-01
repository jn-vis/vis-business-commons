package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpFactoryEntity;

//super(CcpLongevityEntity.yearly, Fields.values());
public class VisEntityGroupResumesByPosition{
	private VisEntityGroupResumesByPosition() {
	}
	
	public static final CcpEntity ENTITY = CcpFactoryEntity.getEntityInstance(VisEntityVirtualHashGrouper.class);
	
	public static enum Fields implements CcpEntityField{
		detail(false), email(true), title(true), seniority(true), listSize(true), from(true)
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
