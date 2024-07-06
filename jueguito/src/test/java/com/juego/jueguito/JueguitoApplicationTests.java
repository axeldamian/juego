package com.juego.jueguito;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JueguitoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
    void applicationContextTest() {
        JueguitoApplication.main(new String[] {});
    }

}
