package org.greenscape.persistence;

import java.util.Collection;
import java.util.List;

/**
 * @author Sheikh Sajid
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
	 * Get the type of persistence store
	 * 
	 * @return the type of persistence
	 */
	public PersistenceType getType();

	/**
	 * Saves the object by creating a new record.
	 * 
	 * @param object
	 *            the object to be inserted
	 */
	public <T> void save(T object);

	/**
	 * Saves the object by updating existing record.
	 * 
	 * @param object
	 *            the object to be updated
	 */
	public <T> void update(T object);

	/**
	 * Saves the object creating a new record or updating existing one.
	 * 
	 * @param object
	 *            the object to be inserted or updated
	 */
	public <T> void saveOrUpdate(T object);

	/**
	 * Persists the collection of objects.
	 * 
	 * @param objects
	 *            the collection of objects to be persisted
	 */
	public <T> void save(Collection<T> objects);

	/**
	 * Persists the array of objects.
	 * 
	 * @param objects
	 *            the array of objects to be persisted
	 */
	public <T> void save(T[] objects);

	/**
	 * Removes the object from the database
	 * 
	 * @param object
	 *            the object to be removed
	 */
	public <T> void remove(T object);

	/**
	 * Removes the collection of objects from the database
	 * 
	 * @param objects
	 *            the collection of objects to be removed
	 */
	public <T> void remove(Collection<T> objects);

	/**
	 * Removes the array of objects from the database
	 * 
	 * @param objects
	 *            the array of objects to be removed
	 */
	public <T> void remove(T[] objects);

	/**
	 * Executes a native query
	 * 
	 * @param query
	 *            the query to execute
	 * @return
	 */
	public Object executeQuery(String query);

	/**
	 * Executes a native query. This is used for returning a single entity type
	 * 
	 * @param query
	 *            the sql query
	 * @return the collection of items
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public <T> Collection<T> executeQuery(Class<T> clazz, String query);

	/**
	 * Executes the given sql query as a native query and returns a maximum of
	 * <code>maxResult</code> items
	 * 
	 * @param query
	 *            the sql query
	 * @param maxResult
	 *            the maximum number of items
	 * @return the collection of items
	 */
	public <T> Collection<T> executeQuery(Class<T> clazz, String query, int maxResult);

	/**
	 * Search for the object by its unique identifier
	 * 
	 * @param clazz
	 * @param id
	 *            the unique identifier of the object
	 * @return the found object otherwise null
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public <T> T findById(Class<T> clazz, Object id);

	/**
	 * Search for the object by its property and value
	 * 
	 * @param clazz
	 * @param propertyName
	 *            the property on which to search
	 * @param value
	 *            the value of the property
	 * @return the found list of objects otherwise null
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public <T> List<T> findByProperty(Class<T> clazz, String propertyName, Object value);

	/**
	 * Deletes the given object from database
	 * 
	 * @param documentModel
	 *            the object to delete
	 */
	public <T> void delete(T documentModel);

	/**
	 * Check whether the model exists in database
	 * 
	 * @param modelName
	 *            the name of the model to check
	 * @return true if the model is already saved in database else falls
	 */
	public boolean modelExists(String modelName);

	/**
	 * Begins a database transaction
	 */
	public PersistenceService begin();

	/**
	 * Commits the current database transaction started by <code>begin()</code>
	 */
	public PersistenceService commit();

	/**
	 * Roll backs the current transaction started by <code>begin()</code>
	 */
	public PersistenceService rollback();
}
