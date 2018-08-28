import ir.hajk1.exception.InvalidFormatException;
import ir.hajk1.facade.CSVTransformer;
import ir.hajk1.facade.InputTransformer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 * <p>
 * Description: <This class is used for Testing input file>
 */
public class InputFileTest {
    @Test
    public void testInputFile() throws IOException, InvalidFormatException {
        InputTransformer inputParser = new CSVTransformer();
        assert inputParser
                .unmarshal(new BufferedReader(new FileReader("src/test/resources/results.csv"))).size()
                == 7;
    }

    @Test
    @DisplayName("Test assert exception")
    public void testBadFormatInputFile() throws IOException, InvalidFormatException {
        assertThrows(InvalidFormatException.class,
                () -> {
                    InputTransformer inputParser = new CSVTransformer();
                    inputParser
                            .unmarshal(new BufferedReader(new FileReader("src/test/resources/results-badFormat.csv")));
                });
    }
}
