package com.example.ctpseduction.demo.utils;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class Jwtutil {
    private static final String secretKey = "hhdgeh6ghch0dsd_shagdhafgsfdshrwQdghg";
    public static final Key jwtSecret = Keys.hmacShaKeyFor(
            secretKey.getBytes(StandardCharsets.UTF_8));
    public static long tokenLife = 60 * 60 * 1000 * 2;

    public static String getToken(String payload) {
        return Jwts.builder()
                .signWith(jwtSecret)
                .setSubject(payload)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + tokenLife))
                .compact();
    }

    public String getPayload(String token) {
        String payload = Jwts.parserBuilder()
                .setSigningKey(jwtSecret)
                .build()
                .parseClaimsJws(token)
                .getBody().getSubject();

        return payload;
    }
}
