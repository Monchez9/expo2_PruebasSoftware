package ucr.fod.fod_requisiciones.Proveedores;

import org.springframework.stereotype.Service;
import ucr.fod.fod_requisiciones.Modelos.Proveedor;

import java.util.List;

@Service
public class ProveedorServicio implements IProveedorServicio {

    private final ProveedorRepositorio proveedorRepositorio;

    public ProveedorServicio(ProveedorRepositorio proveedorRepositorio) {
        this.proveedorRepositorio = proveedorRepositorio;
    }

    @Override
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepositorio.save(proveedor);
    }

    @Override
    public List<Proveedor> getProveedores() {
        return proveedorRepositorio.findAll();
    }

    @Override
    public Proveedor getProveedor(Integer idProveedor) {
        return proveedorRepositorio.findById(idProveedor).orElseThrow();
    }

    @Override
    public void eliminarProveedor(Integer idProveedor) {
        proveedorRepositorio.deleteById(idProveedor);
    }

    @Override
    public void actualizarProveedor(Proveedor proveedor) {
        proveedorRepositorio.save(proveedor);
    }
}
