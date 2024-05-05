package mx.tiendaapp.model.DTO;

import java.io.Serializable;

public class UsuarioAltaRequest implements Serializable {

	/**
	 * serial de la clase
	 */
	private static final long serialVersionUID = -8757796836773815088L;
	
	private String nombre;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private Integer puesto;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Integer getPuesto() {
		return puesto;
	}

	public void setPuesto(Integer puesto) {
		this.puesto = puesto;
	}

}
