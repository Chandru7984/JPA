package com.xworkz.stadium.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.xworkz.stadium.entity.StadiumEntity;
import com.xworkz.stadium.util.EMFUtil;

public class StadiumRepoImpl implements StadiumRepo {

	private EntityManagerFactory factory = EMFUtil.getFactory();

	@Override
	public boolean save(StadiumEntity entity) {
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
