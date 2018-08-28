package ir.hajk1.service;

import ir.hajk1.exception.InitializationException;
import ir.hajk1.model.Athlete;
import ir.hajk1.model.AthleteListResult;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <This class is used to register the athletes and calculate the ranking places>
 */
public class AthleteRepositoryImpl implements AthlteRepository {

  private AthleteListResult athleteListResult;

  /**
   * Used to register the athletes list which is imported initially
   */
  public void register(List<Athlete> athleteList) {
    athleteListResult = new AthleteListResult(athleteList);
  }

  /**
   * This method is used to calculate places based on total score of each athlete
   * It is mandatory to register the athletes before calling this method
   */
  @Override
  public void calculateRanking() throws InitializationException {
    if (athleteListResult == null) {
      throw new InitializationException("athleteListResult is empty. try to register it first");
    }
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

  /**
   * This method calculates exact string literal for placements based on the ranking of each athlete,
   * it takes care of the shared places as well
   */
  private String calculateSharedPlace(List<Integer> rankList, Integer totalScore) {
    int firstIndex = rankList.indexOf(totalScore), lastIndex = rankList.lastIndexOf(totalScore);
    if (firstIndex == lastIndex) {
      return String.valueOf(firstIndex + 1);
    } else {
      return (firstIndex + 1) + "-" + (lastIndex + 1);
    }
  }
}
