package ir.hajk1.model;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <This class is used for holding each result's information>
 */
public class Result {
    private Event event;
    private Double score;
    private int point;

    public Result(Event event, Double score) {
        this.event = event;
        this.score = score;
        setPoint(event.calculatePoint(event.getUnit().equals(Unit.CENTIMETER) ? score * 100 : score));
        System.out.println("getEvent() = " + getEvent() + ",getPoints() = " + getPoints());
    }

    public int getPoints() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
