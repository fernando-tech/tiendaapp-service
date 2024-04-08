package mx.tiendaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.tiendaapp.model.Producto;

@Repository
public interface IProductosRepository extends JpaRepository<Producto, Integer> {

}
