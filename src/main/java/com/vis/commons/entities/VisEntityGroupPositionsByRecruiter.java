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
public class VisEntityGroupPositionsByRecruiter{

	public static final CcpEntity ENTITY = CcpFactoryEntity.getEntityInstance(VisEntityGroupPositionsByRecruiter.class);
	
	public static enum Fields implements CcpEntityField{
		email(true), listSize(true), from(true), detail(false)
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
