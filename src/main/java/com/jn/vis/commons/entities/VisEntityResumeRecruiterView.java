package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnDisposableEntity;
import com.jn.commons.entities.base.JnDiposableRecordTimeExpiration;

public class VisEntityResumeRecruiterView extends JnDisposableEntity{
	private VisEntityResumeRecruiterView() {
		super(JnDiposableRecordTimeExpiration.monthly, Fields.values());
	}

	public static final VisEntityResumeRecruiterView INSTANCE = new VisEntityResumeRecruiterView();

	public static enum Fields implements CcpEntityField{
		recruiter(true), email(true), date(false)
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
