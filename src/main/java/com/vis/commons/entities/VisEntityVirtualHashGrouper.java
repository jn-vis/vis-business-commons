package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntityValidation;
import com.ccp.especifications.db.utils.decorators.configurations.CcpNoValidation;
import com.ccp.especifications.db.utils.decorators.engine.CcpEntityFactory;

@CcpEntitySpecifications(
		changeStatus = @CcpEntityValidation(afterOperation = {}, beforeOperation = {}, jsonValidationClass = CcpNoValidation.class),
		delete = @CcpEntityValidation(afterOperation = {}, beforeOperation = {}, jsonValidationClass = CcpNoValidation.class),
	    save = @CcpEntityValidation(afterOperation = {}, beforeOperation = {}, jsonValidationClass = CcpNoValidation.class),
		cacheableEntity = true
)
public class VisEntityVirtualHashGrouper{

	public static final CcpEntity ENTITY = new CcpEntityFactory(VisEntityVirtualHashGrouper.class).entityInstance;

	public static enum Fields implements CcpEntityField{
		seniority(true), synonym(true),disponibility(true), 
		pcd(true), moneyValue(true), moneyType(true), 
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
