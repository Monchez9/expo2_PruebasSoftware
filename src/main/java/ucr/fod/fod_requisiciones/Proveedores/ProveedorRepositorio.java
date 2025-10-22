package ucr.fod.fod_requisiciones.Proveedores;

import ucr.fod.fod_requisiciones.Modelos.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepositorio  extends JpaRepository<Proveedor, Integer> {
}
