import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe(X,O)");

        frame.setSize(300, 400);
        frame.setLayout(new GridLayout(3, 3));

        JButton[][] board = new JButton[3][3];
        String player1 = "X";
        String player2 = "O";
        final boolean[] xTurn = {true};

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = new JButton();
                frame.add(board[r][c]);

                board[r][c].addActionListener(e -> {
                    JButton clickedButton = (JButton) e.getSource();
                    if (clickedButton.getText().isEmpty()) {
                        if (xTurn[0]) {
                            clickedButton.setText(player1);
                        } else {
                            clickedButton.setText(player2);
                        }
                        xTurn[0] = !xTurn[0];
                    }
                });
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static boolean checkWinner(JButton[][] board) {
        if (board == null || board.length != 3) {
            return false;
        }

        for (int r = 0; r < 3; r++) {
            if (board[r] == null || board[r].length != 3) {
                return false;
            }

            String firstCell = getCellValue(board[r][0]);
            if (!firstCell.isEmpty() && firstCell.equals(getCellValue(board[r][1])) &&
                    getCellValue(board[r][1]).equals(getCellValue(board[r][2]))) {
                return true;
            }
        }

        for (int c = 0; c < 3; c++) {
            String firstCell = getCellValue(board[0][c]);
            if (!firstCell.isEmpty() && firstCell.equals(getCellValue(board[1][c])) &&
                    getCellValue(board[1][c]).equals(getCellValue(board[2][c]))) {
                return true;
            }
        }

        String center = getCellValue(board[1][1]);
        if (!center.isEmpty() &&
                center.equals(getCellValue(board[0][0])) &&
                center.equals(getCellValue(board[2][2]))) {
            return true;
        }

        String oppositeCenter = getCellValue(board[1][1]);
        if (!oppositeCenter.isEmpty() &&
                oppositeCenter.equals(getCellValue(board[0][2])) &&
                oppositeCenter.equals(getCellValue(board[2][0]))) {
            return true;
        }

        return false;
    }

    private static String getCellValue(JButton button) {
        if (button == null || button.getText() == null) {
            return "";
        }

        return button.getText();
    }
}



