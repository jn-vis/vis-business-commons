package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntityValidation;
import com.ccp.especifications.db.utils.decorators.configurations.CcpNoValidation;
import com.ccp.especifications.db.utils.decorators.engine.CcpEntityConfigurator;
import com.ccp.especifications.db.utils.decorators.engine.CcpEntityFactory;
import com.jn.commons.json.transformers.JnJsonTransformerPutEmailHash;
import com.vis.commons.json.validations.VisJsonValidationDeniedViewToCompany;

@CcpEntitySpecifications(
		changeStatus = @CcpEntityValidation(afterOperation = {}, beforeOperation = {}, jsonValidationClass = CcpNoValidation.class),
		delete = @CcpEntityValidation(afterOperation = {}, beforeOperation = {}, jsonValidationClass = CcpNoValidation.class),
	    save = @CcpEntityValidation(afterOperation = {}, beforeOperation = {JnJsonTransformerPutEmailHash.class}, jsonValidationClass = VisJsonValidationDeniedViewToCompany.class),
		cacheableEntity = true
)
public class VisEntityDeniedViewToCompany implements CcpEntityConfigurator {

	public static final CcpEntity ENTITY = new CcpEntityFactory(VisEntityDeniedViewToCompany.class).entityInstance;

	public static enum Fields implements CcpEntityField{
		domain(true), email(true),
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
