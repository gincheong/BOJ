package BOJ2309;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  
  static final int DWARF_COUNT = 9; // 난쟁이는 총 9명 고정
  static int[] result = new int[DWARF_COUNT - 2]; // 일곱 명을 골라야 함
  
  static int[] dwarfs;
  static boolean flag = false;

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("./src/BOJ2309/input.txt"));
    BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    dwarfs = new int[DWARF_COUNT];
    
    for (int i = 0; i < DWARF_COUNT; i++) {
      dwarfs[i] = Integer.parseInt(bReader.readLine());
    }

    makeCombination(0, 0, 0);

    Arrays.sort(result);

    for (int each : result) {
      bWriter.write(each + "\n");
    }

    bWriter.flush();
    bReader.close();
    bWriter.close();
  }

  private static void makeCombination(int count, int start, int weight) {
    // 100이 넘으면 답이 될 수 없음
    if (weight > 100) {
      return;
    }
    
    // 일곱 명을 다 고른 경우
    if (count == DWARF_COUNT - 2) {
      if (weight == 100) {
        flag = true;
      }
      return;
    }
    
    for (int i = start; i < dwarfs.length; i++) {
      // 정답을 발견했으면 더 이상 반복하지 않음
      if (flag) { return; }

      result[count] = dwarfs[i];
      
      makeCombination(count + 1, i + 1, weight + dwarfs[i]);
    }
    
  }
}