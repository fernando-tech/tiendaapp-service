package mx.tiendaapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.tiendaapp.model.Usuario;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuario, Integer> {


}
