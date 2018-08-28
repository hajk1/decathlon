package ir.hajk1.facade;

import ir.hajk1.exception.InvalidFormatException;
import ir.hajk1.model.Athlete;
import ir.hajk1.model.Event;
import ir.hajk1.model.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <This class is used to transform CSV input file>
 */
public class CSVTransformer implements InputTransformer {

  public List<Athlete> unmarshal(BufferedReader buf) throws IOException, InvalidFormatException {
    List<String> athleteRows = new ArrayList<>();
    String line;
    while ((line = buf.readLine()) != null) {
      athleteRows.add(line);
    }
    List<Athlete> athleteList = new ArrayList<>(athleteRows.size());
    for (String row : athleteRows) {
      athleteList.add(parseRow(row));
    }
    return athleteList;
  }

  public Athlete parseRow(String row) throws InvalidFormatException {
    try {
      Result[] results = new Result[10];
      String[] rowSplitted = row.split(";");
      String name = rowSplitted[0];
      for (int i = 1; i < rowSplitted.length - 1; i++) {
        results[i - 1] = new Result(Event.values()[i - 1], Double.parseDouble(rowSplitted[i]));
      }
      String[] times = rowSplitted[rowSplitted.length - 1].split("\\.");
      int minutes = Integer.parseInt(times[0]);
      int seconds = (minutes * 60) + Short.parseShort(times[1]);
      results[9] = new Result(Event.values()[9], Double.parseDouble(seconds + "." + times[2]));
      return new Athlete(name, results);
    } catch (Exception e) {
      throw new InvalidFormatException(e.getMessage());
    }
  }

}
