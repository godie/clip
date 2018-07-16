package com.godieboy.clipo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil {
	
	private static EntityManagerFactory factory;
	
	private static EntityManager entityManager;
	
	public static EntityManager getEntityManager() {
		if(factory == null) {
			 factory = Persistence.createEntityManagerFactory("ClipDB");
	         entityManager = factory.createEntityManager();
		}	
        return entityManager;
	}
	
	public static void close() {
		if(factory != null) {
			factory.close();
		}
		if(entityManager != null) {
			entityManager.close();
		}
	}

}
