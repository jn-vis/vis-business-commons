package com.jn.vis.commons.utils;

import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.decorators.CcpPropertiesDecorator;
import com.ccp.decorators.CcpStringDecorator;
import com.ccp.especifications.file.bucket.CcpFileBucketOperation;
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
