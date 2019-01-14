package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Ordinateur;
import util.Context;

class DaoOrdinateurJpaImpl implements DaoOrdianteur {

	@Override
	public List<Ordinateur> findAll() {
		EntityManager em = Context.getInstance().createEntityManager();
		List<Ordinateur> ordinateurs =null;
		Query query = em.createQuery("c from Ordinateur");
		ordinateurs = query.getResultList();
		return ordinateurs;
		
	}

	@Override
	public Ordinateur findByKey(String key) {
		EntityManager em = Context.getInstance().createEntityManager();
		Ordinateur o=null;
		o = em.find(Ordinateur.class, key);
		return o;
	}

	@Override
	public void insert(Ordinateur obj) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = null;
		
		tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

	@Override
	public void update(Ordinateur obj) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = null;
		
		tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(obj);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

	@Override
	public void delete(Ordinateur obj) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = null;
		Ordinateur ordinateur = null;
		tx = em.getTransaction();
		try {
			tx.begin();
			ordinateur = em.find(Ordinateur.class, obj.getCode());
			if (ordinateur.getEleve()!=null)
				ordinateur.getEleve().setOrdi(null);
			em.remove(ordinateur);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

	@Override
	public void deleteByKey(String key) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = null;
		Ordinateur ordinateur = null;
		tx = em.getTransaction();
		try {
			tx.begin();
			ordinateur = em.find(Ordinateur.class, key);
			if (ordinateur.getEleve()!=null)
				ordinateur.getEleve().setOrdi(null);
			em.remove(ordinateur);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

}
