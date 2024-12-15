package cucha.esto.users.controllers;

import cucha.esto.users.services.UserService;
import cucha.esto.users.dtos.users.UsuarioDTO;
import cucha.esto.users.dtos.users.UsuarioResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UsuarioResponseDTO> register(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(userService.register(usuarioDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(userService.login(email, password));
    }
}
