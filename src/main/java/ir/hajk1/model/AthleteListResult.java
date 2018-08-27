package ir.hajk1.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by k1 on 8/27/18.
 * email:<k1.tehrani@gmail.com>
 */
@XmlRootElement(name = "athleteList")
public class AthleteListResult {
    @XmlElement(name = "athlete")
    List<Athlete> athleteList = new ArrayList<>();

    public AthleteListResult(List<Athlete> athleteList) {
        this.athleteList = athleteList;
    }

    public AthleteListResult() {
    }
}
