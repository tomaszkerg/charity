package pl.coderslab.charity.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "institutions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstitutionEntity extends ParentEntity{

    private String name;
    private String description;
    private Boolean enabled = Boolean.FALSE;
}