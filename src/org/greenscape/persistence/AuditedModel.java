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
	Date getCreateDate();

	Date getModifiedDate();

	void setCreateDate(Date date);

	void setModifiedDate(Date date);
}
