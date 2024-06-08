package kk.base.core.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "web_user_role")
public class WebUserRole {
    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_web_user_role")
    @SequenceGenerator(name = "sequence_web_user_role", sequenceName = "sequence_web_user_role", allocationSize = 1)
    private Long id;
    @Column(name = "user_id")
    private WebUser user;
    @Getter
    @Column(name = "role_id")
    private Role role;

}
