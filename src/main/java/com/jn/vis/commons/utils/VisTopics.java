package com.jn.vis.commons.utils;

import com.ccp.especifications.mensageria.sender.CcpTopic;

public enum VisTopics  implements CcpTopic {
	saveResume {
		public String getTopicName() {
			return null;
		}
	},
	savePosition {
		public String getTopicName() {
			return null;
		}
	},
	inactivateResume {
		public String getTopicName() {
			return null;
		}
	},
	inactivatePosition {
		public String getTopicName() {
			return null;
		}
	},
	sendResumesToThisPosition {
		@Override
		public String getTopicName() {
			return null;
		}
	}
	;
	public abstract String getTopicName();

}
