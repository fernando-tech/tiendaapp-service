package mx.tiendaapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.tiendaapp.model.Empleado;

@Repository
public interface IEmpleadosRepository extends JpaRepository<Empleado, Integer> {

	@Query(value = "SELECT e FROM Empleado e WHERE activo = true")
	List<Empleado> empleadosActivos();

}
