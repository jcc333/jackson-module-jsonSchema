package com.fasterxml.jackson.module.jsonSchema.types;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;

/**
 * This class encapsulates the functionality of container type {@link JsonSchema}
 * Array and Object
 * @author jphelan
 *
 */
public abstract class ContainerTypeSchema extends SimpleTypeSchema {
	/**
	 * This provides an enumeration of all possible values that are valid
	   for the instance property.  This MUST be an array, and each item in
	   the array represents a possible value for the instance value.  If
	   this attribute is defined, the instance value MUST be one of the
	   values in the array in order for the schema to be valid.  Comparison
	   of enum values uses the same algorithm as defined in "uniqueItems"
	   (Section 5.15).
	 */
	@JsonProperty(value = "enum", required = true)
	private Set<String> enums;
	
	//instance initializer block 
	{
		enums = new HashSet<String>();
	}
	
	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.jsonSchema.types.JsonSchema#asContainerSchema()
	 */
	@Override
	public ContainerTypeSchema asContainerSchema() { return this; }
	
	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.jsonSchema.types.SimpleTypeSchema#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ContainerTypeSchema) {
			ContainerTypeSchema that = (ContainerTypeSchema)obj;
			return getEnums() == null ? that.getEnums() == null :
				getEnums().equals(that.getEnums()) &&
				super.equals(obj);
		} else {
			return false;
		}
	} 

	public Set<String> getEnums() {
	    return enums;
	}

	@Override
	public boolean isContainerTypeSchema() { return true; }

	public void setEnums(Set<String> enums) {
	    this.enums = enums;
	}
}