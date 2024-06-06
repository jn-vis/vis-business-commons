package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnDiposableRecordTimeExpiration;
import com.jn.commons.entities.base.JnDisposableEntity;

public class VisEntityGroupResumesPerceptionsByRecruiter extends JnDisposableEntity{
	
	private VisEntityGroupResumesPerceptionsByRecruiter() {
		super(JnDiposableRecordTimeExpiration.yearly, Fields.values());
	}
	
	public static final VisEntityGroupResumesPerceptionsByRecruiter INSTANCE = new VisEntityGroupResumesPerceptionsByRecruiter();
	
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
