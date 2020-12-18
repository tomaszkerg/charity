package pl.coderslab.charity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("sandbox")
@ContextConfiguration({"classpath*:spring/applicationContext.xml"})
public class CharityApplicationTests {

    @Test
    public void contextLoads() {
    }

}
