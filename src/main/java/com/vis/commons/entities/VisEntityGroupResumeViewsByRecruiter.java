package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpEntityExpurgable;
import com.ccp.especifications.db.utils.decorators.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.CcpFactoryEntity;
import com.ccp.especifications.db.utils.decorators.CcpLongevityEntity;
import com.jn.commons.utils.JnDisposableEntity;

@CcpEntityExpurgable(expurgableEntityFactory = JnDisposableEntity.class, longevityEntity = CcpLongevityEntity.yearly)
@CcpEntitySpecifications(cacheableEntity = true)
public class VisEntityGroupResumeViewsByRecruiter{

	public static final CcpEntity ENTITY = CcpFactoryEntity.getEntityInstance(VisEntityGroupResumeViewsByRecruiter.class);

	public static enum Fields implements CcpEntityField{
		detail(false), email(true), listSize(true), from(true)
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
