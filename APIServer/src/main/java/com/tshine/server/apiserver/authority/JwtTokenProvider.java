package com.tshine.server.apiserver.authority;

import com.tshine.server.apiserver.entities.user.UserInfo;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider implements InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(JwtTokenProvider.class);
    private final String JWT_KEYSECRET = "tqduy025.dev";
    private static final long JWT_EXPIRATION = 24*60*60*1000L;
    private static JwtTokenProvider instance;

    public static JwtTokenProvider getInstance(){
        return instance;
    }

    public String generateToken(MyUserDetail userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        return Jwts.builder()
                .claim("userId", userDetails.getUserInfo().getUserId())
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_KEYSECRET)
                .compact();
    }

    public String getUserMailFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_KEYSECRET)
                .parseClaimsJws(token)
                .getBody();
        return String.valueOf(claims.getSubject());
    }

    public String getUserIdFromAuth() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof MyUserDetail) {
            return ((MyUserDetail) principal).getUserInfo().getUserId();
        } else {
            return principal.toString();
        }
    }

    public UserInfo getUserFromAuth() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof MyUserDetail) {
            return ((MyUserDetail) principal).getUserInfo();
        }else {
            throw new NullPointerException();
        }
    }


    public boolean validateToken(String authToken) {
        try {
            if(!authToken.isEmpty()){
                Jwts.parser().setSigningKey(JWT_KEYSECRET).parseClaimsJws(authToken);
                return true;
            }
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty");
        }catch (SignatureException ex){
            log.error("JWT signature does not match locally computed signature");
        }
        return false;
    }


    @Override
    public void afterPropertiesSet(){
        instance = this;
    }
}
