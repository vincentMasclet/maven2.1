package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Competence;
import util.Context;

class DaoCompetenceJpaImpl implements DaoCompetence {

	@Override
	public List<Competence> findAll() {
		EntityManager em = Context.getInstance().createEntityManager();
		List<Competence> competences =null;
		Query query = em.createQuery("c from Competence");
		competences = query.getResultList();
		return competences;
	}

	@Override
	public Competence findByKey(Long key) {
		EntityManager em = Context.getInstance().createEntityManager();
		Competence c=null;
		c = em.find(Competence.class, key);
		
		return c;
	}

	@Override
	public void insert(Competence obj) {
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
	public void update(Competence obj) {
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
	public void delete(Competence obj) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = null;
		
		tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.merge(obj));
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = null;
		
		tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.find(Competence.class, key));
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null && tx.isActive())
				tx.rollback();
		}
		
		
		em.close();
		
	}

}
