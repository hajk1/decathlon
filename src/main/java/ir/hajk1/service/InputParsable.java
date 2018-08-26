package ir.hajk1.service;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by k1 on 8/27/18.
 * email:<k1.tehrani@gmail.com>
 */
public interface InputParsable {
    String[] parse(BufferedReader buf) throws IOException;
}
