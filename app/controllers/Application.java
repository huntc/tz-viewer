package controllers;

import dtos.TZDetail;
import dtos.TZSummary;
import org.codehaus.jackson.map.ObjectMapper;
import play.mvc.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The main set of web services.
 */
public class Application extends Controller {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final int SOME_UTC_OFFSET = 10 * 60 * 60000;

    private static final Map<String, TZSummary> tzs = new HashMap<>();

    static {
        final TZSummary sydney = new TZSummary("Australia/Sydney", "Sydney");
        tzs.put(sydney.getId(), sydney);
        final TZSummary london = new TZSummary("Europe/London", "London");
        tzs.put(london.getId(), london);
    }

    public static Result tzs() throws IOException {
        return ok(OBJECT_MAPPER.writeValueAsString(tzs.values()));
    }

    public static Result tz(final String id, final Long time) throws IOException {
        final TZSummary summary = tzs.get(id);
        if (summary == null) {
            return notFound();
        } else {
            final TZDetail tz = new TZDetail(summary.getId(), summary.getName(), time, SOME_UTC_OFFSET);
            return ok(OBJECT_MAPPER.writeValueAsString(tz));
        }
    }

}
