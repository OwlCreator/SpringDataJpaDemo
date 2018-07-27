package com.mingtai.jpa.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mingtai.jpa.entities.Customer;

public class Test {
    public static void main(String[] args) {
    	
    	String persistenceUnitName = "jpa01";
    	//1.����entityManagerFactory����
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory(persistenceUnitName) ;
       
		//2.����entityManagerʵ�������
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	   	
         //3.��������
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		//4.�������
		Customer customer=new Customer();
		customer.setAge(21);
		customer.setEmail("1324567@qq.com");
		customer.setLastName("Ҷ��");
		customer.setBirth(new Date());
		customer.setCurrentTime(new Date());
		entityManager.persist(customer);
		//5.�ύ����
		transaction.commit();
		
		//6.�ر�ʵ�������
		entityManager.close();
		
		//7.�ر�ʵ�幤��
		entityManagerFactory.close();
		
    }
}  
