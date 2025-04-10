package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntityDecorators;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntityTwin;
import com.ccp.especifications.db.utils.decorators.engine.CcpEntityConfigurator;
import com.ccp.especifications.db.utils.decorators.engine.CcpEntityFactory;
import com.jn.commons.json.transformers.JnJsonTransformerPutEmailHash;
import com.jn.commons.utils.JnEntityVersionable;
import com.vis.commons.json.transformers.VisJsonTransformerPutEmailHashAndDomainRecruiter;

@CcpEntityDecorators(decorators = JnEntityVersionable.class)
@CcpEntityTwin(twinEntityName = "inactive_position")
@CcpEntitySpecifications(cacheableEntity = true, stepsBeforeSaveEntity = {JnJsonTransformerPutEmailHash.class, VisJsonTransformerPutEmailHashAndDomainRecruiter.class})
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
