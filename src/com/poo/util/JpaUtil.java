package com.poo.util;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JpaUtil {

	private static final String PERSISTENCE_UNIT = "database_farmacia";

	private static final EntityManagerFactory FACTORY = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	private static final EntityManager EM = FACTORY.createEntityManager();

	public static EntityManagerFactory getFACTORY() {
		return FACTORY;
	}

	public static EntityManager getEM() {
		return EM;
	}
	
	
}
