package kk.base.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "web_user")
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class WebUser implements UserDetails {
    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_web_user")
    @SequenceGenerator(name = "sequence_web_user", sequenceName = "sequence_web_user", allocationSize = 1)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "is_enabled")
    private boolean isEnabled;
    @Column(name = "account_non_locked")
    private boolean isAccountNonLocked;
    @Column(name = "account_non_expired")
    private boolean isAccountNonExpired;
    @Column(name = "credentials_non_expired")
    private boolean isCredentialsNonExpired;
    @Column(name = "last_login_date")
    private LocalDateTime lastLoginDate;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }


}
