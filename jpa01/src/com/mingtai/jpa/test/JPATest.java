package com.mingtai.jpa.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mingtai.jpa.entities.Customer;

public class JPATest {
	private EntityTransaction transaction;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	@Before
	public void beginLoading(){
		 entityManagerFactory = Persistence.createEntityManagerFactory("jpa01");
		 entityManager = entityManagerFactory.createEntityManager();
		 transaction = entityManager.getTransaction();
		 transaction.begin();
	}
	
	@After
	public void afterLoading(){
		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	//删除操作，该方法只能删除持久化对象，之前要先查找数据库的的记录，不能直接删除对象。在事务中和游离状态不能被删除。
	@Test
	public void deleteObject(){
		   Customer find = entityManager.find(new Customer().getClass(), 8);
	       entityManager.remove(find);
	
	}
	
	//插入操作
	@Test
	public void InsertObject(){
		Customer customer = new Customer();
		customer.setLastName("铭太");
		customer.setEmail("7890@.com");
		customer.setAge(16);
		customer.setBirth(new Date());
		customer.setCurrentTime(new Date());
		entityManager.persist(customer);
	}
	
	/**
	 * 底层由hiberate的lazy实现
	 */
	@Test
	public void getReferance(){ 
		Customer customer = entityManager.getReference(Customer.class, 1);
	    System.out.println(customer);
	}
	
	
	//查找所有操作
	@Test
	public void getFindAll() {
		Customer find = entityManager.find(Customer.class, 1);
		System.out.println(find);
	}

}
