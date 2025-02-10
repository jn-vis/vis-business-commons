package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpEntityConfigurator;
import com.ccp.especifications.db.utils.decorators.CcpEntityDecorators;
import com.ccp.especifications.db.utils.decorators.CcpEntityFactory;
import com.ccp.especifications.db.utils.decorators.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.CcpEntityTwin;
import com.jn.commons.json.transformers.JnJsonTransformerPutEmailHash;
import com.jn.commons.utils.JnEntityVersionable;

@CcpEntityDecorators(decorators = JnEntityVersionable.class)
@CcpEntityTwin(twinEntityName = "inactive_resume")
@CcpEntitySpecifications(cacheableEntity = true, jsonTransformations = {JnJsonTransformerPutEmailHash.class})
public class VisEntityResume implements CcpEntityConfigurator {
	
	public static final CcpEntity ENTITY = new CcpEntityFactory(VisEntityResume.class).entityInstance;
	
	public static enum Fields implements CcpEntityField{
		btc(false), // VEM DO FRONT
		clt(false), // VEM DO FRONT
		companiesNotAllowed(false), // VEM DO FRONT 
		date(false),// AUTOMATICO
		ddd(false), // VEM DO FRONT
		desiredJob(false), // VEM DO FRONT
		disabilities(false), // VEM DO FRONT
		disponibility(false), // VEM DO FRONT
		email(true),// VEM DO FRONT
		experience(false), // VEM DO FRONT
		lastJob(false), // VEM DO FRONT
		pj(false), // VEM DO FRONT
		skill(false), // CALCULADO
		timestamp(false),//AUTOMATICO
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
