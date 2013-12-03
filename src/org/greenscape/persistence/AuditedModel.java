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
	public Date getCreateDate();

	public Date getModifiedDate();

	public void setCreateDate(Date date);

	public void setModifiedDate(Date date);
}
