
package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.CcpFactoryEntity;
import com.ccp.validation.annotations.CcpJsonValidation;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisBalance;

@CcpJsonValidation(rulesClass = JsonFieldsValidationsVisBalance.class)
@CcpEntitySpecifications(cacheableEntity = true)
public class VisEntityBalance{

	public static final CcpEntity ENTITY = CcpFactoryEntity.getEntityInstance(VisEntityBalance.class);
	
	public static enum Fields implements CcpEntityField{
		email(true), balance(false),
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
