package pl.coderslab.charity.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "categories")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity extends ParentEntity{

    private String name;
}
