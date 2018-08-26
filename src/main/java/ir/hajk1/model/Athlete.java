package ir.hajk1.model;

import javax.xml.bind.annotation.*;

/**
 * Created by k1 on 8/27/18.
 * email:<k1.tehrani@gmail.com>
 */
@XmlRootElement(name = "athlete")
@XmlAccessorType(XmlAccessType.FIELD)
public class Athlete implements Comparable<Athlete> {
    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "totalScore")
    private Double totalScore;
    @XmlElement(name = "place")
    private String place;
    @XmlElement(name = "results")
    private Result[] results = new Result[10];

    public Athlete() {
    }

    public Athlete(String string) {
        String[] splitted = string.split(";");
        name = splitted[0];
        for (int i = 1; i < splitted.length - 1; i++) {
            results[i - 1] = new Result();
            results[i - 1].setScore(Double.parseDouble(splitted[i]));
            results[i - 1].setEvent(Event.values()[i - 1]);
        }
        String[] times = splitted[splitted.length - 1].split("\\.");
        int minutes = Integer.parseInt(times[0]);
        int seconds = (minutes * 60) + Short.parseShort(times[1]);
        results[9] = new Result();
        results[9].setEvent(Event.values()[9]);
        results[9].setScore(Double.parseDouble(seconds + "." + times[2]));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Result[] getResults() {
        return results;
    }

    public void setResults(Result[] results) {
        this.results = results;
    }

    @Override
    public int compareTo(Athlete athlete) {
        return this.totalScore.compareTo(athlete.totalScore);
    }
}
