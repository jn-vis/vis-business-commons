
package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.validation.annotations.ValidationRules;
import com.jn.commons.entities.base.JnAuditableEntity;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisBalance;

@ValidationRules(rulesClass = JsonFieldsValidationsVisBalance.class)
public class VisEntityBalance extends JnAuditableEntity{
	private VisEntityBalance() {
		super(Fields.values());
	}
	
	public static final VisEntityBalance INSTANCE = new VisEntityBalance();
	
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
