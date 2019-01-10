package App;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import Model.Personne;
import util.Context;

public class App {

	public static void main(String[] args) {
		
		Context.getInstance();
		
		System.out.println("lol");
		
		// utlisation freamework pour requete 
		
		Personne p = new Personne("skywalker", "nico");
		//p.setId(1);
		
		EntityManager em = Context.getInstance().createEntityManager();
		
		//Transaction pour ordre de modif
		EntityTransaction tx = em.getTransaction();
		
		try {
		tx.begin();
		// Rendre l'objet persistent -> avoir une version de l'objet dans la base -> insert
		
		em.persist(p); // em est li� � p, du coup les modif sur p sont r�percut� en base de donn�e
		tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback(); // en cas de pb dans la transaction, l'annule
		}
		em.close();
		
		Context.close();

	}

}
