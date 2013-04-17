import org.junit.*;
import play.libs.WS;

import static org.junit.Assert.assertEquals;
import static play.test.Helpers.*;

public class ApplicationIT {

    public static final int TEST_PORT = 3333;
    public static final String TEST_URL = "http://localhost:" + TEST_PORT;
    public static final int TZS_RESP_SIZE = 4986;

    @Test
    public void shouldReturnAllTzs() {
        running(testServer(TEST_PORT), new Runnable() {
            public void run() {
                assertEquals(TZS_RESP_SIZE,
                        WS.url(TEST_URL + "/tzs").get().get().getBody().length()
                );
            }
        });

    }

    @Test
    public void shouldReturnSydneyTz() {
        running(testServer(TEST_PORT), new Runnable() {
            public void run() {
                assertEquals("{\"id\":\"Australia/Sydney\",\"name\":\"EST\",\"time\":0,\"utcOffset\":36000000}",
                        WS.url(TEST_URL + "/tzs/Australia/Sydney").setQueryParameter("time", "0").get().get().getBody()
                );
            }
        });

    }

}
