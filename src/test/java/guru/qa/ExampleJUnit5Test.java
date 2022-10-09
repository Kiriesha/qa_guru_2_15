package guru.qa;

import org.junit.jupiter.api.*;

import java.lang.module.Configuration;

public class ExampleJUnit5Test {

    @BeforeAll
    static void configure (){
      //  Configuration.browser = "chrome";
        System.out.println("this is @BeforeAll");
    }

    @AfterAll
    static void after (){
        System.out.println("this is @AfterAll");
    }

    @BeforeEach
    void bef_each(){
        System.out.println("this is @BeforeEach");
    }

    @BeforeEach
    void After_each(){
        System.out.println("this is @AfterEach");
    }

    @Test
    void FTest(){
        System.out.println("this is @FTest");
    }

    @Test
    void STest(){
        System.out.println("this is @STest");
    }

    @Test
    void firstTest(){
        //ассерты - утверждения
        Assertions.assertTrue(3>2);
    }
}



