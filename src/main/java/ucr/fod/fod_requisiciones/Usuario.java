package ucr.fod.fod_requisiciones;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "correo", nullable = false, length = 128)
    private String correo;

    @Column(name = "nombre", nullable = false, length = 32)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 128)
    private String apellido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol idRol;

    @Column(name = "hash_contrasenna", nullable = false, length = 256)
    private String hashContrasenna;

    @Column(name = "sal_hash", nullable = false, length = 16)
    private String salHash;

    @ColumnDefault("1")
    @Column(name = "activo")
    private Boolean activo;

    @OneToMany
    @JoinColumn(name = "id_usuario")
    private Set<Anotacion> anotacions = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn(name = "id_autor")
    private Set<Proceso> procesos = new LinkedHashSet<>();

}