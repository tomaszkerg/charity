package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entity.DonationEntity;

public interface DonationRepository extends JpaRepository<DonationEntity,Long> {
}
