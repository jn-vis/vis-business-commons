
package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpFactoryEntity;
import com.ccp.validation.annotations.ValidationRules;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisBalance;

@ValidationRules(rulesClass = JsonFieldsValidationsVisBalance.class)
//super(Fields.values());
public class VisEntityBalance{

	public static final CcpEntity ENTITY = CcpFactoryEntity.getEntityInstance(VisEntityVirtualHashGrouper.class);
	
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
