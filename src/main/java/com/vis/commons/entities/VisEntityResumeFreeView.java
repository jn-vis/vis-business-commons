package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpEntitySpecifications;
import com.jn.commons.utils.JnEntityExpurgable;
import com.ccp.especifications.db.utils.decorators.CcpEntityConfigurator;
import com.ccp.especifications.db.utils.decorators.CcpEntityExpurgable;
import com.ccp.especifications.db.utils.decorators.CcpEntityExpurgableOptions;
import com.ccp.especifications.db.utils.decorators.CcpEntityFactory;

@CcpEntitySpecifications(cacheableEntity = true)
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
