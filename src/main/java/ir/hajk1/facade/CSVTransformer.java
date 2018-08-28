package ir.hajk1.facade;

import ir.hajk1.model.Athlete;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by k1 on 8/27/18.
 * email:<k1.tehrani@gmail.com>
 */
public class CSVTransformer implements InputTransformer {

  public List<Athlete> unmarshal(BufferedReader buf) throws IOException {
    List<String> athleteRows = new ArrayList<String>();
        String line;
        while ((line = buf.readLine()) != null) {
          athleteRows.add(line);
        }
    List<Athlete> athleteList = new ArrayList<>(athleteRows.size());
    for (String row : athleteRows) {
      athleteList.add(new Athlete(row));
    }

    return athleteList;
    }

}
