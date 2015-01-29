package hibernate.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import hibernate.dao.GenericDAO;


public abstract class GenericDaoImp<T> implements GenericDAO<T> {

	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	private Class<T> type;
	
	public GenericDaoImp(){
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}
	
	@Override
    public T create(final T t) {
        this.entityManager.persist(t);
        return t;
    }

    @Override
    public void delete(final Object id) {
        this.entityManager.remove(this.entityManager.getReference(type, id));
    }

    @Override
    public T retrive(final Object id) {
        return (T) this.entityManager.find(type, id);
    }

    @Override
    public T update(final T t) {
        return this.entityManager.merge(t);    
    }

	@Override
	public List<T> findAll() {
	        final StringBuffer queryString = new StringBuffer("SELECT o from ");
	
	        queryString.append(type.getSimpleName()).append(" o ");
		       
	        final Query query = entityManager.createQuery(queryString.toString());
	
	        List<T> resultList= (List<T>) query.getResultList();
	        entityManager.close();
	        return resultList;
	}
}
