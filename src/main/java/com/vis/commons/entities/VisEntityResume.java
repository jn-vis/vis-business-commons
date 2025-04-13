package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntityDecorators;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntityOperationSpecification;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntitySpecifications;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntityTransferOperationEspecification;
import com.ccp.especifications.db.utils.decorators.configurations.CcpEntityTwin;
import com.ccp.especifications.db.utils.decorators.configurations.CcpIgnoreFieldsValidation;
import com.ccp.especifications.db.utils.decorators.engine.CcpEntityConfigurator;
import com.ccp.especifications.db.utils.decorators.engine.CcpEntityFactory;
import com.jn.entities.decorators.JnEntityVersionable;
import com.jn.json.transformers.JnJsonTransformerPutEmailHash;
import com.vis.commons.business.resume.VisCommonsBusinessExtractSkillsFromResumeText;
import com.vis.commons.business.resume.VisCommonsBusinessExtractTextFromResume;
import com.vis.commons.business.resume.VisCommonsBusinessSaveResumeInBucket;

@CcpEntityDecorators(decorators = JnEntityVersionable.class)
@CcpEntityTwin(twinEntityName = "inactive_resume")
@CcpEntitySpecifications(
		inactivate = @CcpEntityTransferOperationEspecification(whenRecordToTransferIsFound = @CcpEntityOperationSpecification(afterOperation = {}, beforeOperation = {}, classWithFieldsValidationsRules = CcpIgnoreFieldsValidation.class), whenRecordToTransferIsNotFound = @CcpEntityOperationSpecification(afterOperation = {}, beforeOperation = {}, classWithFieldsValidationsRules = CcpIgnoreFieldsValidation.class)),
		reactivate = @CcpEntityTransferOperationEspecification(whenRecordToTransferIsFound = @CcpEntityOperationSpecification(afterOperation = {}, beforeOperation = {}, classWithFieldsValidationsRules = CcpIgnoreFieldsValidation.class), whenRecordToTransferIsNotFound = @CcpEntityOperationSpecification(afterOperation = {}, beforeOperation = {}, classWithFieldsValidationsRules = CcpIgnoreFieldsValidation.class)),
		delete = @CcpEntityOperationSpecification(afterOperation = {}, beforeOperation = {}, classWithFieldsValidationsRules = CcpIgnoreFieldsValidation.class),
	    save = @CcpEntityOperationSpecification(afterOperation = {VisCommonsBusinessSaveResumeInBucket.class}, beforeOperation = {JnJsonTransformerPutEmailHash.class, VisCommonsBusinessExtractTextFromResume.class, VisCommonsBusinessExtractSkillsFromResumeText.class}, classWithFieldsValidationsRules = CcpIgnoreFieldsValidation.class),
		cacheableEntity = true
)
		
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
