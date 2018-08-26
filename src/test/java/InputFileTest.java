import ir.hajk1.model.Athlete;
import ir.hajk1.service.CSVParser;
import ir.hajk1.service.InputParsable;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by k1 on 8/26/18.
 * email:<k1.tehrani@gmail.com>
 */
public class InputFileTest {
    @Test
    public void testInputFile() throws IOException {
        InputParsable application = new CSVParser();
        assert application.parse(new BufferedReader(new FileReader("src/test/resources/results.csv"))).length == 4;
    }

    @Test
    public void testAthleteBuilder() throws IOException {
        Athlete athlete = new Athlete("John Smith;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72");
        assert true;
    }
}
