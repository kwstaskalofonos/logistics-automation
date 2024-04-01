package kk.base.core.controller;

import jakarta.transaction.Transactional;
import kk.base.core.dto.LoginDto;
import kk.base.core.dto.SignUpDto;
import kk.base.core.service.JwtAuthServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Transactional
public class AuthController {

    public AuthController(JwtAuthServiceService jwtAuthServiceService) {
        this.jwtAuthServiceService = jwtAuthServiceService;
    }

    private final JwtAuthServiceService jwtAuthServiceService;
    @PostMapping(value = "/login")
    public ResponseEntity<LoginDto> signIn(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(jwtAuthServiceService.signIn(loginDto));
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<SignUpDto> signUp(@RequestBody SignUpDto signUpDto) {
        jwtAuthServiceService.signUp(signUpDto);
        return ResponseEntity.ok(signUpDto);
    }

}
