package ir.hajk1.facade;

import ir.hajk1.model.Athlete;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by k1 on 8/27/18.
 * email:<k1.tehrani@gmail.com>
 */
public interface InputTransformer {

    List<Athlete> unmarshal(BufferedReader buf) throws IOException;
}
