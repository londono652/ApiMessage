package com.demospring.messageapi.security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.demospring.messageapi.security.dto.Token;
import com.demospring.messageapi.configure.ConstantConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class TokenController {


    @PostMapping("token")
    public Token login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

        String strToken = getJWTToken(username);
        Token token = new Token();
        token.setAccess_token(strToken);
        token.setToken_type(ConstantConfig.PREFIX);
        token.setExpires_in(ConstantConfig.expires);
        return token;

    }

    private String getJWTToken(String username) {
        String secretKey = ConstantConfig.SECRET;
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("Prueba DevOps")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + ConstantConfig.expires))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return token;
    }
}
