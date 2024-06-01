package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnDiposableRecordTimeExpiration;
import com.jn.commons.entities.base.JnDisposableEntity;

public class VisEntityGroupPositionsByRecruiter extends JnDisposableEntity{
	private VisEntityGroupPositionsByRecruiter() {
		super(JnDiposableRecordTimeExpiration.yearly, Fields.values());
	}
	
	public static final VisEntityGroupPositionsByRecruiter INSTANCE = new VisEntityGroupPositionsByRecruiter();
	
	public static enum Fields implements CcpEntityField{
		email(true),   position(false), 
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
