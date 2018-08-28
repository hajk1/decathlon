package ir.hajk1.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by k1 on 8/27/18.
 * email:<k1.tehrani@gmail.com>
 */
@XmlRootElement(name = "athleteList")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class AthleteListResult {
    List<Athlete> athleteList = new ArrayList<>();

    public AthleteListResult(List<Athlete> athleteList) {
        this.athleteList = athleteList;
    }

    public AthleteListResult() {
    }

    @XmlElement(name = "athlete")
    public List<Athlete> getAthleteList() {
        return athleteList;
    }

    public void setAthleteList(List<Athlete> athleteList) {
        this.athleteList = athleteList;
    }
}
