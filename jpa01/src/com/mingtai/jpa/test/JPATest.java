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
	
	//ɾ���������÷���ֻ��ɾ���־û�����֮ǰҪ�Ȳ������ݿ�ĵļ�¼������ֱ��ɾ�������������к�����״̬���ܱ�ɾ����
	@Test
	public void deleteObject(){
		   Customer find = entityManager.find(new Customer().getClass(), 8);
	       entityManager.remove(find);
	
	}
	
	//�������
	@Test
	public void InsertObject(){
		Customer customer = new Customer();
		customer.setLastName("��̫");
		customer.setEmail("7890@.com");
		customer.setAge(16);
		customer.setBirth(new Date());
		customer.setCurrentTime(new Date());
		entityManager.persist(customer);
	}
	
	/**
	 * �ײ���hiberate��lazyʵ��
	 */
	@Test
	public void getReferance(){ 
		Customer customer = entityManager.getReference(Customer.class, 1);
	    System.out.println(customer);
	}
	
	
	//�������в���
	@Test
	public void getFindAll() {
		Customer find = entityManager.find(Customer.class, 1);
		System.out.println(find);
	}

}
