package com.ecomm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Userdetail;

@Repository("userdetailDao")
@Transactional
public class UserdetailDAOImpl implements UserdetailDAO
{
	@Autowired
	 SessionFactory sessionFactory;
	 @Override
		public boolean addUserdetail(Userdetail userdetail) 
		{
			try
			{
				sessionFactory.getCurrentSession().saveOrUpdate(userdetail);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
		@Override
		public boolean updateUserdetail(Userdetail userdetail) 
		{
			try
			{
				sessionFactory.getCurrentSession().update(userdetail);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
		public Userdetail getUserdetail(int userdetailId) 
		{
			Session session=sessionFactory.openSession();
			Userdetail userdetail=(Userdetail)session.get(Userdetail.class,userdetailId);
			session.close();
			return userdetail;
		}
	

		@Override
		public Userdetail getUserdetail(String userName) {
			{
				Session session=sessionFactory.openSession();
				Userdetail userdetail=session.get(Userdetail.class,userName);
				session.close();
				return userdetail;
			}
		}
}
		/*@Override
		public boolean registerUser(Userdetail userdetail) {
			
				try
				{
					sessionFactory.getCurrentSession().save(userdetail);
					return true;	
				}
				catch(Exception e)
				{
					return false;
				}
				
			}
		}*/

