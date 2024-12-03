package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpEntityVersionable;
import com.ccp.especifications.db.utils.decorators.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.CcpEntityFactory;
import com.ccp.validation.annotations.CcpJsonValidation;
import com.jn.commons.utils.JnEntityVersionable;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisFees;

@CcpEntityVersionable(versionableEntityFactory = JnEntityVersionable.class)
@CcpJsonValidation(rulesClass = JsonFieldsValidationsVisFees.class)
@CcpEntitySpecifications(cacheableEntity = true)
public class VisEntityFees{

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
