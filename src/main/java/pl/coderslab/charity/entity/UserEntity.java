package pl.coderslab.charity.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity extends ParentEntity{

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "email", referencedColumnName = "email"))
    private Set<UserRoleEntity> roles = new HashSet<>();

    private Boolean enabled = Boolean.FALSE;

    @Column(name = "auth_provider")
    private String authProvider;
}
