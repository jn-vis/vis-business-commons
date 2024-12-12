package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpEntityDecorators;
import com.ccp.especifications.db.utils.decorators.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.CcpEntityConfigurator;
import com.ccp.especifications.db.utils.decorators.CcpEntityFactory;
import com.jn.commons.utils.JnEntityVersionable;

@CcpEntityDecorators(decorators = JnEntityVersionable.class)
@CcpEntitySpecifications(cacheableEntity = true)
public class VisEntityScheduleSendingResumeFees implements CcpEntityConfigurator {

	public static final CcpEntity ENTITY = new CcpEntityFactory(VisEntityScheduleSendingResumeFees.class).entityInstance;

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
