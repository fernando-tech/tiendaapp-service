package mx.tiendaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.tiendaapp.model.Proveedor;

public interface IProveedoresRepository extends JpaRepository<Proveedor, Integer> {

	
}
