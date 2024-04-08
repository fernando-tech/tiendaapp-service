package mx.tiendaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.tiendaapp.model.Marca;

@Repository
public interface IMarcasRepository extends JpaRepository<Marca, Integer> {

}
