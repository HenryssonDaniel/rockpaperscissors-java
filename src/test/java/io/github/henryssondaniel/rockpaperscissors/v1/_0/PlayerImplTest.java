package io.github.henryssondaniel.rockpaperscissors.v1._0;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PlayerImplTest {
  private static final String NAME = "name";
  private final Player player = new PlayerImpl(NAME);

  @Test
  void getAndSetHand() {
    player.setHand(Hand.PAPER);
    assertThat(player.getHand()).isSameAs(Hand.PAPER);
  }

  @Test
  void getHand() {
    assertThat(player.getHand()).isNull();
  }

  @Test
  void getName() {
    assertThat(player.getName()).isEqualTo(NAME);
  }
}
