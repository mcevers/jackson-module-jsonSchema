package com.fasterxml.jackson.module.jsonSchema.types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;

/**
 * This class represents a {@link JsonSchema} as a number type
 * @author jphelan
 *
 */
public class NumberSchema extends ValueTypeSchema {
	
	/**
	 * This attribute indicates if the value of the instance (if the
	   instance is a number) can not equal the number defined by the
	   "maximum" attribute.
	 */
	@JsonProperty
	private Boolean exclusiveMaximum;
	
	/**
	 * This attribute indicates if the value of the instance (if the
	   instance is a number) can not equal the number defined by the
	   "minimum" attribute.
	 */
	@JsonProperty
	private Boolean exclusiveMinimum;
	
	/**This attribute defines the maximum value of the instance property*/
	@JsonProperty
	private Double maximum = null;
	
	/**This attribute defines the minimum value of the instance property*/
	@JsonProperty
	private Double minimum = null;
	
	@JsonIgnore
	private final JsonFormatTypes type = JsonFormatTypes.NUMBER;
	
	@Override
	public NumberSchema asNumberSchema() { return this; }
	
	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.jsonSchema.types.ValueTypeSchema#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof NumberSchema) {
			NumberSchema that = (NumberSchema)obj;
			return getExclusiveMaximum() == null ? that.getExclusiveMaximum() == null :
				getExclusiveMaximum().equals(that.getExclusiveMaximum()) &&
				getExclusiveMinimum() == null ? that.getExclusiveMinimum() == null :
					getExclusiveMinimum().equals(that.getExclusiveMinimum()) &&
				getMaximum() == null ? that.getMaximum() == null :
					getMaximum().equals(that.getMaximum()) &&
				getMinimum() == null ? that.getMinimum() == null :
					getMinimum().equals(that.getMinimum()) &&
				super.equals(obj);
		} else {
			return false;
		}
	} 

	public Boolean getExclusiveMaximum() {
		return exclusiveMaximum;
	}

	public Boolean getExclusiveMinimum() {
		return exclusiveMinimum;
	}

	public Double getMaximum() {
		return maximum;
	}

	public Double getMinimum() {
		return minimum;
	}
	
	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.jsonSchema.types.JsonSchema#getType()
	 */
	@Override
	public JsonFormatTypes getType() {
		return type;
	}
	
	@Override
	public boolean isNumberSchema() { return true; }

	public void setExclusiveMaximum(Boolean exclusiveMaximum) {
	    this.exclusiveMaximum = exclusiveMaximum;
	}

	public void setExclusiveMinimum(Boolean exclusiveMinimum) {
	    this.exclusiveMinimum = exclusiveMinimum;
	}

	public void setMaximum(Double maximum) {
	    this.maximum = maximum;
	}

	public void setMinimum(Double minimum) {
	    this.minimum = minimum;
	}
}