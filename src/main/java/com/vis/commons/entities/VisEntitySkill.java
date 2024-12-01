package com.vis.commons.entities;

import java.util.List;
import java.util.stream.Collectors;

import com.ccp.decorators.CcpFileDecorator;
import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.decorators.CcpStringDecorator;
import com.ccp.especifications.db.bulk.CcpBulkItem;
import com.ccp.especifications.db.bulk.CcpEntityOperationType;
import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.especifications.db.utils.CcpEntityField;
import com.ccp.especifications.db.utils.decorators.CcpFactoryEntity;

//super(Fields.values());
public class VisEntitySkill{
	public static final CcpEntity ENTITY = CcpFactoryEntity.getEntityInstance(VisEntityVirtualHashGrouper.class);
	
	public static enum Fields implements CcpEntityField{
		parent(false), positionsCount(false), preRequisite(false), ranking(false), 
		similar(false), skill(true), synonym(false)
		;
		private final boolean primaryKey;

		private Fields(boolean primaryKey) {
			this.primaryKey = primaryKey;
		}

		
		public boolean isPrimaryKey() {
			return this.primaryKey;
		}
	}

	public List<CcpBulkItem> getFirstRecordsToInsert() {
		CcpStringDecorator csd = new CcpStringDecorator("C:\\eclipse-workspaces\\ccp\\jn\\jn-dependency-chooser-documentation-and-junit-testing\\documentation\\skills\\synonyms.json");
		CcpFileDecorator file = csd.file();
		List<CcpJsonRepresentation> asJsonList = file.asJsonList();
		List<CcpBulkItem> collect = asJsonList.stream().map(x -> new CcpBulkItem(x, CcpEntityOperationType.create, ENTITY)).collect(Collectors.toList());
		return collect;
	}
}
