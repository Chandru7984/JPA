package com.xworkz.jewels.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.xworkz.jewels.entity.SilverEntity;
import com.xworkz.jewels.util.EMFUtil;

public class SilverRepositoryImpl implements SilverRepository {

	private EntityManagerFactory factory = EMFUtil.getFactory();

	EntityManager manager = null;

	@Override
	public boolean save(SilverEntity entity) {
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
		return false;
	}

	@Override
	public boolean save(List<SilverEntity> list) {
		manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			for (SilverEntity silverEntity : list)
				manager.persist(silverEntity);
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
		return false;
	}

	@Override
	public Optional<SilverEntity> findByShopNameAndId(String name, int id) {
		manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findByShopNameAndId");
			query.setParameter("cs",name);
			query.setParameter("sc",id);
			
			Object singleResult = query.getSingleResult();
			if(singleResult != null) {
				SilverEntity ref = (SilverEntity) singleResult;
				return Optional.of(ref);
			}else {
				System.out.println("data is null" +name +id);
			}
		}finally {
			manager.close();
		}
		return null;
	}

}
