package mx.tiendaapp.model.DTO;

import java.io.Serializable;


public class CategoriaDto implements Serializable {

	/**
	 * serial de la clase
	 */
	private static final long serialVersionUID = 2295337350905430787L;

	private Integer idCategoria;
	
	private String nombreCategoria;

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
}
