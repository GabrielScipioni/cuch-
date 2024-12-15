package cucha.esto.users.models.users;

import cucha.esto.users.models.enums.TipoUsuario;

public class User {

    private Long id;

    private String nombre;

    private String email;

    private String password;

    private TipoUsuario tipoUsuario;
}
