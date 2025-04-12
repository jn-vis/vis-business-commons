package com.vis.commons.business.position;

import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.jn.commons.mensageria.JnTopic;
import com.vis.commons.entities.VisEntityPosition;

public class VisBusinessDuplicateFieldEmailToFieldMasters implements JnTopic{

	public static final VisBusinessDuplicateFieldEmailToFieldMasters INSTANCE = new VisBusinessDuplicateFieldEmailToFieldMasters();
	
	private VisBusinessDuplicateFieldEmailToFieldMasters() {}
	
	
	public CcpJsonRepresentation apply(CcpJsonRepresentation json) {
		CcpJsonRepresentation duplicateValueFromField = json.duplicateValueFromField(VisEntityPosition.Fields.email.name(), "masters");
		return duplicateValueFromField;
	}

}
