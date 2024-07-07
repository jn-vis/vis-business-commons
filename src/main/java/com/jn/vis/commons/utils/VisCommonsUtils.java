package com.jn.vis.commons.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.ccp.constantes.CcpConstants;
import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.decorators.CcpPropertiesDecorator;
import com.ccp.decorators.CcpStringDecorator;
import com.ccp.decorators.CcpTextDecorator;
import com.ccp.especifications.cache.CcpCacheDecorator;
import com.ccp.especifications.file.bucket.CcpFileBucketOperation;
import com.jn.vis.commons.cache.tasks.ReadSkillsFromDataBase;
import com.vis.commons.entities.VisEntityResume;

public class VisCommonsUtils {
	
	public static String getTenant() {
		CcpStringDecorator ccpStringDecorator = new CcpStringDecorator("application_properties");
		CcpPropertiesDecorator propertiesFrom = ccpStringDecorator.propertiesFrom();
		CcpJsonRepresentation systemProperties = propertiesFrom.environmentVariablesOrClassLoaderOrFile();
		String tenant = systemProperties.getAsString("tenant");
		return tenant;
	}
	public static boolean isInsufficientFunds(int itemsCount, 
			CcpJsonRepresentation fee, CcpJsonRepresentation balance) {
	
		Double feeValue = fee.getAsDoubleNumber("fee");
		
		Double balanceValue = balance.getAsDoubleNumber("balance");
		
		Double totalCostToThisRecruiter = feeValue * itemsCount;
		
		boolean insuficientFunds = balanceValue <= totalCostToThisRecruiter;
		
		return insuficientFunds;
	}
	
	public static CcpJsonRepresentation getJsonWithSkills(
			CcpJsonRepresentation json
			,String fieldTextToRead
			,String fieldToPut
			) {
		
		CcpCacheDecorator cache = new CcpCacheDecorator("skills");
		List<CcpJsonRepresentation> resultAsList = cache.get(ReadSkillsFromDataBase.INSTANCE, 86400);
		
		CcpTextDecorator text = json.getAsTextDecorator(fieldTextToRead).sanitize();
		List<CcpJsonRepresentation> allSkills = new ArrayList<>();
		for (CcpJsonRepresentation skill : resultAsList) {
		
			Set<String> allSynonyms = 
					skill.getAsJsonList("synonym")
					.stream()
					.map(synonym -> synonym.getAsString("skill"))
					.collect(Collectors.toSet());
			
			Set<String> wordsThatWasFoundDirectlyInThisText = allSynonyms
			.stream()
			.filter(synonym -> text.contains(synonym))
			.collect(Collectors.toSet());

			boolean thisSkillWasNotFoundInThisText = wordsThatWasFoundDirectlyInThisText.isEmpty();
			
			if(thisSkillWasNotFoundInThisText) {
				continue;
			}
			
			List<String> parents = skill.getAsStringList("parent");
			Set<String> wordsThatWasFoundAsSynonymInThisText = allSynonyms
			.stream()
			.filter(synonym -> wordsThatWasFoundDirectlyInThisText.contains(synonym) == false)
			.collect(Collectors.toSet());
			List<CcpJsonRepresentation> skills = wordsThatWasFoundDirectlyInThisText.stream().map(
					word -> CcpConstants.EMPTY_JSON
										.put("synonym", wordsThatWasFoundAsSynonymInThisText)
										.put("parent", parents)
										.put("skill", word)
					).collect(Collectors.toList());
			allSkills.addAll(skills);
		}
		
		CcpJsonRepresentation jsonWithSkills = json.put(fieldToPut, allSkills);
		return jsonWithSkills;
	}
	public static CcpJsonRepresentation getResumeFromBucket(CcpJsonRepresentation json) {
		String email = json.getAsString("email");
		String folder = "resumes/" + email;
		String file = "" + json.getAsLongNumber(VisEntityResume.Fields.timestamp.name());
		String tenant = VisCommonsUtils.getTenant();
	
		String resumeJson = CcpFileBucketOperation.get.execute(tenant, folder, file);
		CcpJsonRepresentation resume = new CcpJsonRepresentation(resumeJson);
		return resume;
	}

}
