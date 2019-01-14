package Dao;

public class DaoCompetenceFactory {
	
	public static DaoCompetenceJpaImpl singleton=null;
	
	public static DaoCompetence getCompetenceFactory() {
		if (singleton == null)
			singleton = new DaoCompetenceJpaImpl();
		
		return singleton;
	}

}
