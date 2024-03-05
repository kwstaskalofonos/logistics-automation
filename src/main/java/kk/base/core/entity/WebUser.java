package kk.base.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "web_user")
@Getter
@Setter
public class WebUser{
    @Id
    @Column(updatable = false)
    @SequenceGenerator(name = "sequence_web_user", sequenceName = "sequence_web_user")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "is_blocked")
    private boolean isBlocked;
    @Column(name = "last_login_date")
    private LocalDateTime lastLoginDate;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
}
