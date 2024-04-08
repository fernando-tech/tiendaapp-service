package mx.tiendaapp.model.DTO;

import java.io.Serializable;


public class InventarioDto implements Serializable {

	/**
	 * serial de la clase
	 */
	private static final long serialVersionUID = 8746596996998864087L;

	private Integer idInventario;
	
	private Integer cantidadProducto;
	
	private ProductoDto producto;

	public Integer getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
	}

	public Integer getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(Integer cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public ProductoDto getProducto() {
		return producto;
	}

	public void setProducto(ProductoDto producto) {
		this.producto = producto;
	}

}
