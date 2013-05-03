package org.greenscape.persistence;

import java.util.List;

/**
 * @author BANSS
 * 
 */
public interface PersistenceService {
	/**
	 * Get the provider for this implementation
	 * 
	 * @return the provider of this persistence implementation
	 */
	public PersistenceProvider getProvider();

	/**
	 * Get the type of peristence store
	 * 
	 * @return the type of persistence
	 */
	public PersistenceType getType();

	/**
	 * Persists the given object.
	 * 
	 * @param object
	 *            the object to be persisted
	 */
	public <T> T persist(T object);

	/**
	 * Persists the array of objects.
	 * 
	 * @param objects
	 *            the list of objects to be persisted
	 */
	public <T> void persist(List<T> objects);

	/**
	 * Persists the list of objects.
	 * 
	 * @param objects
	 *            the list of objects to be persisted
	 */
	public <T> void persist(T[] objects);

	/**
	 * Removes the object from the database
	 * 
	 * @param object
	 *            the object to be removed
	 */
	public <T> T remove(T object);

	/**
	 * Removes the array of objects from the database
	 * 
	 * @param objects
	 *            the list of objects to be removed
	 */
	public <T> void remove(List<T> objects);

	/**
	 * Removes the list of objects from the database
	 * 
	 * @param objects
	 *            the list of objects to be removed
	 */
	public <T> void remove(T[] objects);

	/**
	 * Executes the given sql query as a native query
	 * 
	 * @param query
	 *            the sql query
	 * @return the list of items
	 */
	public List<?> executeQuery(String query);

	/**
	 * Executes the given sql query as a native query and returns a maximum of
	 * <code>maxResult</code> items
	 * 
	 * @param query
	 *            the sql query
	 * @param maxResult
	 *            the maximum number of items
	 * @return the list of items
	 */
	public List<?> executeQuery(String query, int maxResult);
}
