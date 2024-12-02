package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.CcpFactoryEntity;

@CcpEntitySpecifications(cacheableEntity = true, pathToFirstRecords = "C:\\eclipse-workspaces\\ccp\\jn\\jn-dependency-chooser-documentation-and-junit-testing\\documentation\\skills\\synonyms.json")
public class VisEntitySkill{
	public static final CcpEntity ENTITY = CcpFactoryEntity.getEntityInstance(VisEntitySkill.class);
	
	public static enum Fields implements CcpEntityField{
		parent(false), positionsCount(false), preRequisite(false), ranking(false), 
		similar(false), skill(true), synonym(false)
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
