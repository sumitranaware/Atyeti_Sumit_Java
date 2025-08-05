package com.example.Microservice_api_gateway.filters.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
@Service
public class JwtService {
    @Value("${jwt.secretKey}")
    private String jwtSecretKey;

    private SecretKey getsecretKey(){
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));

    }
    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getsecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return Long.valueOf(claims.getSubject());
    }

    public String getUserRoleFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getsecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.get("role", String.class);
    }
}
