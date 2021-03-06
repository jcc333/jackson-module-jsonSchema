package com.fasterxml.jackson.module.jsonSchema.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;

/**
 * This class represents a {@link JsonSchema} as a Union Type Schema:
 * "An array of two or more simple type definitions.  Each
      item in the array MUST be a simple type definition or a schema.
      The instance value is valid if it is of the same type as one of
      the simple type definitions, or valid by one of the schemas, in
      the array."

 * @author jphelan
 *
 */
public class UnionTypeSchema extends JsonSchema {

	@JsonProperty
	private ValueTypeSchema[] elements;

	@Override
	public UnionTypeSchema asUnionTypeSchema() {
		return this;
	}

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.jsonSchema.types.JsonSchema#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UnionTypeSchema) {
			UnionTypeSchema that = (UnionTypeSchema) obj;
			return getElements() == null ? that.getElements() == null :
				getElements().equals(that.getElements()) && 
				super.equals(obj);
		} else {
			return false;
		}
	}

	public ValueTypeSchema[] getElements() {
		return elements;
	}

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.jsonSchema.types.JsonSchema#getType()
	 */
	@Override
	public JsonFormatTypes getType() {
		return null;
	}
	
	@Override
	public boolean isUnionTypeSchema() {
		return true;
	}

	public void setElements(ValueTypeSchema[] elements) {
		assert elements.length >= 2 : "Union Type Schemas must contain two or more Simple Type Schemas";
		this.elements = elements;
	}
}