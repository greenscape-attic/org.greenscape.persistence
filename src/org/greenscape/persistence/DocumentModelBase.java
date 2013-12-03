package org.greenscape.persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 
 * @author Sheikh Sajid
 * 
 */
public class DocumentModelBase implements DocumentModel {

	protected Map<String, Object> fields;

	public DocumentModelBase() {
		fields = new HashMap<>();
	}

	@JsonIgnore
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
	public Object getProperty(String name) {
		return fields.get(name);
	}

	@Override
	public DocumentModel setProperty(String name, Object value) {
		fields.put(name, value);
		return this;
	}

	@JsonIgnore
	@Override
	public int getPropertySize() {
		return fields.size();
	}

	@Override
	public Map<String, Object> getProperties() {
		return fields;
	}

	@JsonIgnore
	@Override
	public Set<String> getPropertyNames() {
		return fields.keySet();
	}

	@JsonIgnore
	@Override
	public Collection<Object> getPropertyValues() {
		return fields.values();
	}

}
