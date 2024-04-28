package kk.base.core.controller;

import jakarta.transaction.Transactional;
import kk.base.core.dto.LoginDto;
import kk.base.core.dto.LoginResponse;
import kk.base.core.dto.SignUpDto;
import kk.base.core.service.JwtAuthServiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Transactional
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);
    public AuthController(JwtAuthServiceService jwtAuthServiceService) {
        this.jwtAuthServiceService = jwtAuthServiceService;
    }

    private final JwtAuthServiceService jwtAuthServiceService;
    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponse> signIn(@RequestBody LoginDto loginDto) {
        logger.info(loginDto.toString()+" is trying to log in");
        return ResponseEntity.ok(jwtAuthServiceService.signIn(loginDto));
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<SignUpDto> signUp(@RequestBody SignUpDto signUpDto) {
        jwtAuthServiceService.signUp(signUpDto);
        return ResponseEntity.ok(signUpDto);
    }

}
