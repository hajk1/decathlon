import ir.hajk1.exception.InitializationException;
import ir.hajk1.model.Athlete;
import ir.hajk1.model.AthleteListResult;
import ir.hajk1.model.Result;
import ir.hajk1.service.AthleteManagerImpl;
import ir.hajk1.service.AthlteManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ir.hajk1.model.Event.*;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 * <p>
 * Description: <This class is used for Testing Ranking calculation>
 */
public class AthleteRanking {
    Result[] resultsShared = new Result[]{
            new Result(TRACK_100M, 12.61),
            new Result(FIELD_HIGH_JUMP, 5.0),
            new Result(FIELD_SHOT_PUT, 9.22),
            new Result(FIELD_HIGH_JUMP, 1.5),
            new Result(TRACK_400_M, 60.39),
            new Result(TRACK_110_M_HURDLES, 16.43),
            new Result(FIELD_DISCUS_THROW, 21.6),
            new Result(FIELD_POLE_VAULT, 2.6),
            new Result(FIELD_JAVELIN_THROW, 35.81),
            new Result(TRACK_1500_M, 325.72)
    }, result1st = new Result[]{
            new Result(TRACK_100M, 10.395),
            new Result(FIELD_HIGH_JUMP, 7.76),
            new Result(FIELD_SHOT_PUT, 18.4),
            new Result(FIELD_HIGH_JUMP, 2.2),
            new Result(TRACK_400_M, 46.17),
            new Result(TRACK_110_M_HURDLES, 13.8),
            new Result(FIELD_DISCUS_THROW, 56.17),
            new Result(FIELD_POLE_VAULT, 5.28),
            new Result(FIELD_JAVELIN_THROW, 77.19),
            new Result(TRACK_1500_M, 233.79)
    };

    @Test
    public void testRanking() throws InitializationException {
        AthlteManager athlteManager = new AthleteManagerImpl();
        List<Athlete> athleteList = new ArrayList<>();
        athleteList.add(new Athlete("John Smith", resultsShared));
        athleteList.add(new Athlete("John Smith1", resultsShared));
        athleteList.add(new Athlete("Me Khodam", result1st));
        athlteManager.register(athleteList);
        athlteManager.calculateRanking();
        AthleteListResult athleteListResult = athlteManager.getAthleteResult();
        athleteList = athleteListResult.getAthleteList();
        assert athleteList.size() == 3;
        Athlete athletes0 = athleteList.get(0), athlete1 = athleteList.get(1), athlete2 = athleteList.get(2);
        assert athlete1.getPlace().equals(athlete2.getPlace());
        assert athlete1.getPlace().equals("2-3");
        assert athletes0.getPlace().equals("1");
    }
}
