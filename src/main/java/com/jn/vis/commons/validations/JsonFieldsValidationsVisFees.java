package com.jn.vis.commons.validations;

import com.ccp.validation.annotations.AllowedValues;
import com.ccp.validation.annotations.SimpleObject;
import com.ccp.validation.annotations.ValidationRules;
import com.ccp.validation.enums.AllowedValuesValidations;
import com.ccp.validation.enums.SimpleObjectValidations;

@ValidationRules(simpleObject = {
			@SimpleObject(fields = "fees", rule = SimpleObjectValidations.requiredFields)
		}
)

public class JsonFieldsValidationsVisFees {

}
