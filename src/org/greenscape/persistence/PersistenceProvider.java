/**
 * 
 */
package org.greenscape.persistence;

/**
 * @author Sheikh Sajid
 * 
 */
public interface PersistenceProvider {

	public String getName();

	public PersistenceType getType();
}
