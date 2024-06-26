package com.jn.vis.commons.validations;

import com.ccp.constantes.CcpConstants;
import com.ccp.validation.annotations.AllowedValues;
import com.ccp.validation.annotations.ObjectNumbers;
import com.ccp.validation.annotations.SimpleArray;
import com.ccp.validation.annotations.SimpleObject;
import com.ccp.validation.annotations.ObjectTextSize;
import com.ccp.validation.annotations.Regex;
import com.ccp.validation.annotations.ValidationRules;
import com.ccp.validation.annotations.Year;
import com.ccp.validation.enums.AllowedValuesValidations;
import com.ccp.validation.enums.ObjectNumberValidations;
import com.ccp.validation.enums.SimpleArrayValidations;
import com.ccp.validation.enums.ObjectTextSizeValidations;
import com.ccp.validation.enums.SimpleObjectValidations;
import com.ccp.validation.enums.YearValidations;

@ValidationRules(

		regex = {
				@Regex(value = CcpConstants.EMAIL_REGEX, fields = "email")
		},
		simpleObject = {
				@SimpleObject(rule = SimpleObjectValidations.requiredFields, fields = { 
						"companiesNotAllowed", 
						"ddd", 
						"desiredJob", 
						"disponibility", 
						"disabilities",
						"experience",
						"lastJob", 
						"name",
						"observations", 
						"resumeBase64", 
						"resumeText", 
						"skill",
						}),
				@SimpleObject(rule = SimpleObjectValidations.requiredAtLeastOne, fields = { "clt", "pj" }),
				@SimpleObject(rule = SimpleObjectValidations.nonRepeatedLists, fields = { "ddd", "disabilities",
						"companiesNotAllowed", "skill" }),
				@SimpleObject(rule = SimpleObjectValidations.integerFields, fields = { "disponibility" }), }

		, allowedValues = {
				@AllowedValues(rule = AllowedValuesValidations.arrayWithAllowedNumbers, fields = { "ddd" },//TODO COMO INTERNACIONALIZAR ISSO???
						allowedValues = { "10", "61", "62", "64", "65", "66", "67", "82", "71", "73", "74", "75", "77",
								"85", "88", "98", "99", "83", "81", "87", "86", "89", "84", "79", "68", "96", "92",
								"97", "91", "93", "94", "69", "95", "63", "27", "28", "31", "32", "33", "34", "35",
								"37", "38", "21", "22", "24", "11", "12", "13", "14", "15", "16", "17", "18", "19",
								"41", "42", "43", "44", "45", "46", "51", "53", "54	", "55", "47", "48", "49" }),
				@AllowedValues(rule = AllowedValuesValidations.arrayWithAllowedTexts, fields = { "disabilities" },
						allowedValues = { "física/motora", "intelectual/mental", "visual", "auditiva" })
				//TODO COMO INTERNACIONALIZAR ISSO???

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
				@ObjectTextSize(rule = ObjectTextSizeValidations.equalsOrLessThan, 
						fields = { "desiredJob", "lastJob" }, bound = 100),
				@ObjectTextSize(rule = ObjectTextSizeValidations.equalsOrGreaterThan, 
						fields = {"name"}, bound = 3), //bound = 10), 
				@ObjectTextSize(rule = ObjectTextSizeValidations.equalsOrLessThan, 
						fields = {"name"}, bound = 100), //bound = 50), 
				
		},

		simpleArray = { @SimpleArray(rule = SimpleArrayValidations.notEmptyArray, fields = { "ddd", "resumeWords" }),
				@SimpleArray(rule = SimpleArrayValidations.integerItems, fields = { "ddd" }), }

		, year = { @Year(rule = YearValidations.equalsOrLessThan, fields = { "experience" }, bound = 70),
				@Year(rule = YearValidations.equalsOrGreaterThan, fields = { "experience" }, bound = 0),

		},

		objectNumbers = {
				@ObjectNumbers(rule = ObjectNumberValidations.equalsOrGreaterThan, bound = 1000, fields = { "btc",
						"clt", "pj" }),
				@ObjectNumbers(rule = ObjectNumberValidations.equalsOrLessThan, bound = 100000, fields = { "btc", "clt",
						"pj" }) }

)
public class JsonFieldsValidationsVisResume {

}
