package ir.hajk1.facade;

import ir.hajk1.model.AthleteListResult;

import javax.xml.bind.JAXBException;
import java.io.PrintStream;

/**
 * Created by k1 on 8/27/18.
 * email:<k1.tehrani@gmail.com>
 */
public interface OutputTransformer {
    void marshal(AthleteListResult athleteList, PrintStream out) throws JAXBException;
}
