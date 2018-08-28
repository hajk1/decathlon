package ir.hajk1.facade;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by k1 on 8/27/18.
 * email:<k1.tehrani@gmail.com>
 */
public interface InputTransformer {
    String[] parse(BufferedReader buf) throws IOException;
}
