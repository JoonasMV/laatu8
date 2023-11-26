package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TimeUtilsTest {
    private TimeUtils converter = new TimeUtils();

    @ParameterizedTest(name="luvun {0} aika {1}")
    @CsvSource({
            "-1, -1",
            "0, 0:00:00",
            "1, 0:00:01",
            "3665, 1:01:05",
            "35999, 9:59:59",
            "36000, 10:00:00",
            "36001, -1",
            "60, 0:01:00",
            "3600, 1:00:00",
            "3661, 1:01:01"
    })
    void tests(int value, String expected) {
        assertEquals(expected, TimeUtils.secToTime(value));
    }

}