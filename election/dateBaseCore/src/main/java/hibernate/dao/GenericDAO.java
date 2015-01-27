package hibernate.dao;

import java.util.Map;
import java.util.List;
public interface GenericDAO<T> {
	
	long countAll(Map<String, Object>params);
	public List<T> findAll();
	public T create(T t);
	public T retrive(Object id);
	public T update (T t); 
	public void delete(Object id);
	
}
