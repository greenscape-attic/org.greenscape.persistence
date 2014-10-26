package org.greenscape.persistence;

import java.util.Date;

public class PersistedModelBase extends DocumentModelBase implements PersistedModel {

	private static final long serialVersionUID = 8837071132135265946L;

	@Override
	public String getOrganizationId() {
		return (String) getProperty(ORGANIZATION_ID);
	}

	@Override
	public PersistedModel setOrganizationId(String organizationId) {
		setProperty(ORGANIZATION_ID, organizationId);
		return this;
	}

	@Override
	public Date getCreatedDate() {
		return (Date) getProperty(CREATED_DATE);
	}

	@Override
	public PersistedModel setCreatedDate(Date date) {
		setProperty(CREATED_DATE, date);
		return this;
	}

	@Override
	public Date getModifiedDate() {
		return (Date) getProperty(MODIFIED_DATE);
	}

	@Override
	public PersistedModel setModifiedDate(Date date) {
		setProperty(MODIFIED_DATE, date);
		return this;
	}
}
