package kk.base.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "web_user_role")
public class WebUserRole {
    @Id
    @Column(updatable = false)
    private Long id;
    @Column(name = "user_id")
    private WebUser user;
    @Column(name = "role_id")
    private Role role;
}
