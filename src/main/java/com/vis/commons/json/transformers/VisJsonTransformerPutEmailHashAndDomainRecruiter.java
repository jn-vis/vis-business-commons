package com.vis.commons.json.transformers;

import java.util.function.Function;

import com.ccp.decorators.CcpHashDecorator;
import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.decorators.CcpStringDecorator;
import com.ccp.utils.CcpHashAlgorithm;

public class VisJsonTransformerPutEmailHashAndDomainRecruiter implements Function<CcpJsonRepresentation, CcpJsonRepresentation> {

	public final static VisJsonTransformerPutEmailHashAndDomainRecruiter INSTANCE = new VisJsonTransformerPutEmailHashAndDomainRecruiter();

	private VisJsonTransformerPutEmailHashAndDomainRecruiter() {}

	public CcpJsonRepresentation apply(CcpJsonRepresentation json) {
		
		String recruiter = json.getAsString("recruiter");
		
		String[] split = recruiter.split("@");
		
		String domain =  split[0];
		
		CcpHashDecorator hash2 = new CcpStringDecorator(recruiter).hash();
		
		String hash = hash2.asString(CcpHashAlgorithm.SHA1);
		//LATER NONPROFESSIONAL DOMAINS
		CcpJsonRepresentation put = json
				.put("originalRecruiter", recruiter)
				.put("recruiter", hash)
				.put("domain", domain)
				;
		
		return put;
	}

}
