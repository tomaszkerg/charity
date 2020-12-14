package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entity.InstitutionEntity;

public interface InstitutionRepository extends JpaRepository<InstitutionEntity,Long> {
}
