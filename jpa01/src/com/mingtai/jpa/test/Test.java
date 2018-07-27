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
    	//1.创建entityManagerFactory工厂
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory(persistenceUnitName) ;
       
		//2.创建entityManager实体管理器
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	   	
         //3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		//4.事务操作
		Customer customer=new Customer();
		customer.setAge(21);
		customer.setEmail("1324567@qq.com");
		customer.setLastName("叶子");
		customer.setBirth(new Date());
		customer.setCurrentTime(new Date());
		entityManager.persist(customer);
		//5.提交事务
		transaction.commit();
		
		//6.关闭实体管理器
		entityManager.close();
		
		//7.关闭实体工厂
		entityManagerFactory.close();
		
    }
}  
