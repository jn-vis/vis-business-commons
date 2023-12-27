package com.jn.commons.entities.vis;

import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.CcpTimeOption;
import com.jn.commons.entities.JnBaseEntity;

public class VisEntityStatement extends JnBaseEntity{
	public VisEntityStatement() {
		super(false, CcpTimeOption.ddMMyyyyHHmm, Fields.values());
	}
	public static enum Fields implements CcpEntityField{
		walletPayer(true),
		walletReceiver(true),
		transactionDate(true),
		ammount(false),
		withdrawReason(false),
		;
		private final boolean primaryKey;

		private Fields(boolean primaryKey) {
			this.primaryKey = primaryKey;
		}

		@Override
		public boolean isPrimaryKey() {
			return this.primaryKey;
		}

	}
}
