package pl.coderslab.charity.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.coderslab.charity.repository.InstitutionRepository;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class InstitutionServiceTests {

    @Autowired
    private InstitutionServiceI institutionService;
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private InstitutionRepository institutionRepository;

    @Test
    public void shouldMultiply(){
        int result = 4;

        int check = institutionService.multiply(2);

        assertEquals(result,check);
    }


}
