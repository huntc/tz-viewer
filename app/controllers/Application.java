package controllers;

import dtos.TZDetail;
import dtos.TZSummary;
import org.codehaus.jackson.map.ObjectMapper;
import play.cache.Cache;
import play.cache.Cached;
import play.mvc.*;
import services.ZoneInfoTZService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TimeZone;

/**
 * The main set of web services.
 */
@Singleton
public class Application extends Controller {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final ZoneInfoTZService tzService;

    @Inject
    public Application(final ZoneInfoTZService tzService) {
        this.tzService = tzService;
    }

    public Result index() {
        return ok(views.html.index.render());
    }

    @Cached(key = "tzs")
    public Result tzs() throws IOException {
        final Collection<TimeZone> tzs = tzService.getAll();
        final Collection<TZSummary> summaries = new ArrayList<>(tzs.size());
        for (final TimeZone tz : tzs) {
            summaries.add(new TZSummary(tz.getID(), tz.getDisplayName()));
        }
        return ok(OBJECT_MAPPER.writeValueAsString(summaries));
    }

    public Result tz(final String id, final Long time) throws IOException {
        final String key = "tz" + id + time;
        final Result cachedResult = (Result) Cache.get(key);
        if (cachedResult == null) {
            final TimeZone tz = tzService.getTz(id);
            if (tz == null) {
                return notFound();
            } else {
                final TZDetail detail = new TZDetail(tz.getID(), tz.getDisplayName(), time, tz.getOffset(time));
                final Result result = ok(OBJECT_MAPPER.writeValueAsString(detail));
                Cache.set(key, result);
                return result;
            }
        } else {
            return cachedResult;
        }
    }
}
