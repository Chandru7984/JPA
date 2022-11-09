package com.xworkz.onlinepayment.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.xworkz.onlinepayment.EMFUtil.EMFUtil;
import com.xworkz.onlinepayment.entity.OnlinePaymentEntity;

public class OnlinePaymentRepoImpl implements OnlinePaymentRepo {

	private EntityManagerFactory factory = EMFUtil.getFactory();

	EntityManager entityManager = null;

	@Override
	public boolean save(OnlinePaymentEntity entity) {

		try {
			entityManager = factory.createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(entity);
			transaction.commit();
		} finally {
			entityManager.close();
		}

		return false;
	}

	@Override
	public Optional<OnlinePaymentEntity> findById(int id) {
		entityManager = factory.createEntityManager();
		OnlinePaymentEntity find = entityManager.find(OnlinePaymentEntity.class, id);
		if (find != null) {
			System.out.println("id is valid " + find);
			return Optional.of(find);
		} else {
			System.out.println("id is not valid " + id);
		}
		return Optional.empty();
	}

	@Override
	public Optional<OnlinePaymentEntity> updateNameById(int id, String name) {
		try {
			entityManager = factory.createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			OnlinePaymentEntity find = entityManager.find(OnlinePaymentEntity.class, id);
			if (find != null) {
				find.setName(name);
				entityManager.persist(find);// merge can also be used for updating the data
				// for deleting instead of persist we use remove method to delete the data
				System.out.println("name is updated " + find);
				transaction.commit();
				return Optional.of(find);
			}

		} finally {
			entityManager.close();
		}
		return Optional.empty();
	}

	@Override
	public void save(List<OnlinePaymentEntity> list) {
		entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			for (OnlinePaymentEntity entity : list) {
				entityManager.persist(entity);
				System.out.println(entity);
			}
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
	}
}
