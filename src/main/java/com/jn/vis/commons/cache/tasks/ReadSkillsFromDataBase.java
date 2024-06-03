package com.jn.vis.commons.cache.tasks;

import java.util.List;
import java.util.function.Function;

import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.dependency.injection.CcpDependencyInjection;
import com.ccp.especifications.db.query.CcpDbQueryOptions;
import com.ccp.especifications.db.query.CcpQueryExecutor;
import com.jn.vis.commons.entities.VisEntitySkill;

public class ReadSkillsFromDataBase implements Function<CcpJsonRepresentation, List<CcpJsonRepresentation>>{
	private ReadSkillsFromDataBase() {}
	
	public static final ReadSkillsFromDataBase INSTANCE = new ReadSkillsFromDataBase();
	
	public List<CcpJsonRepresentation> apply(CcpJsonRepresentation t) {
		CcpQueryExecutor queryExecutor = CcpDependencyInjection.getDependency(CcpQueryExecutor.class);
		CcpDbQueryOptions query = CcpDbQueryOptions.INSTANCE.addDescSorting("ranking").maxResults();
		String[] resourcesNames = new String[] {VisEntitySkill.INSTANCE.getEntityName()};
		List<CcpJsonRepresentation> list = queryExecutor.getResultAsList(
				query, 
				resourcesNames,  
				VisEntitySkill.Fields.prerequiste.name(), 
				VisEntitySkill.Fields.synonym.name(), 
				VisEntitySkill.Fields.skill.name()
				);
		return list;
	}

}
