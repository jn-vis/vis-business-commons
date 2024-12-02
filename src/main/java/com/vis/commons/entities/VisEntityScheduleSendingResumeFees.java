package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpEntityVersionable;
import com.ccp.especifications.db.utils.decorators.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.CcpFactoryEntity;
import com.jn.commons.utils.JnEntityVersionable;

@CcpEntityVersionable(versionableEntityFactory = JnEntityVersionable.class)
@CcpEntitySpecifications(cacheableEntity = true)
public class VisEntityScheduleSendingResumeFees{

	public static final CcpEntity ENTITY = CcpFactoryEntity.getEntityInstance(VisEntityScheduleSendingResumeFees.class);

	public static enum Fields implements CcpEntityField{
		fee(false), service(true)
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
