package services;

import com.classactionpl.tz.AbstractZone;
import com.classactionpl.tz.ZoneFactory;
import com.classactionpl.tz.ZoneinfoTimeZone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TimeZone;

/**
 * Provides the main service for obtaining TZ
 */
public class ZoneInfoTZService implements TZService {

    public ZoneInfoTZService() {
        final ZoneFactory factory = new ZoneFactory();
        final Map<String, AbstractZone> zones = ZoneinfoTimeZone.getZones();
        factory.parse(ZoneInfoTZService.class.getResourceAsStream("/resources/europe"), zones);
        factory.parse(ZoneInfoTZService.class.getResourceAsStream("/resources/australasia"), zones);
    }

    @Override
    public Collection<TimeZone> getAll() {
        final String[] availableIds = ZoneinfoTimeZone.getAvailableIDs();
        final Collection<TimeZone> tzs = new ArrayList<>(availableIds.length);
        for (final String id : availableIds) {
            tzs.add(ZoneinfoTimeZone.getTimeZone(id));
        }
        return tzs;
    }

    @Override
    public TimeZone getTz(final String id) {
        return ZoneinfoTimeZone.getTimeZone(id);
    }
}
