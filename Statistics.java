public class Statistics {
  public int wins, losses, ties;

  public Statistics() {
    wins = 0;
    losses = 0;
    ties = 0;
  }

  private Statistics(int w, int l, int t) {
    wins = w;
    losses = l;
    ties = t;
  }

  @Override
  public Statistics clone() {
    return new Statistics(wins, losses, ties);
  }

  public int games() {
    return wins + losses + ties;
  }

  public float[] percentages() {
    if (games() == 0)
      return new float[] { 0f, 0f, 0f };
    float g = 100f / games();
    return new float[] { wins * g, losses * g, ties * g };
  }

  @Override
  public String toString() {
    return "Statistics:\n\tWins: " + wins + "\n\tLosses: " + losses + "\n\tTies:" + ties;
  }
}
