package ir.hajk1.facade;

import ir.hajk1.model.AthleteListResult;
import java.io.PrintStream;
import javax.xml.bind.JAXBException;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <This interface is used to dictate the structure of output transformation>
 */
public interface OutputTransformer {
    void marshal(AthleteListResult athleteList, PrintStream out) throws JAXBException;
}
