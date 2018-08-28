import ir.hajk1.facade.CSVTransformer;
import ir.hajk1.facade.InputTransformer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
          .unmarshal(new BufferedReader(new FileReader("src/test/resources/results.csv"))).size()
          == 7;
    }
}
