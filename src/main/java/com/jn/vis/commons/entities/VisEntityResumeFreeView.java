package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnDiposableRecordTimeExpiration;
import com.jn.commons.entities.base.JnDisposableEntity;

public class VisEntityResumeFreeView extends JnDisposableEntity{
	
	private VisEntityResumeFreeView() {
		super(JnDiposableRecordTimeExpiration.monthly, Fields.values());
	}

	public static final VisEntityResumeFreeView INSTANCE = new VisEntityResumeFreeView();

	public static enum Fields implements CcpEntityField{
		recruiter(true), email(true), date(false), timestamp(false)
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
