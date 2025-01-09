package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpEntityConfigurator;
import com.ccp.especifications.db.utils.decorators.CcpEntityFactory;
import com.ccp.especifications.db.utils.decorators.CcpEntitySpecifications;
import com.ccp.validation.annotations.CcpJsonFieldsValidation;
import com.jn.commons.json.transformers.JnJsonTransformerPutEmailHash;
import com.vis.commons.json.validations.VisJsonValidationDeniedViewToCompany;

@CcpJsonFieldsValidation(rulesClass = VisJsonValidationDeniedViewToCompany.class)
@CcpEntitySpecifications(cacheableEntity = true, jsonTransformations = {JnJsonTransformerPutEmailHash.class})
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
