import ir.hajk1.facade.CSVTransformer;
import ir.hajk1.facade.InputTransformer;
import ir.hajk1.facade.OutputTransformer;
import ir.hajk1.facade.XmlTransformer;
import ir.hajk1.model.Athlete;
import ir.hajk1.model.AthleteListResult;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import javax.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;

/**
 * Created by k1 on 8/26/18.
 * email:<k1.tehrani@gmail.com>
 */
public class InputFileTest {
    @Test
    public void testInputFile() throws IOException {
        InputTransformer inputParser = new CSVTransformer();
      assert inputParser
          .parse(new BufferedReader(new FileReader("src/test/resources/results.csv"))).length == 7;
    }

    @Test
    public void testAthleteBuilder() throws IOException {
        Athlete athlete = new Athlete("John Smith;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72");
        assert true;
    }

    @Test
    public void testAthleteXmlBuilder() throws IOException, JAXBException {
        Athlete athlete = new Athlete("John Smith;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72");
        OutputTransformer outputTransformer = new XmlTransformer();
        outputTransformer.marshal(new AthleteListResult(Arrays.asList(new Athlete[]{athlete})), System.out);
    }
}
