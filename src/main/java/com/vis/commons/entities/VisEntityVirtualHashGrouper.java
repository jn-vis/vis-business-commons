package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.CcpEntityConfigurator;
import com.ccp.especifications.db.utils.decorators.CcpEntityFactory;

@CcpEntitySpecifications(cacheableEntity = false)
public class VisEntityVirtualHashGrouper implements CcpEntityConfigurator {

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
