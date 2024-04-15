package mx.tiendaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.tiendaapp.model.Rol;

@Repository
public interface IRolesRepository extends JpaRepository<Rol, Integer> {

}
