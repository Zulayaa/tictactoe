package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class TicTacToeApplication extends Application {

    private boolean isXTurn = true;

    @Override
    public void start(Stage stage) {

        //Creating the necessary objects
        Label turn = new Label("Turn: X");
        turn.setMinSize(100, 100);
        turn.setFont(Font.font(50));

        Button restart = new Button("Restart");
        restart.setMinSize(320, 100);
        BorderPane.setMargin(restart, new Insets(5));

        Button[][] buttons = new Button[3][3];
        BorderPane ui = new BorderPane();
        GridPane buttonLayout = new GridPane();

        //Creating the play area buttons
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                Button button = new Button();
                button.setPrefSize(100, 100);
                button.setPadding(new Insets(5));
                GridPane.setMargin(button, new Insets(5));

                //Adding the buttons to a two dimensional array and the GridPane
                buttons[row][column] = button;
                buttonLayout.add(button, column, row);

                //Functionality of the buttons
                button.setOnAction((event) -> {
                    if (button.getText().isEmpty()) {
                        if (this.isXTurn) {
                            button.setText("X");
                            button.setFont(Font.font(40));
                            if (xWin(buttons)) {
                                ui.setTop(restart);
                            }
                            turn.setText("Turn: O");
                            this.isXTurn = false;
                        } else {
                            button.setText("O");
                            button.setFont(Font.font(40));
                            if (oWin(buttons)) {
                                ui.setTop(restart);
                            }
                            turn.setText("Turn: X");
                            this.isXTurn = true;
                        }
                    }
                });

                //Functionality of the RESTART button
                restart.setOnAction((event) -> {
                    ui.setTop(turn);
                    for (int resetRow = 0; resetRow < 3; resetRow++) {
                        for (int resetColumn = 0; resetColumn < 3; resetColumn++) {
                            Button btn = buttons[resetRow][resetColumn];
                            btn.setText("");
                            btn.setDisable(false);
                        }
                    }
                    isXTurn = true;
                    turn.setText("Turn: X");
                });
            }
        }

        //Creating the size, name and layout of the window
        ui.setTop(turn);
        ui.setCenter(buttonLayout);
        Scene layout = new Scene(ui);
        stage.setTitle("Tic-Tac-Toe");
        stage.setMinHeight(400);
        stage.setMinWidth(300);
        stage.setMaxHeight(400);
        stage.setMaxWidth(300);
        stage.setScene(layout);
        stage.show();
    }

    private boolean xWin(Button[][] buttons) {
        //Column checks
        if (buttons[0][0].getText().equals("X")
                && buttons[1][0].getText().equals("X")
                && buttons[2][0].getText().equals("X")) {
            disableAllButton(buttons);
            return true;
        }
        if (buttons[0][1].getText().equals("X")
                && buttons[1][1].getText().equals("X")
                && buttons[2][1].getText().equals("X")) {
            disableAllButton(buttons);
            return true;
        }
        if (buttons[0][2].getText().equals("X")
                && buttons[1][2].getText().equals("X")
                && buttons[2][2].getText().equals("X")) {
            disableAllButton(buttons);
            return true;
        }

        //Row checks
        if (buttons[0][0].getText().equals("X")
                && buttons[0][1].getText().equals("X")
                && buttons[0][2].getText().equals("X")) {
            disableAllButton(buttons);
            return true;
        }
        if (buttons[1][0].getText().equals("X")
                && buttons[1][1].getText().equals("X")
                && buttons[1][2].getText().equals("X")) {
            disableAllButton(buttons);
            return true;
        }
        if (buttons[2][0].getText().equals("X")
                && buttons[2][1].getText().equals("X")
                && buttons[2][2].getText().equals("X")) {
            disableAllButton(buttons);
            return true;
        }

        //Diagonal checks
        if (buttons[0][0].getText().equals("X")
                && buttons[1][1].getText().equals("X")
                && buttons[2][2].getText().equals("X")) {
            disableAllButton(buttons);
            return true;
        }
        if (buttons[0][2].getText().equals("X")
                && buttons[1][1].getText().equals("X")
                && buttons[2][0].getText().equals("X")) {
            disableAllButton(buttons);
            return true;
        }
        return false;
    }

    private boolean oWin(Button[][] buttons) {
        //Column checks
        if (buttons[0][0].getText().equals("O")
                && buttons[1][0].getText().equals("O")
                && buttons[2][0].getText().equals("O")) {
            disableAllButton(buttons);
            return true;
        }
        if (buttons[0][1].getText().equals("O")
                && buttons[1][1].getText().equals("O")
                && buttons[2][1].getText().equals("O")) {
            disableAllButton(buttons);
            return true;
        }
        if (buttons[0][2].getText().equals("O")
                && buttons[1][2].getText().equals("O")
                && buttons[2][2].getText().equals("O")) {
            disableAllButton(buttons);
            return true;
        }

        //Row checks
        if (buttons[0][0].getText().equals("O")
                && buttons[0][1].getText().equals("O")
                && buttons[0][2].getText().equals("O")) {
            disableAllButton(buttons);
            return true;
        }
        if (buttons[1][0].getText().equals("O")
                && buttons[1][1].getText().equals("O")
                && buttons[1][2].getText().equals("O")) {
            disableAllButton(buttons);
            return true;
        }
        if (buttons[2][0].getText().equals("O")
                && buttons[2][1].getText().equals("O")
                && buttons[2][2].getText().equals("O")) {
            disableAllButton(buttons);
            return true;
        }

        //Diagonal checks
        if (buttons[0][0].getText().equals("O")
                && buttons[1][1].getText().equals("O")
                && buttons[2][2].getText().equals("O")) {
            disableAllButton(buttons);
            return true;
        }
        if (buttons[0][2].getText().equals("O")
                && buttons[1][1].getText().equals("O")
                && buttons[2][0].getText().equals("O")) {
            disableAllButton(buttons);
            return true;
        }
        return false;
    }

    private void disableAllButton(Button[][] buttons) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                buttons[row][column].setDisable(true);
            }
        }
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class
        );
    }

}
