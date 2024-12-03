package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpEntityVersionable;
import com.ccp.especifications.db.utils.decorators.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.CcpEntityTwin;
import com.ccp.especifications.db.utils.decorators.CcpEntityFactory;
import com.jn.commons.utils.JnEntityVersionable;

@CcpEntityVersionable(versionableEntityFactory = JnEntityVersionable.class)
@CcpEntityTwin(twinEntityName = "inactive_resume")
@CcpEntitySpecifications(cacheableEntity = true)
public class VisEntityResume{
	
	public static final CcpEntity ENTITY = new CcpEntityFactory(VisEntityResume.class).entityInstance;
	
	public static enum Fields implements CcpEntityField{
		btc(false), 
		clt(false), 
		companiesNotAllowed(false), 
		date(false),
		ddd(false), 
		desiredJob(false), 
		disabilities(false), 
		disponibility(false), 
		email(true),
		experience(false), 
		lastJob(false), 
		pj(false), 
		skill(false), 
		timestamp(false),
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
