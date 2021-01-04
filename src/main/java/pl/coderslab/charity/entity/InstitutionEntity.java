package pl.coderslab.charity.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "institutions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstitutionEntity extends ParentEntity{

    private String name;
    private String description;
    private Boolean enabled = Boolean.FALSE;
}