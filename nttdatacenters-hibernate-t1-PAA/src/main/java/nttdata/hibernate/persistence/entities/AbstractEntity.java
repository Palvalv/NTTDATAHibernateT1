package nttdata.hibernate.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public abstract class AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * El cliente se actualiza.
	 **/
	private String actualizarUsuario;

	/** 
	 * La fecha se actualiza.
     */
	private Date actualizarFecha;

	/**
	 * Se obtiene el ID.
	 * @return Long id
	 */
	public abstract Long getId();

	/**
	 * @return actualizarUsuario
	 */
	@Column(name = "ACTUALIZAR_USUARIO", nullable = false)
	public String getUpdatedUser() {
		return actualizarUsuario;
	}

	/**
	 * @param establecer actualizarUsuario
	 */
	public void setUpdatedUser(String updatedUser) {
		this.actualizarUsuario = updatedUser;
	}

	/**
	 * @return actualizarFecha
	 */
	@Column(name = "ACTUALIZAR_FECHA", nullable = false)
	public Date getUpdatedDate() {
		return actualizarFecha;
	}

	/**
	 * @param establecer actualizarFecha
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.actualizarFecha = updatedDate;
	}
}
