package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.CcpFactoryEntity;

@CcpEntitySpecifications(cacheableEntity = true)
public class VisEntityResumeViewFailed{

	public static final CcpEntity ENTITY = CcpFactoryEntity.getEntityInstance(VisEntityResumeViewFailed.class);
	
	public static enum Fields implements CcpEntityField{
		recruiter(true), email(true), status(true), json(false), timestamp(false),date(false),
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
