package jp.co.cyberagent.arashi.dao.impl;

import java.util.List;

import jp.co.cyberagent.arashi.dao.UserDao;
import jp.co.cyberagent.arashi.model.User;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository  
public class UserDaoImpl implements UserDao {  
	
	@Autowired  
	private SessionFactory sessionFactory; 
    @Override  
    public List<User> findAllUsers() {  
    	 String hql = "from user";  
         return queryForList(hql, null);  
    }

	@Override
	public User get(Integer id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);  
	}

	@SuppressWarnings("unchecked")  
    protected List<User> queryForList(String hql, Object[] params) {  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        setQueryParams(query, params);  
        return query.list();  
    }  
	
   private void setQueryParams(Query query, Object[] params) {  
        if (null == params) {  
            return;  
        }  
        for (int i = 0; i < params.length; i++) {  
            query.setParameter(i, params[i]);  
        }  
    }  
    
}  