package mx.tiendaapp.model.DTO;

import java.io.Serializable;


public class MarcaDto implements Serializable {

	/**
	 * serial de la clase
	 */
	private static final long serialVersionUID = 1833671557921569592L;
	private Integer idMarca;
	
	private String nombreMarca;

	public Integer getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}

	public String getNombreMarca() {
		return nombreMarca;
	}

	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
	
}
