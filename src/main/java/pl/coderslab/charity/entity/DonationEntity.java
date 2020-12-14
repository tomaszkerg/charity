package pl.coderslab.charity.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DonationEntity extends ParentEntity{

    private Integer quantity;
    @ManyToMany
    private List<CategoryEntity> categories;
    @ManyToOne
    private InstitutionEntity institution;
    private String street;
    private String city;
    private String zipCode;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;
}
