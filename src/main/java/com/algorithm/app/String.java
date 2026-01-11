package com.algorithm.app;

public class String {

    // LC 168
    public String convertToTitle(int columnNumber) {
        StringBuilder colTitle = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            colTitle.append((char)( 'A' + ((columnNumber) % 26)));
            columnNumber /= 26;
        }
        return colTitle.reverse().toString();
    }
    
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
