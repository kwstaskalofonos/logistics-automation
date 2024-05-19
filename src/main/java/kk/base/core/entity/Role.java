package kk.base.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "web_role")
public class Role implements Serializable {

    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_web_role")
    @SequenceGenerator(name = "sequence_web_role", sequenceName = "sequence_web_role", allocationSize = 1)
    private Long id;
    @Column
    @Enumerated(EnumType.STRING)
    private WebRoles name;

    public WebRoles getName() { return name; }

    public enum WebRoles {
        CUSTOMER,
        LOGISTICS,
        STORAGE,
        COORDINATOR
    }

    @Override
    public String toString() {
        return getName().name();
    }
}
