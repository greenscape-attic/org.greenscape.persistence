/**
 * 
 */
package org.greenscape.persistence.criteria;

import org.greenscape.persistence.metamodel.EntityType;

/**
 * A root type in the from clause. Query roots always reference entities.
 * 
 * @param <X>
 *            the entity type referenced by the root
 * @author Sheikh Sajid
 * 
 */
public interface Root<X> extends From<X, X> {

	/**
	 * Return the metamodel entity corresponding to the root.
	 * 
	 * @return metamodel entity corresponding to the root
	 */
	@Override
	EntityType<X> getModel();
}
