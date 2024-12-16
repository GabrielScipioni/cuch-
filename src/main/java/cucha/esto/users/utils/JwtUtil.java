package cucha.esto.users.utils;

import cucha.esto.users.entities.UsuarioEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

import java.util.Date;

@Component
public class JwtUtil {

    private final Key secret = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(UsuarioEntity usuario) {
        return Jwts.builder()
                .setSubject(usuario.getEmail())
                .claim("tipoUsuario", usuario.getTipoUsuario())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
