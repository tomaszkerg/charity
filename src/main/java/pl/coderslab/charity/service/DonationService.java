package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.DonationEntity;
import pl.coderslab.charity.repository.DonationRepository;

@Service
public class DonationService implements DonationServiceI{

    private final DonationRepository donationRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }


    @Override
    public Integer returnNumberOfDonations() {
        return donationRepository.findAll().size();
    }

    @Override
    public Integer returnNumberOfBags() {
        return donationRepository.findAll().stream()
                .mapToInt(DonationEntity::getQuantity)
                .sum();
    }
}
