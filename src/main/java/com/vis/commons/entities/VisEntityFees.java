package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntityDecorators;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.engine.CcpEntityConfigurator;
import com.ccp.especifications.db.utils.decorators.engine.CcpEntityFactory;
import com.ccp.validation.annotations.CcpJsonFieldsValidation;
import com.jn.commons.utils.JnEntityVersionable;
import com.vis.commons.json.validations.VisJsonValidationFees;

@CcpEntityDecorators(decorators = JnEntityVersionable.class)
@CcpJsonFieldsValidation(rulesClass = VisJsonValidationFees.class)
@CcpEntitySpecifications(cacheableEntity = true, stepsBeforeSaveEntity = {})
public class VisEntityFees implements CcpEntityConfigurator {

	public static final CcpEntity ENTITY = new CcpEntityFactory(VisEntityFees.class).entityInstance;

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
