package com.example.stargram.domain.auth.service;

import com.example.stargram.domain.auth.domain.RefreshToken;
import com.example.stargram.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.stargram.domain.auth.exception.InvalidPasswordException;
import com.example.stargram.domain.auth.presentation.dto.request.SignInRequest;
import com.example.stargram.domain.auth.presentation.dto.response.TokenResponse;
import com.example.stargram.domain.user.domain.User;
import com.example.stargram.domain.user.domain.repository.UserRepository;
import com.example.stargram.domain.user.exception.UserNotFoundException;
import com.example.stargram.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthSignInService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Value("${jwt.exp.refresh}")
    private Long REFRESH_TOKEN_VALID_TIME;

    public TokenResponse execute(SignInRequest signInRequest) {
        User user = userRepository.findByAccountId(signInRequest.getAccountId())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(signInRequest.getPassword(), user.getPassword())) {
            throw InvalidPasswordException.EXCEPTION;
        }

        return createToken(signInRequest.getAccountId());
    }

    public TokenResponse createToken(String name) {
        String accessToken = jwtTokenProvider.createJwtAccessToken(name);
        String refreshToken = jwtTokenProvider.createJwtRefreshToken(name);

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .userName(name)
                        .refreshToken(refreshToken)
                        .refreshExpiration(REFRESH_TOKEN_VALID_TIME)
                        .build());

        return new TokenResponse(accessToken, refreshToken);
    }

}
