package io.github.henryssondaniel.rockpaperscissors.v1._0;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;

/**
 * Games resource. Handles games related requests.
 *
 * @since 1.0
 */
@Path("{a:v1/games|v1.0/games|games}")
public class GamesResource {
  private static final String ID = "id";
  private static final Logger LOGGER = Logger.getLogger(GamesResource.class.getName());

  private final Collection<Game> games = new HashSet<>(0);

  @GET
  @Path("{id}")
  @Produces(MediaType.TEXT_PLAIN)
  public String checkState(@PathParam(ID) String id) {
    LOGGER.log(Level.FINE, "Check state");
    return getGame(id).map(Game::getState).orElse("The ID does not exist.");
  }

  @Consumes(MediaType.APPLICATION_JSON)
  @POST
  @Path("{id}/join")
  @Produces(MediaType.TEXT_PLAIN)
  public String join(String data, @PathParam(ID) String id) {
    LOGGER.log(Level.FINE, "Join");
    return getGame(id).map(game -> join(data, game)).orElse("The ID does not exist.");
  }

  @Consumes(MediaType.APPLICATION_JSON)
  @POST
  @Path("{id}/move")
  @Produces(MediaType.TEXT_PLAIN)
  public String move(String data, @PathParam(ID) String id) {
    LOGGER.log(Level.FINE, "Move");
    return getGame(id).map(game -> move(data, game)).orElse("The ID does not exist.");
  }

  @Consumes(MediaType.APPLICATION_JSON)
  @POST
  @Produces(MediaType.TEXT_PLAIN)
  public String newGame(String data) {
    LOGGER.log(Level.FINE, "New game");

    var message = "The key \"name\" has to be provided in the request body.";

    if (!data.isEmpty()) {
      var jsonObject = new JSONObject(data);

      if (jsonObject.has("name")) message = createGame(jsonObject);
    }

    return message;
  }

  private String createGame(JSONObject jsonObject) {
    Game game = new GameImpl(jsonObject.getString("name"));
    games.add(game);

    return game.getUuid().toString();
  }

  private Optional<Game> getGame(String id) {
    return games.stream().filter(game -> game.getUuid().toString().equals(id)).findFirst();
  }

  private static String join(String data, Game game) {
    var message = "The key \"name\" has to be provided in the request body.";

    if (!data.isEmpty()) {
      var jsonObject = new JSONObject(data);

      if (jsonObject.has("name")) message = game.join(jsonObject.getString("name"));
    }

    return message;
  }

  private static String move(String data, Game game) {
    var message = "The key \"name\" and \"move\" has to be provided in the request body.";

    if (!data.isEmpty()) {
      var jsonObject = new JSONObject(data);

      if (jsonObject.has("move") && jsonObject.has("name"))
        message = game.move(jsonObject.getString("move"), jsonObject.getString("name"));
    }

    return message;
  }
}
