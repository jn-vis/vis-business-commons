package com.jn.vis.commons.cache.tasks;

import java.util.function.Function;

import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.especifications.file.bucket.CcpFileBucketOperation;
import com.jn.vis.commons.utils.VisCommonsUtils;

public class ReadResumeContent implements Function<CcpJsonRepresentation, String>{

	public static final ReadResumeContent INSTANCE = new ReadResumeContent();
	
	private ReadResumeContent() {}
	
	public String apply(CcpJsonRepresentation json) {
		String bucketFolderResume = VisCommonsUtils.getBucketFolderResume(json);
		String contentType = json.getAsString("contentType");
		String tenant = VisCommonsUtils.getTenant();
		String execute = CcpFileBucketOperation.get.execute(tenant, bucketFolderResume, contentType);
		return execute;
	}

}
