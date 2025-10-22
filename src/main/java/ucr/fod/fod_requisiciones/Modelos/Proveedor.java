package ucr.fod.fod_requisiciones.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ucr.fod.fod_requisiciones.Proceso;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 128)
    private String nombre;

    @Column(name = "nombre_comercial", nullable = false, length = 128)
    private String nombreComercial;

    @Column(name = "correo", nullable = false, length = 128)
    private String correo;

    @Column(name = "numero_telefono", nullable = false, length = 20)
    private String numeroTelefono;

    @Column(name = "iban", nullable = false, length = 34)
    private String iban;

    @Column(name = "cedula_identidad", length = 20)
    private String cedulaIdentidad;

    @Column(name = "cedula_juridica", length = 20)
    private String cedulaJuridica;

    /*
    @OneToMany
    @JoinColumn(name = "id_proveedor")
    private Set<Proceso> procesos = new LinkedHashSet<>();
    */

}