package com.xworkz.naanu.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.naanu.entity.NaanuEntity;
import com.xworkz.naanu.util.EMFUtil;

public class NaanuRepoImpl implements NaanuRepo {

	private EntityManagerFactory factory = EMFUtil.getFactory();

	@Override
	public boolean save(NaanuEntity entity) {
		EntityManager manager = null;

		try {
			manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
		} finally {
			manager.close();
		}

		return false;
	}

}
