package dev.padak.backend.QualityGateway;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private final String SECRET = "BArHrbA7NgzvO78EoM1scdKj3eBlseeQ9jhh6TAyJWIDxXe3gTXD9EzfPdrZ5EVm";

    public void validateToken(String token) {
        Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
    }

    public String extractUsername(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}