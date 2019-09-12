package io.github.henryssondaniel.rockpaperscissors;

import io.github.henryssondaniel.rockpaperscissors.v1._0.GamesResource;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * REST application. This is the starting point for the REST server. All the resources will have the
 * /api/ in front of the path.
 *
 * @since 1.0
 */
@ApplicationPath("api")
public class RestApplication extends Application {
  private static final Logger LOGGER = Logger.getLogger(RestApplication.class.getName());

  @Override
  public Set<Class<?>> getClasses() {
    LOGGER.log(Level.FINE, "Get classes");
    return new HashSet<>(Collections.singletonList(GamesResource.class));
  }
}
