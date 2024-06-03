package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnDiposableRecordTimeExpiration;
import com.jn.commons.entities.base.JnDisposableEntity;

public class VisEntityGroupPositionsByResume  extends JnDisposableEntity{
	
	private VisEntityGroupPositionsByResume() {
		super(JnDiposableRecordTimeExpiration.yearly, Fields.values());
	}

	public static final VisEntityGroupPositionsByResume INSTANCE = new VisEntityGroupPositionsByResume();

	public static enum Fields implements CcpEntityField{
		detail(false), email(true), listSize(true), from(true)
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
