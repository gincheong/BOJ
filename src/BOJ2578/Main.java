package BOJ2578;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("./src/BOJ2578/input.txt"));
    BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    final int BOARD_SIZE = 5;

    int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    for (int i = 0; i < BOARD_SIZE; i++) {
      String[] input = bReader.readLine().split(" ");

      for (int j = 0; j < BOARD_SIZE; j++) {
        board[i][j] = Integer.parseInt(input[j]);
      }
    }

    boolean exitFlag = false;
    for (int i = 0; i < BOARD_SIZE; i++) {
      String[] input = bReader.readLine().split(" ");

      if (exitFlag) {
        continue;
      }

      for (int j = 0; j < BOARD_SIZE; j++) {
        int targetNumber = Integer.parseInt(input[j]);

        // 보드에 0으로 표시
        eraseNumber(board, targetNumber);

        // 빙고 계산
        int bingoCount = getBingoCount(board);
        
        // 정답 발견  
        if (bingoCount >= 3) {
          bWriter.write((i * 5) + j + 1 + "");
          exitFlag = true;
          break;
        }
      }
    }

    bWriter.flush();
    bReader.close();
    bWriter.close();    
  }

  private static void eraseNumber(int[][] board, int targetNumber) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == targetNumber) {
          board[i][j] = 0;
          return;
        }
      }
    }
  }

  private static int getBingoCount(int[][] board) {
    int count = 0;
    
    // 가로 빙고 확인
    for (int i = 0; i < board.length; i++) {
      boolean isValid = true;
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] > 0) {
          isValid = false;
          break;
        }
      }

      if (isValid) { count++; }
    }

    // 세로 빙고 확인
    for (int i = 0; i < board.length; i++) {
      boolean isValid = true;
      for (int j = 0; j < board.length; j++) {
        if (board[j][i] > 0) {
          isValid = false;
          break;
        }
      }

      if (isValid) { count++; }
    }

    // 대각 빙고 확인 (좌->우)
    boolean isValid = true;
    for (int i = 0; i < board.length; i++) {
      if (board[i][i] > 0) {
        isValid = false;
        break;
      }
    }
    if (isValid) { count++; }

    // 대각 빙고 확인 (우->좌)
    isValid = true;
    for (int i = 0; i < board.length; i++) {
      if (board[i][board.length - 1 - i] > 0) {
        isValid = false;
        break;
      }
    }
    if (isValid) { count++; }

    return count;
  }

}