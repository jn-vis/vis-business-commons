package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpFactoryEntity;
import com.ccp.validation.annotations.ValidationRules;

//super("inactive_resume", Fields.values());
@ValidationRules()
public class VisEntityResume{
	
	public static final CcpEntity ENTITY = CcpFactoryEntity.getEntityInstance(VisEntityVirtualHashGrouper.class);
	
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
