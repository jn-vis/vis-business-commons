package com.jn.vis.commons.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.ccp.constantes.CcpConstants;
import com.ccp.decorators.CcpHashDecorator;
import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.decorators.CcpPropertiesDecorator;
import com.ccp.decorators.CcpStringDecorator;
import com.ccp.decorators.CcpTextDecorator;
import com.ccp.especifications.cache.CcpCacheDecorator;
import com.jn.vis.commons.cache.tasks.ReadResumeContent;
import com.jn.vis.commons.cache.tasks.ReadSkillsFromDataBase;

public class VisCommonsUtils {
	
	public static String getBucketFolderResume(CcpJsonRepresentation resume) {
		String resumeText = resume.getAsString("email");
		CcpStringDecorator cfd = new CcpStringDecorator(resumeText);
		CcpHashDecorator hash = cfd.hash();
		String resumeId = hash.asString("SHA1");
		String folder = "resumes/" + resumeId;
		return folder;
	}

	public static String getTenant() {
		CcpStringDecorator ccpStringDecorator = new CcpStringDecorator("application_properties");
		CcpPropertiesDecorator propertiesFrom = ccpStringDecorator.propertiesFrom();
		CcpJsonRepresentation systemProperties = propertiesFrom.environmentVariablesOrClassLoaderOrFile();
		String tenant = systemProperties.getAsString("tenant");
		return tenant;
	}

	public static String getResumeContent(String email, String contentType) {

		CcpCacheDecorator cache = getResumeCache(email, contentType);
		//TODO POSSIBILIDADE DE THROWPUT ONEROSO AQUI
		String resumeContent = cache.get(ReadResumeContent.INSTANCE, 86400);
		
		return resumeContent;
	}

	public static CcpCacheDecorator getResumeCache(String email, String contentType) {
		
		CcpJsonRepresentation put = CcpConstants.EMPTY_JSON.put("email", email).put("contentType", contentType);
	
		CcpCacheDecorator cache = new CcpCacheDecorator("resumes").incrementKeys(put);
		
		return cache;
	}
	
	public static void removeFromCache(CcpJsonRepresentation resume, String... keys) {
		
		String email = resume.getAsString("email");

		for (String key : keys) {
			
			CcpCacheDecorator resumeCache = VisCommonsUtils.getResumeCache(email, key);
			
			resumeCache.delete();
		}
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
										.put("synonyms", wordsThatWasFoundAsSynonymInThisText)
										.put("parents", parents)
										.put("skill", word)
					).collect(Collectors.toList());
			allSkills.addAll(skills);
		}
		
		CcpJsonRepresentation jsonWithSkills = json.put(fieldToPut, allSkills);
		return jsonWithSkills;
	}

}
