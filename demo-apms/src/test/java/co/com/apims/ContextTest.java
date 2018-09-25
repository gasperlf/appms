package co.com.apims;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes=Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestPropertySource({"classpath:application.properties"})
public abstract class ContextTest {

}
