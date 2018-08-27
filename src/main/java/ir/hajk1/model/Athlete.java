package ir.hajk1.model;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

/**
 * Created by k1 on 8/27/18.
 * email:<k1.tehrani@gmail.com>
 */
@XmlRootElement(name = "athlete")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"name", "place", "totalScore", "results"})
public class Athlete implements Comparable<Athlete> {
    private String name;
    private Integer totalScore;
    private String place;
    private Result[] results = new Result[10];

    public Athlete() {
    }

    public Athlete(String row) {
        String[] rowSplitted = row.split(";");
        name = rowSplitted[0];
        for (int i = 1; i < rowSplitted.length - 1; i++) {
            results[i - 1] = new Result(Event.values()[i - 1], Double.parseDouble(rowSplitted[i]));
        }
        String[] times = rowSplitted[rowSplitted.length - 1].split("\\.");
        int minutes = Integer.parseInt(times[0]);
        int seconds = (minutes * 60) + Short.parseShort(times[1]);
        results[9] = new Result(Event.values()[9], Double.parseDouble(seconds + "." + times[2]));
    }

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "totalScore")
    public Integer getTotalScore() {
        return Arrays.stream(results).mapToInt(Result::getPoints).sum();
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    @XmlElement(name = "place")
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @XmlElement(name = "results")
    public Result[] getResults() {
        return results;
    }

    public void setResults(Result[] results) {
        this.results = results;
    }

    @Override
    public int compareTo(Athlete athlete) {
        return athlete.getTotalScore().compareTo(getTotalScore());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Athlete athlete = (Athlete) o;

        if (name != null ? !name.equals(athlete.name) : athlete.name != null) return false;
        return totalScore != null ? totalScore.equals(athlete.totalScore) : athlete.totalScore == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (totalScore != null ? totalScore.hashCode() : 0);
        return result;
    }
}
