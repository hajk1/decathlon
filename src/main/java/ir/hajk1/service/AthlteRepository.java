package ir.hajk1.service;

import ir.hajk1.model.Athlete;
import ir.hajk1.model.AthleteListResult;
import java.util.List;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
public interface AthlteRepository {

  void register(List<Athlete> athleteList);

  void calculateRanking();

  AthleteListResult getAthleteResult();
}
