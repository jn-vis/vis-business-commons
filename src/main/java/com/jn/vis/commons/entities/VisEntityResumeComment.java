package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnBaseEntity;

public class VisEntityResumeComment extends JnBaseEntity{
	private VisEntityResumeComment() {
		super(Fields.values());
	}

	public static final VisEntityResumeComment INSTANCE = new VisEntityResumeComment();

	public static enum Fields implements CcpEntityField{
		recruiter(true), email(true), comment(false)
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
