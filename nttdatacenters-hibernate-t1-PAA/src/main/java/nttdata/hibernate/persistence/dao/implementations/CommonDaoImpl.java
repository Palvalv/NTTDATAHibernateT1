package nttdata.hibernate.persistence.dao.implementations;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;

import nttdata.hibernate.persistence.dao.interfaces.CommonDaoI;
import nttdata.hibernate.persistence.entities.AbstractEntity;

/**
 * Implementacion DAO comun.
 */
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/**
	 * Tipo de clase entity.
	 **/
	private Class<T> entityClass;

	/** 
	 * Conexion a Base de Datos.
	 **/
	private Session sesion;

	/**
	 * Metodo constructor.
	 * @param sesion
	 */
	@SuppressWarnings("unchecked")
	protected CommonDaoImpl(Session sesion) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.sesion = sesion;
	}

	//Metodo para insertar el parametro T.
	@Override
	public void insert(final T parametroT) {

		/**
		 * Comprobacion sesion abierta.
		 */
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}

		/**
		 * Insertar parametroT.
		 */
		sesion.save(parametroT);
		sesion.flush();

		/**
		 * Commitear.
		 */
		sesion.getTransaction().commit();
	}

	//Metodo para actualizar el parametro T.
	@Override
	public void update(final T parametroT) {

		/**
		 * Comprobacion sesion abierta.
		 */
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}

		/**
		 * Insertar parametroT.
		 */
		sesion.saveOrUpdate(parametroT);

		/**
		 * Commitear.
		 */
		sesion.getTransaction().commit();
	}

	//Metodo para eliminar el parametro T.
	@Override
	public void delete(final T paramT) {

		/**
		 * Comprobacion sesion abierta.
		 */
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}

		/**
		 * Insertar parametroT.
		 */
		sesion.delete(paramT);

		/**
		 * Commitear.
		 */
		sesion.getTransaction().commit();
	}

	//Metodo para localizar por llave primaria.
	@Override
	public T searchById(final Long id) {

		/**
		 * Comprobacion sesion abierta.
		 */
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}

		/**
		 * Localizacion por llave primaria.
		 */
		return sesion.get(this.entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {

		/**
		 * Comprobacion sesion abierta.
		 */
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}

		/**
		 * Localizacion de registros.
		 */
		return sesion.createQuery("FROM " + this.entityClass.getName()).list();

	}

	/**
	 * @return entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param establecer entityClass 
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
