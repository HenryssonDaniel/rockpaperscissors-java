package io.github.henryssondaniel.rockpaperscissors.v1._0;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class GameImplTest {
  private static final String NAME = "name";
  private static final String NAME_2 = "name2";
  private static final String OK = "OK";
  private static final String PAPER = "paper";
  private static final String ROCK = "rock";
  private static final String SCISSORS = "scissors";

  private final Game game = new GameImpl(NAME);

  @Test
  void getStateWhenPaper() {
    game.join(NAME_2);
    game.move(PAPER, NAME);
    game.move(ROCK, NAME_2);
    assertThat(game.getState()).isEqualTo("name: PAPER. name2: ROCK. The winner is: name");
  }

  @Test
  void getStateWhenPlayer2Paper() {
    game.join(NAME_2);
    game.move(ROCK, NAME);
    game.move(PAPER, NAME_2);
    assertThat(game.getState()).isEqualTo("name: ROCK. name2: PAPER. The winner is: name2");
  }

  @Test
  void getStateWhenPlayer2Rock() {
    game.join(NAME_2);
    game.move(SCISSORS, NAME);
    game.move(ROCK, NAME_2);
    assertThat(game.getState()).isEqualTo("name: SCISSORS. name2: ROCK. The winner is: name2");
  }

  @Test
  void getStateWhenPlayer2Scissors() {
    game.join(NAME_2);
    game.move(PAPER, NAME);
    game.move(SCISSORS, NAME_2);
    assertThat(game.getState()).isEqualTo("name: PAPER. name2: SCISSORS. The winner is: name2");
  }

  @Test
  void getStateWhenRock() {
    game.join(NAME_2);
    game.move(ROCK, NAME);
    game.move(SCISSORS, NAME_2);
    assertThat(game.getState()).isEqualTo("name: ROCK. name2: SCISSORS. The winner is: name");
  }

  @Test
  void getStateWhenScissors() {
    game.join(NAME_2);
    game.move(SCISSORS, NAME);
    game.move(PAPER, NAME_2);
    assertThat(game.getState()).isEqualTo("name: SCISSORS. name2: PAPER. The winner is: name");
  }

  @Test
  void getStateWhenTie() {
    game.join(NAME_2);
    game.move(SCISSORS, NAME);
    game.move(SCISSORS, NAME_2);
    assertThat(game.getState()).isEqualTo("name: SCISSORS. name2: SCISSORS. It's a tie!");
  }

  @Test
  void getStateWhenWaitingBoth() {
    game.join(NAME_2);
    assertThat(game.getState()).isEqualTo("None of the player has done a move yet.");
  }

  @Test
  void getStateWhenWaitingPlayer1() {
    game.join(NAME_2);
    game.move(PAPER, NAME_2);
    assertThat(game.getState()).isEqualTo("Waiting for name to make a move.");
  }

  @Test
  void getStateWhenWaitingPlayer2() {
    game.join(NAME_2);
    game.move(PAPER, NAME);
    assertThat(game.getState()).isEqualTo("Waiting for name2 to make a move.");
  }

  @Test
  void getStateWhenWaitingToJoin() {
    assertThat(game.getState()).isEqualTo("Waiting for the second player to join the game.");
  }

  @Test
  void getUuid() {
    assertThat(game.getUuid()).isNotEqualTo(UUID.randomUUID());
  }

  @Test
  void join() {
    assertThat(game.join(NAME_2)).isEqualTo(OK);
  }

  @Test
  void joinWhenNameIsAlreadyTaken() {
    assertThat(game.join(NAME))
        .isEqualTo(
            "The name is already taken. Please choose another name and join the game again.");
  }

  @Test
  void move() {
    assertThat(game.move(PAPER, NAME)).isEqualTo(OK);
  }

  @Test
  void moveWhenHandDoesNotExist() {
    assertThat(game.move("dagger", NAME)).isEqualTo("The move is not valid.");
  }

  @Test
  void moveWhenHandNameNotExist() {
    assertThat(game.move(PAPER, NAME_2)).isEqualTo("The name does not exist in this game.");
  }

  @Test
  void moveWhenMoveAlreadyMade() {
    game.move(PAPER, NAME);
    assertThat(game.move(ROCK, NAME)).isEqualTo("A move is already done for this player.");
  }
}
