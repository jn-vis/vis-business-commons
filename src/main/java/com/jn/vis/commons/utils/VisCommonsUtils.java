package com.jn.vis.commons.utils;

import com.ccp.constantes.CcpConstants;
import com.ccp.decorators.CcpHashDecorator;
import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.decorators.CcpPropertiesDecorator;
import com.ccp.decorators.CcpStringDecorator;
import com.ccp.especifications.file.bucket.CcpFileBucketOperation;

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
		
		CcpJsonRepresentation put = CcpConstants.EMPTY_JSON.put("email", email);
		String bucketFolderResume = getBucketFolderResume(put);
		String tenant = getTenant();
		
		String execute = CcpFileBucketOperation.get.execute(tenant, bucketFolderResume, contentType);
		return execute;
	}

}
