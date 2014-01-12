package za.co.hiddenvillage.endpoint;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import za.co.hiddenvillage.rest.JaxRSActivator;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * User: Wessel Pieterse <wessel<at>ordercloud<dot>co<dot>za>
 * Date: 2014/01/12
 * Time: 4:48 PM
 */
@RunWith(Arquillian.class)
public class HelloWorldTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @ArquillianResource
    private URL deploymentURL;

    @Deployment(testable = false)
    public static WebArchive create()
    {
        return ShrinkWrap.create(WebArchive.class)
                .addPackage(HelloWorld.class.getPackage())
                .addClasses(JaxRSActivator.class);
    }

    /**
     * Arquillian calculates resource path by using deployment URL+ArquillianResteasyResource.value which is by default "rest".
     * If your API is located under different root i.e. "api_v2" then use @ArquillianResteasyResource("api_v2")
     *
     * @param resource configured resource ready for use, injected by Arquillian
     */
    @Test
    public void getSayHello(@ArquillianResteasyResource("api") HelloWorld resource)
    {
        //        Given
        final String value = "Hello World";

        //        When
        final Response result = resource.sayHello();

        //        Then
        assertNotNull(result);
        assertEquals(result.getMediaType(), MediaType.APPLICATION_JSON);
        assertEquals(result.getStatus(), 200);
    }
}
