package com.workpro.mytaxitravel.Security;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    // Clave secreta para firmar el token
    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Genera el token con el email del usuario
    public String generarToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 horas
                .signWith(secretKey)
                .compact();
    }

    // Obtiene el email guardado dentro del token
    public String obtenerEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Valida que el token sea correcto
    public boolean validarToken(String token) {
        try {
            obtenerEmail(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
