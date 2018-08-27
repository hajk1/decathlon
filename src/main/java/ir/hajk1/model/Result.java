package ir.hajk1.model;

/**
 * Created by k1 on 8/27/18.
 * email:<k1.tehrani@gmail.com>
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
