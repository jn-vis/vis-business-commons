package com.vis.commons.utils;

import java.util.function.Function;

import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.jn.commons.messages.JnCommonsSendMessage;
import com.jn.commons.entities.JnEntityEmailMessageSent;
import com.jn.commons.entities.JnEntityEmailTemplateMessage;

public class VisCommonsBusinessNotifyResumeOwner implements Function<CcpJsonRepresentation, CcpJsonRepresentation>{

	public final CcpJsonRepresentation apply(CcpJsonRepresentation json) {
		CcpJsonRepresentation put = json
				.renameField("originalEmail", JnEntityEmailMessageSent.Fields.email.name())
				.put(JnEntityEmailMessageSent.Fields.subjectType.name(), this.getClass().getSimpleName());
				
			String language = json.getAsObject(JnEntityEmailTemplateMessage.Fields.language.name());
			
			JnCommonsSendMessage sender = new JnCommonsSendMessage();
			sender
			.addDefaultProcessForEmailSending()
			.soWithAllAddedProcessAnd()
			.withTheTemplateEntity(this.getClass().getSimpleName())
			.andWithTheEntityToBlockMessageResend(JnEntityEmailMessageSent.ENTITY)
			.andWithTheMessageValuesFromJson(put)
			.andWithTheSupportLanguage(language)
			.sendAllMessages()
			;

		
		return json;
	}

}
