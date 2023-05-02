package com.demospring.messageapi.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    private String access_token;
    private String token_type;
    private int expires_in;
}
