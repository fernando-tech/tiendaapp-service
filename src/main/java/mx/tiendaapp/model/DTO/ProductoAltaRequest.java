package mx.tiendaapp.model.DTO;

import java.io.Serializable;

public class ProductoAltaRequest implements Serializable {

	/**
	 * serial de la clase
	 */
	private static final long serialVersionUID = -2244204931347727932L;
	
	private String nombre;
	
	private String descripcion;
	
	private String codigo;
	
	private Double precio;
	
	private Integer inventario;
	
	private Integer marca;
	
	private Integer categoria;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getInventario() {
		return inventario;
	}

	public void setInventario(Integer inventario) {
		this.inventario = inventario;
	}

	public Integer getMarca() {
		return marca;
	}

	public void setMarca(Integer marca) {
		this.marca = marca;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
	
}
