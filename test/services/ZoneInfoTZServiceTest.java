package services;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class ZoneInfoTZServiceTest {
    private static final int TZ_SIZE = 132;

    private ZoneInfoTZService tzService;

    @Before
    public void setup() {
        tzService = new ZoneInfoTZService();
    }

    @Test
    public void shouldGetAllTzs() {
        final Collection<TimeZone> tzs = tzService.getAll();
        assertEquals(TZ_SIZE, tzs.size());
    }
}
