package com.xworkz.human.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.xworkz.human.entity.HumanEntity;
import com.xworkz.human.util.EMFUtil;

public class HumanRepoImpl implements HumanRepo {

	private EntityManagerFactory factory = EMFUtil.getFactory();

	EntityManager manager = null;

	@Override
	public boolean save(HumanEntity entity) {
		manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return true;
	}

	@Override
	public Optional<HumanEntity> findById(int id) {
		manager = factory.createEntityManager();
		HumanEntity find = manager.find(HumanEntity.class, id);
		if (find != null) {
			System.out.println("id is valid " + find);
			return Optional.of(find);
		} else {
			System.out.println("id is invalid " + id);
		}
		return Optional.empty();
	}

	@Override
	public Optional<HumanEntity> updateNameById(int id, String name) {

		try {
			manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			HumanEntity find = manager.find(HumanEntity.class, id);
			if (find != null) {
				find.setName(name);
				manager.persist(find);
				System.out.println("name is updated " + find);
				transaction.commit();
				return Optional.of(find);
			}
		} finally {
			manager.close();
		}
		return Optional.empty();
	}

	@Override
	public void save(List<HumanEntity> list) {
		manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			for (HumanEntity entity : list) {
				manager.persist(entity);
				System.out.println(entity);
			}
			transaction.commit();
		}catch (PersistenceException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			manager.close();
		}
		
	}
	
	@Override
	public Optional<HumanEntity> findAgeByName(String name) {
		manager = factory.createEntityManager();
		Query createNamedQuery = manager.createNamedQuery("findAgeByName");
		createNamedQuery.setParameter("cs", name);
		
		return null;
	}
}
