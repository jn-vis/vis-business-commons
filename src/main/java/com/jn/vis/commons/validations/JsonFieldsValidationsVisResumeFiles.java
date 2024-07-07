package com.jn.vis.commons.validations;

import com.ccp.constantes.CcpConstants;
import com.ccp.validation.annotations.ObjectTextSize;
import com.ccp.validation.annotations.Regex;
import com.ccp.validation.annotations.SimpleObject;
import com.ccp.validation.annotations.ValidationRules;
import com.ccp.validation.enums.ObjectTextSizeValidations;
import com.ccp.validation.enums.SimpleObjectValidations;

@ValidationRules(
		regex = {
				@Regex(value = CcpConstants.EMAIL_REGEX, fields = "originalEmail")
		},

		simpleObject = {
				@SimpleObject(rule = SimpleObjectValidations.requiredFields, fields = { 
						"name",
						"fileName",
						"resumeText", 
						"observations", 
						"resumeBase64", 
						"originalEmail",
						}),
			},
		objectTextSize = {
				@ObjectTextSize(rule = ObjectTextSizeValidations.equalsOrLessThan, 
						fields = { "observations" }, bound = 500),
				@ObjectTextSize(rule = ObjectTextSizeValidations.equalsOrLessThan, 
						fields = { "resumeBase64" }, bound = 4_200_000),
				@ObjectTextSize(rule = ObjectTextSizeValidations.equalsOrLessThan, 
						fields = { "resumeText" }, bound = 2_100_000),
				@ObjectTextSize(rule = ObjectTextSizeValidations.equalsOrGreaterThan, 
						fields = { "resumeBase64" }, bound = 512),
				@ObjectTextSize(rule = ObjectTextSizeValidations.equalsOrGreaterThan, 
						fields = { "resumeText" }, bound = 512),
				@ObjectTextSize(rule = ObjectTextSizeValidations.equalsOrGreaterThan, 
				fields = {"name"}, bound = 3), //bound = 10), 
				@ObjectTextSize(rule = ObjectTextSizeValidations.equalsOrLessThan, 
						fields = {"name"}, bound = 100), //bound = 50), 
				@ObjectTextSize(rule = ObjectTextSizeValidations.equalsOrGreaterThan, 
				fields = {"fileName"}, bound = 40), //bound = 10), 
				@ObjectTextSize(rule = ObjectTextSizeValidations.equalsOrLessThan, 
				fields = {"fileName"}, bound = 41), //bound = 50), 
		}
)
public class JsonFieldsValidationsVisResumeFiles {

}
