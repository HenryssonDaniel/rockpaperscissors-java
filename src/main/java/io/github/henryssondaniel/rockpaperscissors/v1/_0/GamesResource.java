package io.github.henryssondaniel.rockpaperscissors.v1._0;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Games resource. Handles games related requests.
 *
 * @since 1.0
 */
@Path("{a:v1/games|v1.0/games|games}")
public class GamesResource {
  private static final String ID = "id";
  private static final Logger LOGGER = Logger.getLogger(GamesResource.class.getName());

  @POST
  @Path("{id}")
  @Produces(MediaType.TEXT_PLAIN)
  public static String checkState(@PathParam(ID) String id) {
    LOGGER.log(Level.FINE, "Check state");
    return "State...";
  }

  @Consumes(MediaType.APPLICATION_JSON)
  @POST
  @Path("{id}/join")
  public static Response join(@PathParam(ID) String id) {
    LOGGER.log(Level.FINE, "Join");
    return Response.ok().build();
  }

  @Consumes(MediaType.APPLICATION_JSON)
  @POST
  @Path("{id}/move")
  public static Response move(@PathParam(ID) String id) {
    LOGGER.log(Level.FINE, "Move");
    return Response.ok().build();
  }

  @Consumes(MediaType.APPLICATION_JSON)
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public static String newGame() {
    LOGGER.log(Level.FINE, "New game");
    return "123";
  }
}
