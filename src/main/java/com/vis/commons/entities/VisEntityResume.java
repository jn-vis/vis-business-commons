package com.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.validation.annotations.ValidationRules;
import com.jn.commons.entities.base.JnAuditableAndStatusChangebleEntity;

@ValidationRules()
public class VisEntityResume extends JnAuditableAndStatusChangebleEntity{
	
	public static final VisEntityResume INSTANCE = new VisEntityResume();
	
	private VisEntityResume() {
		super("inactivate_resume", Fields.values());
	}
	public static enum Fields implements CcpEntityField{
		companiesNotAllowed(false), 
		btc(false), 
		clt(false), 
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
		date(false)
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
