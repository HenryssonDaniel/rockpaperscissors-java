package io.github.henryssondaniel.rockpaperscissors;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.henryssondaniel.rockpaperscissors.v1._0.GamesResourceImpl;
import org.junit.jupiter.api.Test;

class RestApplicationTest {
  @Test
  void getSingletons() {
    Iterable<Object> singletons = new RestApplication().getSingletons();
    assertThat(singletons).hasSize(1);
    assertThat(singletons.iterator().next()).isExactlyInstanceOf(GamesResourceImpl.class);
  }
}
