
package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.engine.CcpEntityConfigurator;
import com.ccp.especifications.db.utils.decorators.engine.CcpEntityFactory;
import com.ccp.validation.annotations.CcpJsonFieldsValidation;
import com.jn.commons.json.transformers.JnJsonTransformerPutEmailHash;
import com.vis.commons.json.validations.VisJsonValidationBalance;

@CcpJsonFieldsValidation(rulesClass = VisJsonValidationBalance.class)
@CcpEntitySpecifications(cacheableEntity = true, stepsBeforeSaveEntity = {JnJsonTransformerPutEmailHash.class})
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
