package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpEntityVersionable;
import com.ccp.especifications.db.utils.decorators.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.CcpEntityTwin;
import com.ccp.especifications.db.utils.decorators.CcpEntityConfigurator;
import com.ccp.especifications.db.utils.decorators.CcpEntityFactory;
import com.jn.commons.utils.JnEntityVersionable;

@CcpEntityVersionable(versionableEntityFactory = JnEntityVersionable.class)
@CcpEntityTwin(twinEntityName = "inactive_position")
@CcpEntitySpecifications(cacheableEntity = true)
public class VisEntityPosition implements CcpEntityConfigurator {

	public static final CcpEntity ENTITY = new CcpEntityFactory(VisEntityPosition.class).entityInstance;

	public static enum Fields implements CcpEntityField{
		btc(false), 
		channel(false), 
		clt(false), 
		contactChannel(false), 
		date(false),
		ddd(false), 
		description(false), 
		desiredSkill(false), 
		disponibility(false), 
		email(true), 
		expireDate(false), 
		frequency(false), 
		pcd(false), 
		pj(false),  
		requiredSkill(false), 
		seniority(true), 
		sortFields(false), 
		timestamp(false), 
		title(true), 
		
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
