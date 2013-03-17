package com.ked.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ked.pojo.Kernel;


@Repository
@Transactional
public abstract class GenericDAOImpl<K,T extends Kernel<K>> implements GenericDAO<K,T> {
	
	private static final Logger	LOGGER	= LoggerFactory.getLogger(GenericDAOImpl.class);
	
	protected Class<T>			persistentObject;
	
	@Autowired
	protected SessionFactory sessionFactory;

	public GenericDAOImpl(Class<T> persistentObject) {
		this.persistentObject = persistentObject;
		LOGGER.debug("BaseJpaDao(): instantiated DAO of type " + this.persistentObject);
	}

    /** Helper functions.
     * @return the currently set class
     */
    public Class<T> getPersistentClass() {
        return this.persistentObject;
    }
    
    /**
     * Delete persistentObject from DB.
     * @param persistentObject object to delete.
     */
    public void delete(T persistentObject) {
        getSession().delete(persistentObject);
    }

    /** Deletes an object of a given Id. Will load the object internally so consider using delete (T obj) directly
     * @param id Delete key
     */
    public void delete(K id) {
        getSession().delete(load(id));
    }

    /**
     * Loads the given Object.
     * @param id to load
     * @return T Loaded object
     */
    @SuppressWarnings("unchecked")
    public T load(K id) {
        return (T) getSession().load(this.persistentObject, (Serializable) id);
    }


    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
    @SuppressWarnings("unchecked")
    public T get(K id) {
        return (T) getSession().get(this.persistentObject, (Serializable) id);
    }

    /**
     * Item to save.
     * @param o object to save
     * @return K
     */
    @SuppressWarnings("unchecked")
    public K save(T o) {
        return (K) getSession().save(o);
    }

   /**
     * Item to refresh.
     * @param o object to refresh
     */
    @SuppressWarnings("unchecked")
    public void refresh(T o) {
        getSession().refresh(o);
    }

    /**
     * Item to saveOrUpdate.
     * @param o item to save.
     */
    public void saveOrUpdate(T o) {
        getSession().saveOrUpdate(o);
    }

    /**
     * Update object.
     * @param o object to update
     */
    public void update(T o) {
        getSession().update(o);
    }

    /**
     * Gets the current session in use (creates one if necessary).
     * @return Session object 
     */
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Get query.
     * @param s Query to execute.
     * @return Query object
     */
    public Query getQuery(String s) {
        return getSession().createQuery(s);
    }

    /**
     * Get Session factory.
     * @return SessionFactory Object
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Set session factory.
     * @param sessionFactory object
     */
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    /** Delete object.
     * @param persistentObject to delete
     * @param session to use
     * 
     */
    public void delete(T persistentObject, Session session) {
        session.delete(persistentObject);
    }

    /** Deletes an object of a given Id. Will load the object internally so consider using delete (T obj) directly.
     * @param id to delete 
     * @param session to use
     */
    public void delete(K id, Session session) {
        session.delete(load(id));
    }

    /**
     * Loads the given Object.
     * @param id to load
     * @param session to use
     * @return  an object of type T
     */
    @SuppressWarnings("unchecked")
    public T load(K id, Session session) {
        return (T) session.load(this.persistentObject, (Serializable) id);
    }

    /**
     * Loads the given Object.
     * @param id Id to load
     * @param session Session to use
     * @return An object of type T
     */
    @SuppressWarnings("unchecked")
    public T get(K id, Session session) {
        return (T) session.get(this.persistentObject, (Serializable) id);
    }

    /** Save object.
     * @param o to save 
     * @param session to use
     * @return the id of the saved object
     * 
     */
    @SuppressWarnings("unchecked")
    public K save(T o, Session session) {
        return (K) session.save(o);
    }

    /** Save Or Update object.
     * @param o to save
     * @param session to use.
     * 
     */
    public void saveOrUpdate(T o, Session session) {
        session.saveOrUpdate(o);
    }

    /** Update record.
     * @param o to update
     * @param session to use
     * 
     */
    public void update(T o, Session session) {
        session.update(o);
    }


    /**
     * GetQuery.
     * @param s to return
     * @param session  to use
     * @return Query object
     */
    public Query getQuery(String s, Session session) {
        return session.createQuery(s);
    }

    /** Wrapper around hibernate functions.
     * @param criterion to use
     * @return A list of matching objects
     */
    @SuppressWarnings("unchecked")
    public List<T> findByCriteria(Criterion... criterion) {
        Criteria crit =  getSession().createCriteria(getPersistentClass());
        
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
    }

    
    /** FindAll.
     * @return A list of all the objects
     */
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return findByCriteria();
    }
    
    /** Flushes the cache of the currently-used session.
     * 
     */
    public void flush() {
        getSession().flush();
    }
    
    /** Object to evict from cache.
     * @param obj Object to evict
     */
    public void evict(Object obj) {
        getSession().evict(obj);
    }
    
    
    /** FindByExample.
     * @param exampleInstance to use
     * @param excludeProperty to use
     * @return List of matching objects
     */
    @SuppressWarnings("unchecked")
    public List<T> findByExample(T exampleInstance, String... excludeProperty) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        Example example = Example.create(exampleInstance);
        for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
        }
        crit.add(example);
        return crit.list();
    }
}