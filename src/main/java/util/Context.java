package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Context extends Persistence{
	private static EntityManagerFactory singleton =  null;
	private EntityManagerFactory entity = null;
	
	public static EntityManagerFactory getInstance() {
		if(singleton == null)
			singleton = Persistence.createEntityManagerFactory("JpaDbTest");
		
		return singleton;
	}
	
	public static void close() {
		if(singleton!=null)
			singleton.close();
	}
}
