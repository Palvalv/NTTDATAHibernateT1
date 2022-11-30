package nttdata.hibernate.persistence.dao.interfaces;

import java.util.List;

/**
 * Interfaz DAO Comun.
 * @param <T>
 */
public interface CommonDaoI<T> {

	/**
	 * Insertar en Base de Datos.
	 * @param parametroT
	 */
	public void insert(final T parametroT);

	/**
	 * Actualizar en Base de Datos.
	 * @param parametroT
	 */
	public void update(final T parametroT);
	
	/**
	 * Eliminar en Base de Datos.
	 * @param parametroT
	 */
	public void delete(final T parametroT);
	
	/**
	 * Localizar por ID en Base de Datos.
	 * @param parametroT
	 */
	public T searchById(final Long id);

	/**
	 * Localizacion registros en Base de Datos.
	 * @return List<T>
	 */
	public List<T> searchAll();

}