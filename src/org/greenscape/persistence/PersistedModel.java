package org.greenscape.persistence;

import java.io.Serializable;

/**
 * 
 * @author Sheikh Sajid
 * 
 */
public interface PersistedModel extends DocumentModel, AuditedModel, Serializable {
	String CREATE_DATE = "createDate";
	String MODIFIED_DATE = "modifiedDate";

}
