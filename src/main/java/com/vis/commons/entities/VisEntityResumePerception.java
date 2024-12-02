package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpEntityAuditable;
import com.ccp.especifications.db.utils.decorators.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.CcpFactoryEntity;
import com.jn.commons.utils.JnAuditableEntity;

@CcpEntityAuditable(auditableEntityFactory = JnAuditableEntity.class)
@CcpEntitySpecifications(cacheableEntity = true)
public class VisEntityResumePerception{

	public static final CcpEntity ENTITY = CcpFactoryEntity.getEntityInstance(VisEntityResumePerception.class);
	
	public static enum Fields implements CcpEntityField{
		recruiter(true), email(true), timestamp(false),date(false),
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
