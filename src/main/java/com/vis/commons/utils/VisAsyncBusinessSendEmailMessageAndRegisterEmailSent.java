package com.vis.commons.utils;

import com.ccp.decorators.CcpJsonRepresentation;
import com.jn.entities.JnEntityEmailMessageSent;
import com.jn.entities.JnEntityEmailTemplateMessage;
import com.jn.mensageria.JnTopic;
import com.jn.messages.JnSendMessage;

public enum VisAsyncBusinessSendEmailMessageAndRegisterEmailSent implements JnTopic{

	
	resumeSuccessSaving,
	resumeErrorSaving
;

	public CcpJsonRepresentation apply(CcpJsonRepresentation json) {

		CcpJsonRepresentation put = json
				.renameField("originalEmail", JnEntityEmailMessageSent.Fields.email.name())
				.put(JnEntityEmailMessageSent.Fields.subjectType.name(), this.name());
				
			String language = json.getAsObject(JnEntityEmailTemplateMessage.Fields.language.name());
			
			JnSendMessage sender = new JnSendMessage();
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
