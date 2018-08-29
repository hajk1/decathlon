import static org.mockito.Mockito.mock;

import ir.hajk1.exception.InitializationException;
import ir.hajk1.exception.InvalidFormatException;
import ir.hajk1.facade.CSVTransformer;
import ir.hajk1.facade.InputTransformer;
import ir.hajk1.facade.OutputTransformer;
import ir.hajk1.facade.XmlTransformer;
import ir.hajk1.model.Athlete;
import ir.hajk1.model.AthleteListResult;
import ir.hajk1.model.Result;
import ir.hajk1.service.AthleteManager;
import ir.hajk1.service.AthleteManagerImpl;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 * <p>
 * Description: <This class is used for Testing Athlete Object and xml creation>
 */
public class AthleteTest {

  final String name = "John Smith";
  final String result0 = "12.61";
  final String result1 = "5.00";
  final String result2 = "9.22";
  final String result3 = "1.50";
  final String result4 = "60.39";
  final String result5 = "16.43";
  final String result6 = "21.60";
  final String result7 = "2.60";
  final String result8 = "35.81";
  final String result9 = "5.25.72";
  @Mock
  private PrintStream out = mock(PrintStream.class);

  @Test
  public void testAthleteBuilder() throws InvalidFormatException {
    InputTransformer inputTransformer = new CSVTransformer();
    Athlete athlete = inputTransformer.parseRow(
        "John Smith;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72");
    assert athlete.getTotalScore().equals(4200);
  }

  @Test
  public void testAthleteXmlBuilder() throws JAXBException, InvalidFormatException {
    InputTransformer inputTransformer = new CSVTransformer();
    Athlete athlete = inputTransformer.parseRow(
        "John Smith;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72");
    OutputTransformer outputTransformer = new XmlTransformer();
    outputTransformer
        .marshal(new AthleteListResult(Collections.singletonList(athlete)), out);
  }

  @Test
  public void testAthleteResult()
      throws InvalidFormatException, InitializationException {
    InputTransformer inputTransformer = new CSVTransformer();
    String rowBuilder = name + ';' + result0 + ';'
        + result1 + ';' + result2 + ';' + result3 + ';'
        + result4 + ';' + result5 + ';' + result6 + ';'
        + result7 + ';' + result8 + ';' + result9;
    Athlete athlete = inputTransformer.parseRow(rowBuilder);
    AthleteManager athleteManager = new AthleteManagerImpl();
    athleteManager.register(Collections.singletonList(athlete));
    athleteManager.calculateRanking();
    AthleteListResult athleteListResult = athleteManager.getAthleteResult();
    List<Athlete> athleteList = athleteListResult.getAthleteList();
    assert athleteList.size() == 1;
    athlete = athleteList.get(0);
    assert athlete.getName().equals(name);
    assert athlete.getTotalScore().equals(4200);
    assert athlete.getPlace().equals("1");
    Result[] results = athlete.getResults();
    assert results.length == 10;
    assert results[0].getInitialScoreString().equals(result0);
    assert results[1].getInitialScoreString().equals(result1);
    assert results[2].getInitialScoreString().equals(result2);
    assert results[3].getInitialScoreString().equals(result3);
    assert results[4].getInitialScoreString().equals(result4);
    assert results[5].getInitialScoreString().equals(result5);
    assert results[6].getInitialScoreString().equals(result6);
    assert results[7].getInitialScoreString().equals(result7);
    assert results[8].getInitialScoreString().equals(result8);
    assert results[9].getInitialScoreString().equals(result9);
  }
}
