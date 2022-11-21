package com.xworkz.jewellery.repo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.xworkz.jewellery.entity.GoldEntity;
import com.xworkz.jewellery.util.EMFUtil;

public class GoldRepoImpl implements GoldRepo {

	private EntityManagerFactory factory = EMFUtil.getFactory();

	EntityManager manager = null;

	@Override
	public boolean save(GoldEntity entity) {
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
	public boolean save(List<GoldEntity> list) {
		manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			for (GoldEntity goldEntity : list)
				manager.persist(goldEntity);
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
	public Optional<GoldEntity> findByShopNameAndId(String name, int id) {
		manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findByShopNameAndId");
			query.setParameter("gd", name);
			query.setParameter("gr", id);

			Object singleResult = query.getSingleResult();
			if (singleResult != null) {
				GoldEntity ref = (GoldEntity) singleResult;
				return Optional.of(ref);
			} else {
				System.out.println("Data is null " + id + name);
			}
		} finally {
			manager.close();
		}
		return Optional.empty();
	}

	@Override
	public Optional<String> findShopNameById(int id) {
		manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findShopNameById");

			query.setParameter("dg", id);
			Object singleResult = query.getSingleResult();
			if (singleResult != null) {
				String ref = (String) singleResult;
				return Optional.of(ref);
			}
		} finally {
			manager.close();
		}
		return Optional.empty();
	}

	@Override
	public Optional<Double> findMakingChargesByShopName(String name) {
		manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findMakingChargesByShopName");

			query.setParameter("sc", name);
			Object singleResult = query.getSingleResult();
			if (singleResult != null) {
				Double ref = (Double) singleResult;
				return Optional.of(ref);
			}
		} finally {
			manager.close();
		}
		return Optional.empty();
	}

	@Override
	public Optional<Object[]> findWastageChargesAndmakingChargesByShopName(String name) {
		manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findWastageChargesAndMakingChargesByShopName");

			query.setParameter("dp", name);
			Object singleResult = query.getSingleResult();
			if (singleResult != null) {
				Object[] ref = (Object[]) singleResult;
				return Optional.of(ref);
			}
		} finally {
			manager.close();
		}
		return Optional.empty();
	}

	@Override
	public Optional<Double> findTotalPriceByGramAndShopName(double gram, String shopName) {
		manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findTotalPriceByGramAndShopName");

			query.setParameter("ss", gram);
			query.setParameter("cs", shopName);
			Object singleResult = query.getSingleResult();
			if (singleResult != null) {
				Double ref = (Double) singleResult;
				return Optional.of(ref);
			}
		} finally {
			manager.close();
		}
		return Optional.empty();
	}

	@Override
	public Collection<GoldEntity> getAll() {
		manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("getAll");

			List resultList = query.getResultList();
			if (resultList != null) {
				System.out.println("data is valid");

				return resultList;
			}
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public Collection<String> getAllShopName() {
		manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("getAllShopName");
			List resultList = query.getResultList();
			if (resultList != null) {
				System.out.println("data is valid");
//				String ref = (String) resultList;
				return resultList;
			}
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public Collection<Object[]> getAllShopNameAndType() {
		manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("getAllShopNameAndType");
			List resultList = query.getResultList();
			if (resultList != null) {
				System.out.println("data is valid");
				return resultList;
			}
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public Optional<Collection<GoldEntity>> findAllByMakingChargesGreaterThan(double charges) {
		manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findAllByMakingChargesGreaterThan");
			
			query.setParameter("mk", charges);
			List resultList = query.getResultList();
			if(resultList!=null) {
				System.out.println("data is valid");
				return Optional.of(resultList);
			}
		}finally {
			manager.close();
		}
		return Optional.empty();
	}
}
