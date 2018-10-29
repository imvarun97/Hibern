package com.caps.dev.Dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.caps.dev.beans.Person;
import com.caps.dev.controller.JPAUtils;

public class HibernateImpl implements PersonInterface {

	public void create(Person p) {
		
	    EntityManagerFactory emf = JPAUtils.getEMF();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
		
	}

	public void update(Person person) {
		
		EntityManagerFactory emf = JPAUtils.getEMF();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		person=em.find(Person.class,person.getPersonId());
		person=em.find(Person.class,person.getEmail());
		person.setAddress(person.getEmail());
		tx.commit();
	}

	public void search(Person person) {
		EntityManagerFactory emf =JPAUtils.getEMF();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		person=em.find(Person.class,person.getPersonId());
		System.out.println("*********************");
		System.out.println("Id : "+person.getPersonId());
		System.out.println("Name : "+person.getPersonName());
		System.out.println("Age : "+person.getAge());
		System.out.println("EmailId : "+person.getEmail());
		System.out.println("Address : "+person.getAddress());
		System.out.println("*********************");
		tx.commit();
		
	}

	public void delete(Person p) {
		EntityManagerFactory emf = JPAUtils.getEMF();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p=em.find(Person.class,p.getPersonId());
		em.remove(p);
		tx.commit();
		
	}

}
