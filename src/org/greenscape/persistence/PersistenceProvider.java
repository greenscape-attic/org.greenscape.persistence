/**
 * 
 */
package org.greenscape.persistence;

/**
 * @author Sheikh Sajid
 * 
 */
public interface PersistenceProvider {

	String getName();

	PersistenceType getType();
}
