package cucha.esto.users.entities;

import cucha.esto.users.models.enums.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Entidad de usuario
 */
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Long id;

    @Size(min = 3, max = 50)
    @Column( name = "nombre")
    private String nombre;

    @Email
    @Column( name = "email")
    private String email;

    @Size(min = 6)
    @Column( name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column( name = "tipo_usuario")
    private TipoUsuario tipoUsuario;
}
