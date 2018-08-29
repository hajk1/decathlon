package ir.hajk1.model;

import static ir.hajk1.model.Event.TRACK_1500_M;

import ir.hajk1.TimeUtils;
import java.text.DecimalFormat;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <This class is used for holding each result's information>
 */
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Result {

  private Event event;
  private Double score;
  private int point;
  private DecimalFormat decim = new DecimalFormat("0.00");

  public Result() {
  }

  public Result(Event event, Double score) {
    this.event = event;
    this.score = score;
    setPoint(event.calculatePoint(event.getUnit().equals(Unit.CENTIMETER) ? score * 100 : score));
//        System.out.println("getEvent() = " + getEvent() + ",getPoints() = " + getPoints());
  }

  public int getPoints() {
    return point;
  }

  public void setPoint(int point) {
    this.point = point;
  }

  @XmlElement(name = "event")
  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  @XmlTransient
  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }

  @XmlElement(name = "score")
  public String getInitialScoreString() {
    if (event.equals(TRACK_1500_M)) {
      return TimeUtils.convertSecondsToMinutes(getScore());
    } else {
      return decim.format(getScore());
    }
  }
}
