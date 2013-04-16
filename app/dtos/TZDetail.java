package dtos;

/**
 * The detail of a time zone representing a point in timey.
 */
public class TZDetail {
    private final String id;
    private final String name;
    private final long time;
    private final int utcOffset;

    public TZDetail(final String id, final String name, final long time, final int utcOffset) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.utcOffset = utcOffset;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getTime() {
        return time;
    }

    public int getUtcOffset() {
        return utcOffset;
    }
}
