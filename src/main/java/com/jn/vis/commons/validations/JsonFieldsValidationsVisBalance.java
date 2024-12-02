package com.jn.vis.commons.validations;

import com.ccp.validation.annotations.SimpleObject;
import com.ccp.validation.annotations.CcpJsonValidation;
import com.ccp.validation.enums.SimpleObjectValidations;

@CcpJsonValidation(simpleObject = {
		@SimpleObject(fields = "balance", rule = SimpleObjectValidations.requiredFields)
	}
)
public class JsonFieldsValidationsVisBalance {

}
