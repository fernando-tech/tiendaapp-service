package mx.tiendaapp.model.DTO;

import java.io.Serializable;


public class ProveedorDto implements Serializable {

	/**
	 * serial de la clase
	 */
	private static final long serialVersionUID = -3417753234416741231L;
	
	private Integer idProveedor;
	
	private String nombre;
	
	private String rfc;
	
	private String telefono;
	
	private String direccion;

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
