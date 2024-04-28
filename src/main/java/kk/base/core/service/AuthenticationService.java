package kk.base.core.service;

import kk.base.core.dto.LoginDto;
import kk.base.core.dto.LoginResponse;
import kk.base.core.dto.SignUpDto;

public interface AuthenticationService {

    LoginResponse signIn(LoginDto loginDto);
    void signUp(SignUpDto signUpDto);
}
