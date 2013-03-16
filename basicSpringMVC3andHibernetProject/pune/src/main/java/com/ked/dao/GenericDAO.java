package com.ked.dao;

import java.util.List;

import com.ked.pojo.Kernel;


public interface GenericDAO<K,T extends Kernel<K>> {
	/**
	 * Method to create and/or update a NTM Entity to the database.
	 * This method does not commit. The caller should handle all transaction related nuances.
	 * 
	 * @param entity
	 */
	public void persist(T entity);
    
	/**
	 * Method to delete a NTM Entity from the database.
	 * This method does not commit. The caller should handle all transaction related nuances.
	 * 
	 * @param entity
	 */
    public void delete(T entity);
    
	/**
	 * Method to read a NTM Entity from the database.
	 * This method does not need an active transaction.
	 * 
	 * @param id
	 * @return T
	 */
    public T findById(Long id);

    /**
     * Method to merge a detached object into the database.
     * 
     * @param entity
     */
    public void merge(T entity);
	
	/**
	 * Method to read a NTM Entity from the database.
	 * This method does not need an active transaction.
	 * 
	 * @param id
	 * @return List<T>
	 */
    List<T> findAll();
    
    /**
     * Find using a named query.
     *
     * @param queryName the name of the query
     * @param params the query parameters
     *
     * @return the list of entities
     */
    List<T> findByNamedQuery(
        final String queryName,
        Object... params
    );
}
