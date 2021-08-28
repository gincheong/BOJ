package BOJ2605;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("./src/BOJ2605/input.txt"));
    BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    ArrayList<Integer> list = new ArrayList<>();

    int studentCount = Integer.parseInt(bReader.readLine());
    String[] input = bReader.readLine().split(" ");

    for (int i = 0; i < studentCount; i++) {
      int index = Integer.parseInt(input[i]);
      list.add(index, i + 1);
    }

    for (int i = list.size() - 1; i >= 0; i--) {
      bWriter.write(list.get(i) + " ");
    }
    
    bWriter.flush();
    bReader.close();
    bWriter.close();
  }
}
