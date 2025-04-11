package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntityValidation;
import com.ccp.especifications.db.utils.decorators.configurations.CcpNoValidation;
import com.ccp.especifications.db.utils.decorators.engine.CcpEntityConfigurator;
import com.ccp.especifications.db.utils.decorators.engine.CcpEntityFactory;
import com.jn.commons.json.transformers.JnJsonTransformerPutEmailHash;
import com.jn.commons.json.transformers.JnJsonTransformerPutFormattedCurrentDateAndCurrentTimeStamp;
import com.vis.commons.json.transformers.VisJsonTransformerPutEmailHashAndDomainRecruiter;

@CcpEntitySpecifications(
		changeStatus = @CcpEntityValidation(afterOperation = {}, beforeOperation = {}, jsonValidationClass = CcpNoValidation.class),
		delete = @CcpEntityValidation(afterOperation = {}, beforeOperation = {}, jsonValidationClass = CcpNoValidation.class),
	    save = @CcpEntityValidation(afterOperation = {}, beforeOperation = {JnJsonTransformerPutEmailHash.class, VisJsonTransformerPutEmailHashAndDomainRecruiter.class, JnJsonTransformerPutFormattedCurrentDateAndCurrentTimeStamp.class}, jsonValidationClass = CcpNoValidation.class),
		cacheableEntity = true
)
public class VisEntityResumeViewFailed implements CcpEntityConfigurator {

	public static final CcpEntity ENTITY = new CcpEntityFactory(VisEntityResumeViewFailed.class).entityInstance;
	
	public static enum Fields implements CcpEntityField{
		recruiter(true), email(true), status(true), json(false), timestamp(false),date(false),
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
