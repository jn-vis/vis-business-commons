package com.jn.vis.commons.entities;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.jn.commons.entities.base.JnAuditableEntity;

public class VisEntityVirtualHashGrouper extends JnAuditableEntity{

	private VisEntityVirtualHashGrouper() {
		super(Fields.values());
	}
	
	public static final VisEntityVirtualHashGrouper INSTANCE = new VisEntityVirtualHashGrouper();

	public static enum Fields implements CcpEntityField{
		skill(true), seniority(true), synonym(true),
		disponibility(true), pcd(true), moneyValue(true), 
		moneyType(true), 
		;
		private final boolean primaryKey;

		private Fields(boolean primaryKey) {
			this.primaryKey = primaryKey;
		}

		public boolean isPrimaryKey() {
			return this.primaryKey;
		}
	}

	public boolean isVirtual() {
		return true;
	}
}
