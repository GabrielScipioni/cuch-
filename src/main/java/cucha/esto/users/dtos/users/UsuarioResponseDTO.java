package cucha.esto.users.dtos.users;

import cucha.esto.users.models.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {
    private String nombre;
    private String email;
    private TipoUsuario tipoUsuario;
}
