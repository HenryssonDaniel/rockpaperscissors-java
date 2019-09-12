package io.github.henryssondaniel.rockpaperscissors.v1._0;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GamesResourceTest {
  private static final String DATA = "data";
  private static final String ID = "id";
  private static final String ID_DOES_NOT_EXIST = "The ID does not exist.";
  private static final String JSON_NAME_2 = "{\"name\": \"name2\"}";
  private static final String KEY_MOVE_MISSING =
      "The key \"name\" and \"move\" has to be provided in the request body.";
  private static final String MOVE = "{\"move\": \"move\"}";
  private static final String NAME_MISSING =
      "The key \"name\" has to be provided in the request body.";
  private static final String OK = "OK";
  private static final int UUID = 36;

  private final GamesResource gamesResource = new GamesResourceImpl();

  @Test
  void checkState() {
    assertThat(gamesResource.checkState(createNewGame()))
        .isEqualTo("Waiting for the second player to join the game.");
  }

  @Test
  void checkStateWhenIncorrectId() {
    assertThat(gamesResource.checkState(ID)).isEqualTo(ID_DOES_NOT_EXIST);
  }

  @Test
  void join() {
    assertThat(gamesResource.join(JSON_NAME_2, createNewGame())).isEqualTo(OK);
  }

  @Test
  void joinWhenDataIsEmpty() {
    assertThat(gamesResource.join("", createNewGame())).isEqualTo(NAME_MISSING);
  }

  @Test
  void joinWhenIncorrectId() {
    assertThat(gamesResource.join(DATA, ID)).isEqualTo(ID_DOES_NOT_EXIST);
  }

  @Test
  void joinWhenNameIsMissing() {
    assertThat(gamesResource.join(MOVE, createNewGame())).isEqualTo(NAME_MISSING);
  }

  @Test
  void move() {
    assertThat(gamesResource.move("{\"move\": \"rock\", \"name\": \"name\"}", createNewGame()))
        .isEqualTo(OK);
  }

  @Test
  void moveWhenDataIsEmpty() {
    assertThat(gamesResource.move("", createNewGame())).isEqualTo(KEY_MOVE_MISSING);
  }

  @Test
  void moveWhenIncorrectId() {
    assertThat(gamesResource.move(DATA, ID)).isEqualTo(ID_DOES_NOT_EXIST);
  }

  @Test
  void moveWhenMoveIsMissing() {
    assertThat(gamesResource.move(JSON_NAME_2, createNewGame())).isEqualTo(KEY_MOVE_MISSING);
  }

  @Test
  void moveWhenNameIsMissing() {
    assertThat(gamesResource.move("{\"move\": \"rock\"}", createNewGame()))
        .isEqualTo(KEY_MOVE_MISSING);
  }

  @Test
  void newGame() {
    assertThat(createNewGame()).hasSize(UUID);
  }

  @Test
  void newGameWhenDataIsEmpty() {
    assertThat(gamesResource.newGame("")).isEqualTo(NAME_MISSING);
  }

  @Test
  void newGameWhenEmpty() {
    assertThat(gamesResource.newGame("")).isEqualTo(NAME_MISSING);
  }

  @Test
  void newGameWhenNameIsMissing() {
    assertThat(gamesResource.newGame(MOVE)).isEqualTo(NAME_MISSING);
  }

  private String createNewGame() {
    return gamesResource.newGame("{\"name\": \"name\"}");
  }
}
