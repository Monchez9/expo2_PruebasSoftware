package ucr.fod.fod_requisiciones.Proveedores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.fod.fod_requisiciones.Modelos.Proveedor;

import java.util.List;

@RestController
@RequestMapping("api/proveedor")
public class ProveedorControlador {

    private final ProveedorServicio proveedorServicio;

    public ProveedorControlador(ProveedorServicio proveedorServicio) {
        this.proveedorServicio = proveedorServicio;
    }

    @GetMapping
    public ResponseEntity<List<Proveedor>> getAllProveedores() {
        return ResponseEntity.ok(this.proveedorServicio.getProveedores());
    }

    @GetMapping("{idProveedor}")
    public ResponseEntity<Proveedor> getProveedorPorId(@PathVariable Integer idProveedor) {
        return ResponseEntity.ok(this.proveedorServicio.getProveedor(idProveedor));
    }

    @DeleteMapping("{idProveedor}")
    public ResponseEntity<Void> deleteProveedorPorId(@PathVariable Integer idProveedor) {
        this.proveedorServicio.eliminarProveedor(idProveedor);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Proveedor> createProveedor(@RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(this.proveedorServicio.guardarProveedor(proveedor));
    }

    @PutMapping("{idProveedor}")
    public ResponseEntity<Proveedor> updateProveedor(@RequestBody Proveedor proveedor,  @PathVariable Integer idProveedor) {
        proveedor.setId(idProveedor);
        return ResponseEntity.ok(this.proveedorServicio.guardarProveedor(proveedor));
    }
}
