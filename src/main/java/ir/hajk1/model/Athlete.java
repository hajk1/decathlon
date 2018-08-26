package ir.hajk1.model;

/**
 * Created by k1 on 8/27/18.
 * email:<k1.tehrani@gmail.com>
 */
public class Athlete implements Comparable<Athlete> {
    private String name;
    private Double totalScore;
    private String place;
    private Result[] results = new Result[10];

    public Athlete(String string) {
        String[] splitted = string.split(";");
        name = splitted[0];
        // now fill in the other fields
        for (int i = 1; i < splitted.length - 1; i++) {
            results[i - 1].setScore(Double.parseDouble(splitted[i]));
            results[i - 1].setEvent(Event.values()[i - 1]);
        }
        String[] times = splitted[splitted.length - 1].split("\\.");
        int minutes = Integer.parseInt(times[0]);
        // etc. - fill in the rest
    }

    @Override
    public int compareTo(Athlete athlete) {
        return this.totalScore.compareTo(athlete.totalScore);
    }
}
