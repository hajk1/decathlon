package ir.hajk1.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by k1 on 8/27/18.
 * email:<k1.tehrani@gmail.com>
 */
public class CSVParser implements InputParsable {
    public String[] parse(BufferedReader buf) throws IOException {
        List<String> strings = new ArrayList<String>();
        String line;
        while ((line = buf.readLine()) != null) {
            strings.add(line);
        }
        return strings.toArray(new String[0]);
    }

}
