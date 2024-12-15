package cucha.esto.users.services;

import cucha.esto.users.dtos.users.UsuarioDTO;
import cucha.esto.users.dtos.users.UsuarioResponseDTO;
import cucha.esto.users.entities.UsuarioEntity;
import cucha.esto.users.repositories.UsuarioRepository;
import cucha.esto.users.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UsuarioResponseDTO register(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));
        usuario.setTipoUsuario(usuarioDTO.getTipoUsuario());

        usuarioRepository.save(usuario);

        UsuarioResponseDTO response = new UsuarioResponseDTO();
        response.setNombre(usuario.getNombre());
        response.setEmail(usuario.getEmail());
        response.setTipoUsuario(usuario.getTipoUsuario());
        return response;
    }

    public String login(String email, String password) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent() && passwordEncoder.matches(password, usuario.get().getPassword())) {
            return jwtUtil.generateToken(usuario.get());
        }
        throw new RuntimeException("Credenciales inválidas");
    }
}
