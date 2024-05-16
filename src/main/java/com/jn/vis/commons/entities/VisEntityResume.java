package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.validation.annotations.ValidationRules;
import com.jn.commons.entities.base.JnAuditableEntity;
import com.jn.vis.commons.validations.JsonFieldsValidationsVisResume;

@ValidationRules(rulesClass = JsonFieldsValidationsVisResume.class)
public class VisEntityResume extends JnAuditableEntity{
	
	public static final VisEntityResume INSTANCE = new VisEntityResume();
	
	private VisEntityResume() {
		super(Fields.values());
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
		lastUpdate(false),
		name(false),
		observations(false), 
		pj(false), 
		resumeBase64(false),
		resumeText(false),
		skill(false), 
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
