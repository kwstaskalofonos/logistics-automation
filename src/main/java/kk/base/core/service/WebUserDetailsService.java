package kk.base.core.service;

import kk.base.core.entity.WebUser;
import kk.base.core.repository.WebUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WebUserDetailsService implements UserDetailsService {

    @Autowired
    private WebUserRepository webUserRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<WebUser> user = webUserRepository.findByUsername(username);
        if(user.isEmpty()) {
            throw new UsernameNotFoundException("User with username "+username+" not found.");
        }
        return user.get();
    }
}
