
package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.CcpEntityConfigurator;
import com.ccp.especifications.db.utils.decorators.CcpEntityFactory;
import com.ccp.validation.annotations.CcpJsonFieldsValidation;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisBalance;

@CcpJsonFieldsValidation(rulesClass = JsonFieldsValidationsVisBalance.class)
@CcpEntitySpecifications(cacheableEntity = true)
public class VisEntityBalance implements CcpEntityConfigurator {

	public static final CcpEntity ENTITY = new CcpEntityFactory(VisEntityBalance.class).entityInstance;
	
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
