package kk.base.core.service;

import kk.base.core.dto.LoginDto;
import kk.base.core.dto.SignUpDto;

public interface AuthenticationService {

    LoginDto signIn(LoginDto loginDto);
    void signUp(SignUpDto signUpDto);
}
