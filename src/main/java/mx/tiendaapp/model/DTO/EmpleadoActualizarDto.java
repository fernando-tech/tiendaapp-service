package mx.tiendaapp.model.DTO;

import java.io.Serializable;

public class EmpleadoActualizarDto implements Serializable {

	/**
	 * serial de la clase
	 */
	private static final long serialVersionUID = 6515514916725998421L;
	
	private Integer puesto;
	
	private Boolean estatus;

	public Integer getPuesto() {
		return puesto;
	}

	public void setPuesto(Integer puesto) {
		this.puesto = puesto;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
	
}
