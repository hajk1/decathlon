package ir.hajk1.facade;

import ir.hajk1.exception.InvalidFormatException;
import ir.hajk1.model.Athlete;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <This interface is used to dictate the structure of input transformation>
 */
public interface InputTransformer {

    List<Athlete> unmarshal(BufferedReader buf) throws IOException, InvalidFormatException;

    Athlete parseRow(String row) throws InvalidFormatException;
}
