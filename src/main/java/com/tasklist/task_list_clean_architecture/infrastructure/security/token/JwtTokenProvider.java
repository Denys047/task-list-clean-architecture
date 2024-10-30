package com.tasklist.task_list_clean_architecture.infrastructure.security.token;

import com.tasklist.task_list_clean_architecture.application.interfaces.security.TokenProvider;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import static com.tasklist.task_list_clean_architecture.infrastructure.security.consts.JwtExceptions.*;

@Slf4j
public class JwtTokenProvider implements TokenProvider {

    @Value("${application.jwt.secretKey}")
    private String secretKey;

    @Value("${application.jwt.expirationSeconds}")
    private Long expirationSeconds;

    @Value("${application.jwt.issuser}")
    private String issuer;

    @Override
    public String generateToken(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication;
        return Jwts
                .builder()
                .header().add("typ", "JWS").and()
                .id(UUID.randomUUID().toString())
                .issuer(issuer)
                .subject(TokenSubject.WEB_AUTH_TOKEN.name())
                .audience().add(TokenAudience.WEB.name()).and()
                .issuedAt(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
                .expiration(Date.from(LocalDateTime.now().plusSeconds(expirationSeconds).atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(getKey())
                .compact();
    }

    @Override
    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith(getKey()).build().parse(token);
            return true;
        } catch (MalformedJwtException e) {
            log.error(INVALID_JWT_TOKEN, e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error(JWT_EXPIRED, e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error(JWT_UNSUPPORTED, e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error(JWT_EMPTY, e.getMessage());
        }
        return false;
    }

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
    }

}
