package ucr.fod.fod_requisiciones.Proveedores;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.fod.fod_requisiciones.Modelos.Proveedor;

import java.util.List;

@RestController
@RequestMapping("api/proveedor")
@Tag(name = "Proveedores", description = "API para la gestión de proveedores")
public class ProveedorControlador {

    private final ProveedorServicio proveedorServicio;

    public ProveedorControlador(ProveedorServicio proveedorServicio) {
        this.proveedorServicio = proveedorServicio;
    }

    @Operation(summary = "Obtener todos los proveedores", description = "Retorna una lista con todos los proveedores registrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de proveedores obtenida exitosamente"),
            @ApiResponse(responseCode = "401", description = "No autorizado")
    })
    @GetMapping
    public ResponseEntity<List<Proveedor>> getAllProveedores() {
        return ResponseEntity.ok(this.proveedorServicio.getProveedores());
    }

    @Operation(summary = "Obtener proveedor por ID", description = "Retorna un proveedor específico según su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Proveedor encontrado"),
            @ApiResponse(responseCode = "404", description = "Proveedor no encontrado"),
            @ApiResponse(responseCode = "401", description = "No autorizado")
    })
    @GetMapping("{idProveedor}")
    public ResponseEntity<Proveedor> getProveedorPorId(
            @Parameter(description = "ID del proveedor a buscar") @PathVariable Integer idProveedor) {
        return ResponseEntity.ok(this.proveedorServicio.getProveedor(idProveedor));
    }

    @Operation(summary = "Eliminar proveedor", description = "Elimina un proveedor del sistema según su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Proveedor eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Proveedor no encontrado"),
            @ApiResponse(responseCode = "401", description = "No autorizado")
    })
    @DeleteMapping("{idProveedor}")
    public ResponseEntity<Void> deleteProveedorPorId(
            @Parameter(description = "ID del proveedor a eliminar") @PathVariable Integer idProveedor) {
        this.proveedorServicio.eliminarProveedor(idProveedor);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Crear proveedor", description = "Crea un nuevo proveedor en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Proveedor creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"),
            @ApiResponse(responseCode = "401", description = "No autorizado")
    })
    @PostMapping
    public ResponseEntity<Proveedor> createProveedor(
            @Parameter(description = "Datos del proveedor a crear") @RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(this.proveedorServicio.guardarProveedor(proveedor));
    }

    @Operation(summary = "Actualizar proveedor", description = "Actualiza los datos de un proveedor existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Proveedor actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Proveedor no encontrado"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"),
            @ApiResponse(responseCode = "401", description = "No autorizado")
    })
    @PutMapping("{idProveedor}")
    public ResponseEntity<Proveedor> updateProveedor(
            @Parameter(description = "Datos del proveedor a actualizar") @RequestBody Proveedor proveedor,
            @Parameter(description = "ID del proveedor a actualizar") @PathVariable Integer idProveedor) {
        return ResponseEntity.ok(this.proveedorServicio.guardarProveedor(proveedor));
    }
}
