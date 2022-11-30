package nttdata.hibernate.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	/** 
	 * Factoria Sesiones, en mayúsculas porque es una constante.
	 **/
	private static final SessionFactory FACTORYSESSION;

	/**
	 * Constructor privado.
	 */
	private HibernateUtil() {

	}

	/**
	 * Generacion de factoria de sesiones.
	 */
	static {

		try {
			
			//Configuracion.
			FACTORYSESSION = new Configuration().configure().buildSessionFactory();

		} catch (final Exception ex) {
			
			//Fallo inicializacion.
			System.out.println("Fallo en la Configuracion de Hibernate - " + ex);
			throw new ExceptionInInitializerError();
		}

	}

	/**
	 * Devuelve factoria de sesiones.
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return FACTORYSESSION;
	}
}
