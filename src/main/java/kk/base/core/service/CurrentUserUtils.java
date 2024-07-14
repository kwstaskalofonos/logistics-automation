package kk.base.core.service;

import kk.base.core.entity.Company;
import kk.base.core.entity.WebUser;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class CurrentUserUtils {


    public static Company getCompany() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            throw new AuthenticationCredentialsNotFoundException("Current user is not authenticated");
        }
        WebUser user = (WebUser) authentication.getPrincipal();
        return user.getCompany();
    }
}
