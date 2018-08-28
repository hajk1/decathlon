package ir.hajk1.service;

import ir.hajk1.model.Athlete;
import ir.hajk1.model.AthleteListResult;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
public class AthleteRepositoryImpl implements AthlteRepository {

  private AthleteListResult athleteListResult;

  public void register(List<Athlete> athleteList) {
    athleteListResult = new AthleteListResult(athleteList);
  }

  @Override
  public void calculateRanking() {
    List<Athlete> athleteList = athleteListResult.getAthleteList();
    Collections.sort(athleteList);
    List<Integer> rankList = athleteList.stream().map(Athlete::getTotalScore).collect(Collectors
        .toList());
    athleteList.forEach(a -> a.setPlace(calculateSharedPlace(rankList, a.getTotalScore())));
  }

  @Override
  public AthleteListResult getAthleteResult() {
    return athleteListResult;
  }

  private String calculateSharedPlace(List<Integer> rankList, Integer totalScore) {
    int firstIndex = rankList.indexOf(totalScore), lastIndex = rankList.lastIndexOf(totalScore);
    if (firstIndex == lastIndex) {
      return String.valueOf(firstIndex + 1);
    } else {
      return (firstIndex + 1) + "-" + (lastIndex + 1);
    }
  }
}
