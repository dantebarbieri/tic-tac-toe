public class Board {
  private char[][] grid;

  public Board() {
    grid = new char[3][3];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        grid[i][j] = ' ';
      }
    }
  } // End of void Constructor

  public Board(char[][] g) {
    grid = g.clone();
  } // End of char[][] Constructor

  @Override
  public Board clone() {
    return new Board(grid);
  } // End of clone Method

  @Override
  public String toString() {
    String s = "";
    final String VERTICAL_DIV = " | ";
    final String HORIZONTAL_DIV = "-";
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        s += grid[i][j];
        if (j + 1 < grid[i].length) // Handle the End of Line Vertical Bars
          s += VERTICAL_DIV;
      } // Iterate over the Columns of the Board
      if (i + 1 < grid.length) {
        s += "\n";
        for (int k = 0; k < VERTICAL_DIV.length() * (grid[i].length - 1) + grid[i].length; k += HORIZONTAL_DIV.length())
          s += HORIZONTAL_DIV;
        s += "\n";
      } // Handle the End of Row Horizontal Bars
    } // Iterate over the Rows of the Board
    return s;
  } // End of toString Method

  public boolean play(int l, char s) {
    int r = l / grid[0].length;
    int c = l % grid[0].length;
    if (grid[r][c] != ' ')
      return false;
    grid[r][c] = s;
    return true;
  }

  public int[] checkWin(char s) {
    int h = checkWinHorizontal(s), v = checkWinVertical(s),
        d = grid.length == grid[0].length ? checkWinDiagonal(s) : -1;
    return new int[] { h, v, d };
  }

  private int checkWinHorizontal(char s) {
    boolean h;
    for (int i = 0; i < grid.length; i++) {
      h = true;
      for (int j = 0; j < grid[i].length; j++) {
        h = grid[i][j] == s && h;
      }
      if (h)
        return i;
    }
    return -1;
  }

  private int checkWinVertical(char s) {
    boolean v;
    int cols = getMinCols();
    for (int i = 0; i < cols; i++) {
      v = true;
      for (int j = 0; j < grid.length; j++) {
        v = grid[j][i] == s && v;
      }
      if (v)
        return i;
    }
    return -1;
  }

  private int getMinCols() {
    int cols = Integer.MAX_VALUE;
    for (int i = 0; i < grid.length; i++) {
      if (grid[i].length < cols)
        cols = grid[i].length;
    }
    return cols;
  }

  /**
  1:         |  2:
  * |   |    |    |   | *
  ---------  |  ---------
    | * |    |    | * |
  ---------  |  ---------
    |   | *  |  * |   |
  */
  private int checkWinDiagonal(char s) {
    boolean d1 = true, d2 = true;
    for (int i = 0; i < grid.length; i++) {
      d1 = grid[i][i] == s && d1;
      d2 = grid[i][grid.length - 1 - i] == s && d2;
    }
    if (d1)
      return 1;
    if (d2)
      return 2;
    return -1;
  }

} // End of Board Class
