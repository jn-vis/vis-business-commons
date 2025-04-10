package com.vis.commons.utils;

import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.jn.commons.mensageria.JnTopic;
import com.ccp.jn.commons.messages.JnCommonsSendMessage;
import com.jn.commons.entities.JnEntityEmailMessageSent;
import com.jn.commons.entities.JnEntityEmailTemplateMessage;

public enum VisAsyncBusinessSendEmailMessageAndRegisterEmailSent implements JnTopic{

	
	resumeSuccessSaving,
	resumeErrorSaving
;

	public CcpJsonRepresentation apply(CcpJsonRepresentation json) {

		CcpJsonRepresentation put = json
				.renameField("originalEmail", JnEntityEmailMessageSent.Fields.email.name())
				.put(JnEntityEmailMessageSent.Fields.subjectType.name(), this.name());
				
			String language = json.getAsObject(JnEntityEmailTemplateMessage.Fields.language.name());
			
			JnCommonsSendMessage sender = new JnCommonsSendMessage();
			sender
			.addDefaultProcessForEmailSending()
			.soWithAllAddedProcessAnd()
			.withTheTemplateEntity(this.name())
			.andWithTheEntityToBlockMessageResend(JnEntityEmailMessageSent.ENTITY)
			.andWithTheMessageValuesFromJson(put)
			.andWithTheSupportLanguage(language)
			.sendAllMessages()
			;

		
		return json;
	}

	public Class<?> validationClass() {
		return this.getClass();
	}

}
