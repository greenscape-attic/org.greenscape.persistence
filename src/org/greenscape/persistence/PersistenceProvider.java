/**
 * 
 */
package org.greenscape.persistence;

/**
 * @author BANSS
 * 
 */
public interface PersistenceProvider {

	public String getName();

	// public Version getVersion();

	public PersistenceType getType();
}
