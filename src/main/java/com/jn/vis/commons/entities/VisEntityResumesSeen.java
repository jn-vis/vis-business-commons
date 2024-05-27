package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnDiposableRecordTimeExpiration;
import com.jn.commons.entities.base.JnDisposableEntity;

public class VisEntityResumesSeen extends JnDisposableEntity{
	private VisEntityResumesSeen() {
		super(JnDiposableRecordTimeExpiration.hourly, Fields.values());
	}
	
	public static final VisEntityResumesSeen INSTANCE = new VisEntityResumesSeen();
	
	public static enum Fields implements CcpEntityField{
		email(true), resume(false),
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
