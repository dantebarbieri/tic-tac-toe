public class Player {
  private String name;
  private char symbol;
  private Statistics stats;

  public Player(String n) {
    name = n;
    symbol = n.length() > 0 ? n.charAt(0) : null;
    stats = new Statistics();
  }

  public Player(String n, char s) {
    name = n;
    symbol = s == ' ' ? n.length() > 0 ? n.charAt(0) : null : s;
    stats = new Statistics();
  }

  private Player(String n, char s, Statistics st) {
    name = n;
    symbol = s;
    stats = st.clone();
  }

  @Override
  public Player clone() {
    return new Player(name, symbol, stats);
  }

  @Override
  public String toString() {
    return "Name: " + name + "\nSymbol: " + symbol + "\n" + stats;
  }
}
