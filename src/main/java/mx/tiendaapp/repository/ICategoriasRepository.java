package mx.tiendaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.tiendaapp.model.Categoria;

@Repository
public interface ICategoriasRepository extends JpaRepository<Categoria, Integer> {

}
