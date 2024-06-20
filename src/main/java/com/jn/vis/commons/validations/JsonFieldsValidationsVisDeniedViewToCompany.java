package com.jn.vis.commons.validations;

import com.ccp.validation.annotations.SimpleObject;
import com.ccp.validation.annotations.ValidationRules;
import com.ccp.validation.enums.SimpleObjectValidations;

@ValidationRules(simpleObject = {
		@SimpleObject(fields = "domain", rule = SimpleObjectValidations.requiredFields)
		}
)

public class JsonFieldsValidationsVisDeniedViewToCompany {

}
