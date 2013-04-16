package dtos;

/**
 * Summary of time zone information.
 */
public class TZSummary {

    private final String id;
    private final String name;

    public TZSummary(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
