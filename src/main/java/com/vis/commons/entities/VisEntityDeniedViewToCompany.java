package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpEntityVersionable;
import com.ccp.especifications.db.utils.decorators.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.CcpFactoryEntity;
import com.ccp.validation.annotations.CcpJsonValidation;
import com.jn.commons.utils.JnEntityVersionable;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisDeniedViewToCompany;

@CcpJsonValidation(rulesClass = JsonFieldsValidationsVisDeniedViewToCompany.class)
@CcpEntityVersionable(versionableEntityFactory = JnEntityVersionable.class)
@CcpEntitySpecifications(cacheableEntity = true)
public class VisEntityDeniedViewToCompany{

	public static final CcpEntity ENTITY = CcpFactoryEntity.getEntityInstance(VisEntityDeniedViewToCompany.class);

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
