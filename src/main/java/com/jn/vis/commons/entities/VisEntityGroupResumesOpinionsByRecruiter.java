package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntityGroupResumesOpinionsByRecruiter extends JnAuditableEntity{
	private VisEntityGroupResumesOpinionsByRecruiter() {
		super(Fields.values());
	}
	
	public static final VisEntityGroupResumesOpinionsByRecruiter INSTANCE = new VisEntityGroupResumesOpinionsByRecruiter();
	
	public static enum Fields implements CcpEntityField{
		owner(true), balance(false),
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