package services;

import java.util.Collection;
import java.util.TimeZone;

/**
 * Provides the main service for obtaining TZ
 */
public interface TZService {
    /**
     * @return all time zones known to the service.
     */
    Collection<TimeZone> getAll();

    /**
     * Get a time zone given its id.
     *
     * @param id The TimeZone id.
     * @return the time zone or null if one cannot be found.
     */
    TimeZone getTz(String id);
}
