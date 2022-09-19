package com.example.stargram.domain.auth.presentation;

import com.example.stargram.domain.auth.presentation.dto.request.SignInRequest;
import com.example.stargram.domain.auth.presentation.dto.request.SignUpRequest;
import com.example.stargram.domain.auth.presentation.dto.response.TokenResponse;
import com.example.stargram.domain.auth.service.AuthSignInService;
import com.example.stargram.domain.auth.service.AuthSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auths")
@RestController
public class AuthController {

    private final AuthSignUpService authSignUpService;
    private final AuthSignInService authSignInService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignUpRequest signUpRequest) {
        authSignUpService.execute(signUpRequest);
    }

    @PostMapping("/signin")
    public TokenResponse signin(@RequestBody SignInRequest signInRequest) {
        return authSignInService.execute(signInRequest);
    }

}

