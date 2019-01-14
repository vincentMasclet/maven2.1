package Dao;

public class DaoOrdinateurFactory {
	public static DaoOrdianteur singleton;
	
	public static DaoOrdianteur getOrdinateurFactory() {
		if(singleton==null)
			singleton = new DaoOrdinateurJpaImpl();
		
		return singleton;
	}

}
