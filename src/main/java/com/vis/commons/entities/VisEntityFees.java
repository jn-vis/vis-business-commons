package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.validation.annotations.ValidationRules;
import com.jn.commons.entities.base.JnAuditableEntity;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisFees;

@ValidationRules(rulesClass = JsonFieldsValidationsVisFees.class)
public class VisEntityFees extends JnAuditableEntity{

	private VisEntityFees() {
		super(Fields.values());
	}

	public static final VisEntityFees INSTANCE = new VisEntityFees();

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
