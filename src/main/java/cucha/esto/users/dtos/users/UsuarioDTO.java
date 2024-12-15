package cucha.esto.users.dtos.users;

import cucha.esto.users.models.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private String nombre;
    private String email;
    private String password;
    private TipoUsuario tipoUsuario;
}