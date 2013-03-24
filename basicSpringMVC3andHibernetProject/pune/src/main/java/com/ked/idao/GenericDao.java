package com.ked.idao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;

import com.ked.pojo.Kernel;


public interface GenericDao<K,T extends Kernel<K>> {
	  /**
     * Delete persistentObject from DB.
     * @param persistentObject object to delete.
     */
    public void delete(T persistentObject) ;
    /** Deletes an object of a given Id. Will load the object internally so consider using delete (T obj) directly
     * @param id Delete key
     */
    public void delete(K id) ;
    
    /** Delete object.
     * @param persistentObject to delete
     * @param session to use
     * 
     */
    public void delete(T persistentObject, Session session) ;
    
    /** Deletes an object of a given Id. Will load the object internally so consider using delete (T obj) directly.
     * @param id to delete 
     * @param session to use
     */
    public void delete(K id, Session session) ;
    
    /**
     * Item to save.
     * @param o object to save
     * @return K
     */
    public K save(T o) ;
    /** Save object.
     * @param o to save 
     * @param session to use
     * @return the id of the saved object
     * 
     */
    public K save(T o, Session session) ;
    /**
     * Item to saveOrUpdate.
     * @param o item to save.
     */
    public void saveOrUpdate(T o) ;

    /** Save Or Update object.
     * @param o to save
     * @param session to use.
     * 
     */
    public void saveOrUpdate(T o, Session session) ;

    /**
     * Update object.
     * @param o object to update
     */
    public void update(T o) ;
    
    /** Update record.
     * @param o to update
     * @param session to use
     * 
     */
    public void update(T o, Session session) ;
    
    /** Flushes the cache of the currently-used session.
     * 
     */
    public void flush() ;
    
    /** Object to evict from cache.
     * @param obj Object to evict
     */
    public void evict(Object obj);
    
    /**
     * Item to refresh.
     * @param o object to refresh
     */
    public void refresh(T o) ;
    /**
     * Loads the given Object.
     * @param id to load
     * @return T Loaded object
     */
    public T load(K id) ;
    /**
     * Loads the given Object.
     * @param id to load
     * @param session to use
     * @return  an object of type T
     */
    public T load(K id, Session session) ;

    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
    public T get(K id) ;
    /**
     * Loads the given Object.
     * @param id Id to load
     * @param session Session to use
     * @return An object of type T
     */
    public T get(K id, Session session) ;

    /**
     * Gets the current session in use (creates one if necessary).
     * @return Session object 
     */
    public Session getSession() ;

    /**
     * Get query.
     * @param s Query to execute.
     * @return Query object
     */
    public Query getQuery(String s);
    /**
     * GetQuery.
     * @param s to return
     * @param session  to use
     * @return Query object
     */
    public Query getQuery(String s, Session session) ;
    /**
     * Get Session factory.
     * @return SessionFactory Object
     */
    public SessionFactory getSessionFactory() ;

    /** Wrapper around hibernate functions.
     * @param criterion to use
     * @return A list of matching objects
     */
    public List<T> findByCriteria(Criterion... criterion);

    
    /** FindAll.
     * @return A list of all the objects
     */
    public List<T> findAll() ;
    
    
    /** FindByExample.
     * @param exampleInstance to use
     * @param excludeProperty to use
     * @return List of matching objects
     */
    public List<T> findByExample(T exampleInstance, String... excludeProperty);
}
