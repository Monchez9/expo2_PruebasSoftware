package ucr.fod.fod_requisiciones.Proveedores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ucr.fod.fod_requisiciones.Modelos.Proveedor;

import java.util.List;

public interface IProveedorServicio {
    Proveedor guardarProveedor(Proveedor proveedor);

    List<Proveedor> getProveedores();

    @GetMapping("{idProveedor}")
    Proveedor getProveedor(@PathVariable Integer idProveedor);

    void eliminarProveedor(Integer idProveedor);

    void actualizarProveedor(Proveedor proveedor);
}
