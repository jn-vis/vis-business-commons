package com.jn.vis.commons.validations;

import com.ccp.validation.annotations.SimpleObject;
import com.ccp.validation.annotations.CcpJsonFieldsValidation;
import com.ccp.validation.enums.SimpleObjectValidations;

@CcpJsonFieldsValidation(simpleObject = {
			@SimpleObject(fields = "fees", rule = SimpleObjectValidations.requiredFields)
		}
)

public class JsonFieldsValidationsVisFees {

}
