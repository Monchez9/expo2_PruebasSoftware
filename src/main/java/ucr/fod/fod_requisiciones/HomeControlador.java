package ucr.fod.fod_requisiciones;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeControlador {

    @GetMapping
    public ResponseEntity<Map<String, Object>> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("application", "Fod Requisiciones API");
        response.put("version", "0.0.1-SNAPSHOT");
        response.put("status", "running");
        
        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("Listar proveedores", "GET /api/proveedor");
        endpoints.put("Obtener proveedor", "GET /api/proveedor/{id}");
        endpoints.put("Crear proveedor", "POST /api/proveedor");
        endpoints.put("Actualizar proveedor", "PUT /api/proveedor/{id}");
        endpoints.put("Eliminar proveedor", "DELETE /api/proveedor/{id}");
        
        response.put("endpoints", endpoints);
        response.put("authentication", "Basic Auth (user: admin, password: secret)");
        
        return ResponseEntity.ok(response);
    }
}
