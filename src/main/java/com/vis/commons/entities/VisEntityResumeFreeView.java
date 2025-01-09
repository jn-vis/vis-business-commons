package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpEntityConfigurator;
import com.ccp.especifications.db.utils.decorators.CcpEntityExpurgable;
import com.ccp.especifications.db.utils.decorators.CcpEntityExpurgableOptions;
import com.ccp.especifications.db.utils.decorators.CcpEntityFactory;
import com.ccp.especifications.db.utils.decorators.CcpEntitySpecifications;
import com.jn.commons.json.transformers.JnJsonTransformerPutEmailHash;
import com.jn.commons.utils.JnEntityExpurgable;
import com.vis.commons.json.transformers.VisJsonTransformerPutEmailHashAndDomainRecruiter;

@CcpEntitySpecifications(cacheableEntity = true, jsonTransformations = {JnJsonTransformerPutEmailHash.class, VisJsonTransformerPutEmailHashAndDomainRecruiter.class})
@CcpEntityExpurgable(expurgableEntityFactory = JnEntityExpurgable.class, expurgTime = CcpEntityExpurgableOptions.monthly)
public class VisEntityResumeFreeView implements CcpEntityConfigurator {

	public static final CcpEntity ENTITY = new CcpEntityFactory(VisEntityResumeFreeView.class).entityInstance;

	public static enum Fields implements CcpEntityField{
		recruiter(true), email(true), date(false), timestamp(false)
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
