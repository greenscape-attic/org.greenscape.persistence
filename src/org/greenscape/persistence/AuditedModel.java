/**
 *
 */
package org.greenscape.persistence;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Sheikh Sajid
 *
 */
public interface AuditedModel {
	String CREATED_DATE = "createdDate";
	String MODIFIED_DATE = "modifiedDate";

	@JsonIgnore
	Date getCreatedDate();

	AuditedModel setCreatedDate(Date date);

	@JsonIgnore
	Date getModifiedDate();

	AuditedModel setModifiedDate(Date date);
}
