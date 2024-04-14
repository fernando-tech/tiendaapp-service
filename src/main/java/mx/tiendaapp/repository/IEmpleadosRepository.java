package mx.tiendaapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.tiendaapp.model.Empleado;

@Repository
public interface IEmpleadosRepository extends JpaRepository<Empleado, Integer> {


}
