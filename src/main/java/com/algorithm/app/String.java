package com.algorithm.app;

public class String {

    // LC 657
    public boolean judgeCircle(String moves) {
      int x = 0, y = 0;
      for (char m : moves.toCharArray()) {
          if (m == 'L') x--;
          if (m == 'R') x++;
          if (m == 'U') y++;
          if (m == 'D') y--;
        }
        return x == 0 && y == 0;
    }
}
