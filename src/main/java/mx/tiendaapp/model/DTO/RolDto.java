package mx.tiendaapp.model.DTO;

import java.io.Serializable;


public class RolDto implements Serializable {

	
	/**
	 * serial de la clase
	 */
	private static final long serialVersionUID = 5846207948589882244L;
	
	private Integer idRol;
	
	private String nombrePuesto;
	
	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombrePuesto() {
		return nombrePuesto;
	}

	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}

}
