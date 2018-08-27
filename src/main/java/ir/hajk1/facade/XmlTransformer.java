package ir.hajk1.facade;

import ir.hajk1.model.AthleteListResult;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.PrintStream;

/**
 * Created by k1 on 8/27/18.
 * email:<k1.tehrani@gmail.com>
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
