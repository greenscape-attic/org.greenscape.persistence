package org.greenscape.persistence;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.greenscape.persistence.criteria.CriteriaBuilder;
import org.greenscape.persistence.criteria.CriteriaDelete;
import org.greenscape.persistence.criteria.CriteriaQuery;
import org.greenscape.persistence.criteria.CriteriaUpdate;

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
	PersistenceProvider getProvider();

	/**
	 * Get the type of persistence store
	 * 
	 * @return the type of persistence
	 */
	PersistenceType getType();

	/**
	 * Saves the object by creating a new record.
	 * 
	 * @param object
	 *            the object to be inserted
	 */
	<T> void save(T object);

	/**
	 * Saves the object by updating existing record.
	 * 
	 * @param object
	 *            the object to be updated
	 */
	<T> void update(T object);

	/**
	 * Saves the object creating a new record or updating existing one.
	 * 
	 * @param object
	 *            the object to be inserted or updated
	 */
	<T> void saveOrUpdate(T object);

	/**
	 * Persists the collection of objects.
	 * 
	 * @param objects
	 *            the collection of objects to be persisted
	 */
	<T> void save(Collection<T> objects);

	/**
	 * Persists the array of objects.
	 * 
	 * @param objects
	 *            the array of objects to be persisted
	 */
	<T> void save(T[] objects);

	/**
	 * Removes the object from the database
	 * 
	 * @param object
	 *            the object to be removed
	 */
	<T> void remove(T object);

	/**
	 * Removes the collection of objects from the database
	 * 
	 * @param objects
	 *            the collection of objects to be removed
	 */
	<T> void remove(Collection<T> objects);

	/**
	 * Removes the array of objects from the database
	 * 
	 * @param objects
	 *            the array of objects to be removed
	 */
	<T> void remove(T[] objects);

	/**
	 * Executes a native query
	 * 
	 * @param query
	 *            the query to execute
	 * @return
	 */
	Object executeQuery(String query);

	/**
	 * Executes a native query. This is used for returning a single entity type
	 * 
	 * @param query
	 *            the sql query
	 * @return the collection of items
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	<T> Collection<T> executeQuery(Class<T> clazz, String query);

	/**
	 * Executes a native query with named parameters. This is used for returning
	 * a single entity type
	 * 
	 * @param query
	 *            the sql query
	 * @param params
	 *            the map of named parameters and their values
	 * @return the collection of items
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	// <T> List<T> executeQuery(Class<T> clazz, String query, Map<String,
	// List<Object>> params);

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
	<T> Collection<T> executeQuery(Class<T> clazz, String query, int maxResult);

	/**
	 * Search and return all objects of the given modelName
	 * 
	 * @param modelName
	 * @return the found list of objects otherwise empty list
	 */
	<T extends DocumentModel> List<T> find(String modelName);

	/**
	 * Search and return all objects of the given class
	 * 
	 * @param clazz
	 * @return the found list of objects otherwise empty list
	 */
	<T extends DocumentModel> List<T> find(Class<T> clazz);

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
	<T> T findById(Class<T> clazz, String modelId);

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
	<T> List<T> findByProperty(Class<T> clazz, String propertyName, Object value);

	/**
	 * Search for the object by one or more property and value
	 * 
	 * @param clazz
	 * @param properties
	 *            the properties to search on, provided as a key-value pair
	 * @param value
	 *            the value of the property
	 * @return the found list of objects otherwise null
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	<T> List<T> findByProperties(Class<T> clazz, Map<String, Object> properties);

	/**
	 * Deletes all the records of the class type from database
	 * 
	 * @param clazz
	 *            the class type collection to delete
	 */
	<T extends DocumentModel> void delete(Class<T> clazz);

	/**
	 * Deletes the record of the class type and having the modelId
	 * 
	 * @param clazz
	 *            the class type collection to delete
	 * @param modelId
	 *            the record modelId to delete
	 */
	<T extends DocumentModel> void delete(Class<T> clazz, String modelId);

	/**
	 * Deletes the given object from database
	 * 
	 * @param documentModel
	 *            the object to delete
	 */
	<T extends DocumentModel> void delete(T documentModel);

	/**
	 * Check whether the model exists in database
	 * 
	 * @param modelName
	 *            the name of the model to check
	 * @return true if the model is already saved in database else falls
	 */
	boolean modelExists(String modelName);

	void addModel(String modelName);

	/**
	 * Return an instance of CriteriaBuilder for the creation of CriteriaQuery
	 * objects.
	 * 
	 * @return CriteriaBuilder instance
	 */
	CriteriaBuilder getCriteriaBuilder();

	/**
	 * Create an instance of <code>TypedQuery</code> for executing a criteria
	 * query.
	 * 
	 * @param criteriaQuery
	 *            a criteria query object
	 * @return the new query instance
	 * @throws IllegalArgumentException
	 *             if the criteria query is found to be invalid
	 * @since Java Persistence 2.0
	 */
	<T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery);

	/**
	 * Create an instance of Query for executing a criteria update query.
	 * 
	 * @param updateQuery
	 *            a criteria update query object
	 * @return the new query instance
	 * @throws IllegalArgumentException
	 *             if the update query is found to be invalid
	 */
	Query createQuery(CriteriaUpdate updateQuery);

	/**
	 * Create an instance of Query for executing a criteria delete query.
	 * 
	 * @param deleteQuery
	 *            a criteria delete query object
	 * @return the new query instance
	 * @throws IllegalArgumentException
	 *             if the delete query isfound to be invalid
	 */
	Query createQuery(CriteriaDelete deleteQuery);

	/**
	 * Begins a database transaction
	 */
	PersistenceService begin();

	/**
	 * Commits the current database transaction started by <code>begin()</code>
	 */
	PersistenceService commit();

	/**
	 * Roll backs the current transaction started by <code>begin()</code>
	 */
	PersistenceService rollback();

}
