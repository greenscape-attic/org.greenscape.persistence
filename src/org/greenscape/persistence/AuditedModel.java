/**
 * 
 */
package org.greenscape.persistence;

import java.util.Date;

/**
 * @author Sheikh Sajid
 * 
 */
public interface AuditedModel {
	String CREATE_DATE = "createDate";
	String MODIFIED_DATE = "modifiedDate";

	Date getCreateDate();

	AuditedModel setCreateDate(Date date);

	Date getModifiedDate();

	AuditedModel setModifiedDate(Date date);
}
