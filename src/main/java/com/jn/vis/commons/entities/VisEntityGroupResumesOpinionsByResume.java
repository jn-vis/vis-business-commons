package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntityGroupResumesOpinionsByResume extends JnAuditableEntity{
	private VisEntityGroupResumesOpinionsByResume() {
		super(Fields.values());
	}
	
	public static final VisEntityGroupResumesOpinionsByResume INSTANCE = new VisEntityGroupResumesOpinionsByResume();
	
	public static enum Fields implements CcpEntityField{
		recruiter(true), email(true), opinion(false),
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
