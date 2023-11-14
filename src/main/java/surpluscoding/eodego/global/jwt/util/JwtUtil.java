package surpluscoding.eodego.global.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import surpluscoding.eodego.global.jwt.auth.AuthDetails;
import surpluscoding.eodego.global.jwt.auth.AuthDetailsService;

import java.util.Collections;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final AuthDetailsService authDetailsService;

    @Value("${jwt.secret_key}")
    private String secretKey;

    @Value("${jwt.prefix}")
    private String prefix;

    public String generateJwt(Long userId) {
        Claims claims = Jwts.claims();
        Date now = new Date();
        claims.put("userId", userId);

        long exp = 30 * 60 * 1000L;
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + exp))
                .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey)), SignatureAlgorithm.HS256)
                .compact();
    }

    public String resolveJwt(HttpServletRequest request) {
        String bearer = request.getHeader("Authorization");

        if (bearer == null || !bearer.startsWith(prefix)) {
            return null;
        }

        return bearer.split(" ")[1].trim();
    }

    public Authentication getAuthentication(String token) {
        AuthDetails authDetails = (AuthDetails) authDetailsService.loadUserByUsername(extractUserId(token));
        return new UsernamePasswordAuthenticationToken(authDetails, token, Collections.emptyList());
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUserId(String token) {
        return getClaims(token).get("userId").toString();
    }
}
