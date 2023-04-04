package me.test.TimeToWords.service;

import me.test.TimeToWords.service.impl.TimeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("TimeService Test")
class TimeServiceTest {

    private TimeService timeService;

    @BeforeEach
    void setUp() {
        timeService = new TimeServiceImpl();
    }

    @Test
    @DisplayName("Test converting time to words")
    void testConvertTimeToWords() {
        String actualResult = timeService.getTimeInWords("08:34");
        String expectedResult = "It's eight thirty four";
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
