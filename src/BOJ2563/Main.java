package BOJ2563;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("./src/BOJ2563/input.txt"));
    BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    
    final int DRAWING_PAPER_SIZE = 100;
    
    int[][] drawingPaper = new int[DRAWING_PAPER_SIZE][DRAWING_PAPER_SIZE];
    int paperCount = Integer.parseInt(bReader.readLine());
    
    int area = 0;

    for (int i = 0; i < paperCount; i++) {
      String[] input = bReader.readLine().split(" ");

      int row = Integer.parseInt(input[0]);
      int col = Integer.parseInt(input[1]);

      area += putPaper(drawingPaper, row, col);
    }

    bWriter.write(area + "");
    
    bWriter.flush();
    bReader.close();
    bWriter.close();
  }
  
  private static int putPaper(int[][] drawingPaper, int row, int col) {
    final int PAPER_SIZE = 10;

    int count = 0;
    for (int i = 0; i < PAPER_SIZE; i++) {
      for (int j = 0; j < PAPER_SIZE; j++) {
        if (drawingPaper[row + i][col + j] == 1) {
          continue;
        }
        drawingPaper[row + i][col + j] = 1; // 색종이 표시
        count++;
      }
    }

    return count;
  }
}
