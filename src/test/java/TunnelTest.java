import com.saucelabs.selenium.client.factory.SeleniumFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

/**
 * @author Ross Rowe
 */
public class TunnelTest {

    protected static final String DEFAULT_SAUCE_DRIVER = "sauce-ondemand:?max-duration=300&os=windows 2008&browser=firefox&browser-version=4.";
    private int code;
    private WebDriver selenium;

    @Before
    public void setUp() throws Exception {
        String driver = System.getenv("SELENIUM_DRIVER");
        if (driver == null || driver.equals("")) {
            System.setProperty("SELENIUM_DRIVER", DEFAULT_SAUCE_DRIVER);
        }

        System.setProperty("SELENIUM_STARTING_URL", "http://www.amazon.com/");
        selenium = SeleniumFactory.createWebDriver();
    }

    @After
    public void tearDown() throws Exception {
        selenium.quit();
    }

    /**
     * Start a web server locally, and have Sauce OnDemand connect to the local server.
     */
    @Test
    public void fullRun() throws Exception {

        //selenium.start();
        selenium.get("http://www.amazon.com/");
        // if the server really hit our Jetty, we should see the same title that includes the secret code.
        assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", selenium.getTitle());


    }

    /**
     * Start a web server locally, and have Sauce OnDemand connect to the local server.
     */
    @Test
    public void failure() throws Exception {

        //selenium.start();
        selenium.get("http://www.amazon.com/");
        // if the server really hit our Jetty, we should see the same title that includes the secret code.
        assertEquals("Blah", selenium.getTitle());

    }
}
