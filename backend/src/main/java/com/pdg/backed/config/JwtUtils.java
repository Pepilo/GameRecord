package com.pdg.backed.config;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/*RS256 needed if using auth as a microservice */

@Configuration
public class JwtUtils {

    @Value("${app.secret.key}")
    private String secretKey;

    @Value("${app.expiration-time}")
    private long expirationTime;

    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }

    private String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(username)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
            .signWith(getSignKey(), SignatureAlgorithm.HS256) 
            .compact();
    }

    private Key getSignKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        String userName = extractUsername(token);
        return (userName.equals(userDetails.getUserName()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpirationDate(token).before(new Date());
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpirationDate(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
            .setSigningKey(getSignKey())
            .parseClaimsJws(token) 
            .getBody();
    }
}