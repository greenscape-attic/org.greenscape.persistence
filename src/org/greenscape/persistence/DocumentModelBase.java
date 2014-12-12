package org.greenscape.persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Sheikh Sajid
 *
 */
public class DocumentModelBase implements DocumentModel {

	private final Map<String, Object> fields = new HashMap<>();

	@Override
	public Object getId() {
		return fields.get(ID);
	}

	@Override
	public DocumentModel setId(Object id) {
		fields.put(ID, id);
		return this;
	}

	@Override
	public String getModelId() {
		return (String) fields.get(MODEL_ID);
	}

	@Override
	public DocumentModel setModelId(String modelId) {
		fields.put(MODEL_ID, modelId);
		return this;
	}

	@Override
	public Object getProperty(String name) {
		return fields.get(name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getProperty(Class<T> clazz, String name) {
		return (T) fields.get(name);
	}

	@Override
	public DocumentModel setProperty(String name, Object value) {
		fields.put(name, value);
		return this;
	}

	@Override
	public int getPropertySize() {
		return fields.size();
	}

	@Override
	public Map<String, Object> getProperties() {
		return fields;
	}

	@Override
	public Set<String> getPropertyNames() {
		return new HashSet<>(fields.keySet());
	}

	@Override
	public Collection<Object> getPropertyValues() {
		return fields.values();
	}

}
