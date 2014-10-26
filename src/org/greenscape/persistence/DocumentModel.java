package org.greenscape.persistence;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Sheikh Sajid
 *
 */
public interface DocumentModel {
	/**
	 * Name of the identifier property
	 */
	String MODEL_ID = "modelId";

	/**
	 * Gets the UUID of the model
	 *
	 * @return the UUID value
	 */
	String getModelId();

	/**
	 * Sets the UUID of the model
	 *
	 * @param id
	 *            the UUID to set
	 * @return the model for fluent interface
	 */
	DocumentModel setModelId(String id);

	/**
	 * Gets the value of the property given by name
	 *
	 * @param name
	 *            the property's name
	 * @return the value of the property
	 */
	Object getProperty(String name);

	/**
	 * Gets the value of the property given by name in a type safe manner
	 *
	 * @param clazz
	 *            the class type of the returned object
	 * @param name
	 *            the property's name
	 * @return the value of the property
	 */
	<T> T getProperty(Class<T> clazz, String name);

	/**
	 * Sets the value of the property in this entity given by name
	 *
	 * @param name
	 *            the property's name
	 * @param value
	 *            the value to set for the property
	 * @return the entity object itself for method chaining
	 */
	@JsonAnySetter
	DocumentModel setProperty(String name, Object value);

	/**
	 * Gets the number of properties in this entity
	 *
	 * @return the number of properties
	 */
	@JsonIgnore
	int getPropertySize();

	/**
	 * Gets all the properties as a Key-Value pair
	 *
	 * @return the map of properties
	 */
	@JsonAnyGetter
	Map<String, Object> getProperties();

	/**
	 * Gets all the property names in this entity
	 *
	 * @return the set of property names
	 */
	@JsonIgnore
	Set<String> getPropertyNames();

	/**
	 * Gets all the property values in this entity
	 *
	 * @return the collection of property values
	 */
	@JsonIgnore
	Collection<Object> getPropertyValues();

}