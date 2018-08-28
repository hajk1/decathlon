package ir.hajk1.model;

import java.util.Arrays;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <Entity class for Athlete object>
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

    /**
     * This constructor is used to create an athlete using basic values
     */
    public Athlete(String name, Result[] result) {
        this.name = name;
        this.results = result;
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
