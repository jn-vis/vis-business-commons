package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntityTwin;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntityValidation;
import com.ccp.especifications.db.utils.decorators.configurations.CcpNoValidation;
import com.ccp.especifications.db.utils.decorators.engine.CcpEntityConfigurator;
import com.ccp.especifications.db.utils.decorators.engine.CcpEntityFactory;

@CcpEntityTwin(twinEntityName = "skill_approved")
@CcpEntitySpecifications(
		changeStatus = @CcpEntityValidation(afterOperation = {}, beforeOperation = {}, jsonValidationClass = CcpNoValidation.class),
		delete = @CcpEntityValidation(afterOperation = {}, beforeOperation = {}, jsonValidationClass = CcpNoValidation.class),
	    save = @CcpEntityValidation(afterOperation = {}, beforeOperation = {}, jsonValidationClass = CcpNoValidation.class),
		cacheableEntity = true
)
public class VisEntitySkillPending implements CcpEntityConfigurator {

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
