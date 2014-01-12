package za.co.hiddenvillage.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * User: Wessel Pieterse <wessel<at>ordercloud<dot>co<dot>za>
 * Date: 2014/01/12
 * Time: 4:39 PM
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/helloworld")
public class HelloWorld {

    @GET
    @Path("/")
    public Response sayHello(){
        return Response.status(Response.Status.OK).entity("Hello World!").build();

    }
}
