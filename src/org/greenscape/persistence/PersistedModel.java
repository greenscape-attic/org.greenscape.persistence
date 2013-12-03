package org.greenscape.persistence;

import java.io.Serializable;

/**
 * 
 * @author Sheikh Sajid
 * 
 */
public interface PersistedModel extends DocumentModel, AuditedModel, Serializable {
	public static final String CREATE_DATE = "createDate";
	public static final String MODIFIED_DATE = "modifiedDate";

}
