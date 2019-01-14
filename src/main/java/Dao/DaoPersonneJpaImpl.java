package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Eleve;
import Model.Formateur;
import Model.Personne;
import util.Context;

class DaoPersonneJpaImpl implements DaoPersonne {

	@Override
	public List<Personne> findAll() {
		EntityManager em = Context.getInstance().createEntityManager();
		List<Personne> personnes =null;
		Query query = em.createQuery("from Personne"); //ici ce n'est pas de l'SQL mais du JPQL on ne se référence pas à la table person mais à la classe Personne
		personnes = query.getResultList();
		return personnes;
	}

	@Override
	public Personne findByKey(Integer key) {
		EntityManager em = Context.getInstance().createEntityManager();
		Personne p = null;
		p = em.find(Personne.class, key);
		em.close();
		return p;
	}

	@Override
	public void insert(Personne obj) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = null;
		
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
		
	}

	@Override
	public void update(Personne obj) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = null;
		
		try {
			tx = em.getTransaction();
			tx.begin();
			em.merge(obj); // fait un lien entre l'objet renseigné et la base de donnée-> insert si il ne trouve pas d'obj correspondant dan sla db ou un update s'il le trouve 
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
		
	}

	@Override
	public void delete(Personne obj) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = null;
		
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(obj)); // pour que l'action soit effective s'assurer que l'objet soit manager, c'est à dire qu'il soit rattaché à un EntityManager
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
		
	}

	@Override
	public void deleteByKey(Integer key) {
		EntityManager em = Context.getInstance().createEntityManager();
		EntityTransaction tx = null;
		
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(Personne.class, key));
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
		
	}

	@Override
	public List<Formateur> findAllFormateur() {
		EntityManager em = Context.getInstance().createEntityManager();
		List<Formateur> formateurs =null;
		Query query = em.createQuery("from Formateur"); //ici ce n'est pas de l'SQL mais du JPQL on ne se référence pas à la table person mais à la classe Personne
		formateurs = query.getResultList();
		return formateurs;
	}

	@Override
	public List<Eleve> findAllEleve() {
		EntityManager em = Context.getInstance().createEntityManager();
		List<Eleve> eleves =null;
		Query query = em.createQuery("from Eleve"); //ici ce n'est pas de l'SQL mais du JPQL on ne se référence pas à la table person mais à la classe Personne
		eleves = query.getResultList();
		return eleves;
	}

	@Override
	public Formateur findFormateurBYKey(Integer key) {
		
		EntityManager em = Context.getInstance().createEntityManager();
		Formateur f = null;
		f = em.find(Formateur.class, key);
		em.close();
		return f;
	}

}
