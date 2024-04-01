package kk.base.core.service;

import jakarta.transaction.Transactional;
import kk.base.core.dto.LoginDto;
import kk.base.core.dto.SignUpDto;
import kk.base.core.entity.WebUser;
import kk.base.core.repository.WebUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
public class JwtAuthServiceService implements AuthenticationService{

    private final JwtService jwtService;
    private final WebUserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final WebUserRepository webUserRepository;
    private final PasswordEncoder passwordEncoder;

    public JwtAuthServiceService(JwtService jwtService,
                                 WebUserDetailsService userDetailsService,
                                 AuthenticationManager authenticationManager,
                                 WebUserRepository webUserRepository, PasswordEncoder passwordEncoder) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.webUserRepository = webUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginDto signIn(LoginDto loginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        UserDetails user = userDetailsService.loadUserByUsername(loginDto.getUsername());
        loginDto.setToken(jwtService.generateToken(user));
        return loginDto;
    }

    @Override
    public void signUp(SignUpDto signUpDto) {
        WebUser user = WebUser.builder()
                .creationDate(LocalDateTime.now())
                .firstName(signUpDto.getFirstname())
                .username(signUpDto.getUsername())
                .lastName(signUpDto.getLastname())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .isAccountNonLocked(true)
                .isAccountNonExpired(true)
                .isEnabled(true)
                .isCredentialsNonExpired(true)
                .build();
        webUserRepository.save(user);
    }
}
