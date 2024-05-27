package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntityPositionResumes extends JnAuditableEntity{
	private VisEntityPositionResumes() {
		super(Fields.values());
	}
	
	public static final VisEntityPositionResumes INSTANCE = new VisEntityPositionResumes();
	
	public static enum Fields implements CcpEntityField{
		recruiter(true), title(true), resume(false), 
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
