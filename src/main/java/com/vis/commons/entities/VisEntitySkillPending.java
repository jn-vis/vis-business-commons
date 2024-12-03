package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.CcpEntityTwin;
import com.ccp.especifications.db.utils.decorators.CcpEntityFactory;

@CcpEntityTwin(twinEntityName = "skill_approved")
@CcpEntitySpecifications(cacheableEntity = true)
public class VisEntitySkillPending{

	public static final CcpEntity ENTITY = new CcpEntityFactory(VisEntitySkillPending.class).entityInstance;
	
	public static enum Fields implements CcpEntityField{
		skill(true), synonym(false), prerequisite(false), ranking(false)
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
