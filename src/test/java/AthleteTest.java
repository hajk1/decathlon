import ir.hajk1.exception.InvalidFormatException;
import ir.hajk1.facade.CSVTransformer;
import ir.hajk1.facade.InputTransformer;
import ir.hajk1.facade.OutputTransformer;
import ir.hajk1.facade.XmlTransformer;
import ir.hajk1.model.Athlete;
import ir.hajk1.model.AthleteListResult;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import static org.mockito.Mockito.mock;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 * <p>
 * Description: <This class is used for Testing Athlete Object and xml creation>
 */
public class AthleteTest {
    @Mock
    private PrintStream out = mock(PrintStream.class);

    @Test
    public void testAthleteBuilder() throws IOException, InvalidFormatException {
        InputTransformer inputTransformer = new CSVTransformer();
        Athlete athlete = inputTransformer.parseRow(
                "John Smith;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72");
        assert athlete.getTotalScore().equals(4200);
    }

    @Test
    public void testAthleteXmlBuilder() throws IOException, JAXBException, InvalidFormatException {
        InputTransformer inputTransformer = new CSVTransformer();
        Athlete athlete = inputTransformer.parseRow(
                "John Smith;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72");
        OutputTransformer outputTransformer = new XmlTransformer();
        outputTransformer
                .marshal(new AthleteListResult(Arrays.asList(new Athlete[]{athlete})), out);
    }
}
