package com.org;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CategoryDaoImpl implements Categorydao {
	// create EntityManagerFactory
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
	/*
	 * test is unit name 
	 */

	@Override
	public void saveCatregory(CategoryEntity entity) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		try {
			em.persist(entity);
			t.commit();
			System.out.println("category with products  are persisted into database...");
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	@Override
	public CategoryEntity fetchCategory(Integer categoryId) {
		EntityManager em = factory.createEntityManager();
		CategoryEntity entity = em.find(CategoryEntity.class, categoryId);
		em.close();
		return entity;
	}

	@Override
	public void removeCategory(Integer categoryId) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		CategoryEntity entity = em.find(CategoryEntity.class, categoryId);
		t.begin();
		try {
			em.remove(entity);
			t.commit();
			System.out.println("category with products is removed from Database");
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

}
