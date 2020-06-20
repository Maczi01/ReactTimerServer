package com.example.reacttimer;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@CrossOrigin
public class LoginController {

    @PostMapping("/login")
    public AccessToken login(@RequestBody User user) {
        long currentTimeMillis = System.currentTimeMillis();
        String compact = Jwts.builder()
                .setSubject(user.getLogin())
                .claim("roles", "user")
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + 50000))
                .signWith(SignatureAlgorithm.HS512, "secretkey")
                .compact();
        return new AccessToken(compact);
    }
}
