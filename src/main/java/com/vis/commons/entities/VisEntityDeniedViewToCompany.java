package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpFactoryEntity;
import com.ccp.validation.annotations.ValidationRules;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisDeniedViewToCompany;
//super(Fields.values());

@ValidationRules(rulesClass = JsonFieldsValidationsVisDeniedViewToCompany.class)
public class VisEntityDeniedViewToCompany{

	public static final CcpEntity ENTITY = CcpFactoryEntity.getEntityInstance(VisEntityVirtualHashGrouper.class);

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
