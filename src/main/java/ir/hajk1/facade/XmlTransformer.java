package ir.hajk1.facade;

import ir.hajk1.model.AthleteListResult;
import java.io.PrintStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <This class is used to marshal xml to the output stream>
 */
public class XmlTransformer implements OutputTransformer {
    @Override
    public void marshal(AthleteListResult athleteList, PrintStream out) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(AthleteListResult.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(athleteList, out);
    }
}
