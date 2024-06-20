package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.validation.annotations.ValidationRules;
import com.jn.commons.entities.base.JnAuditableEntity;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisDeniedViewToCompany;

@ValidationRules(rulesClass = JsonFieldsValidationsVisDeniedViewToCompany.class)
public class VisEntityDeniedViewToCompany extends JnAuditableEntity{
	private VisEntityDeniedViewToCompany() {
		super(Fields.values());
	}
	public static final VisEntityDeniedViewToCompany INSTANCE = new VisEntityDeniedViewToCompany();

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
