package com.onemillion.bankmanager.service;

import com.onemillion.bankmanager.dto.response.TokenResponseDto;
import com.onemillion.bankmanager.entity.Token;
import com.onemillion.bankmanager.repository.TokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TokenService {
    private final TokenRepository tokenRepository;


    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Transactional
    public Token save(TokenResponseDto token){
        return tokenRepository.save(Token.builder()
                        .accessToken(token.getAccessToken())
                        .refreshToken(token.getRefreshToken())
                        .tokenType(token.getTokenType())
                        .expiresIn(token.getExpiresIn())
                        .scope(token.getScope())
                        .userSeqNo(token.getUserSeqNo())
                .build());
    }
}
