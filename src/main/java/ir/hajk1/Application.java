package ir.hajk1;

import ir.hajk1.exception.InitializationException;
import ir.hajk1.exception.InvalidFormatException;
import ir.hajk1.facade.CSVTransformer;
import ir.hajk1.facade.InputTransformer;
import ir.hajk1.facade.OutputTransformer;
import ir.hajk1.facade.XmlTransformer;
import ir.hajk1.service.AthleteManager;
import ir.hajk1.service.AthleteManagerImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import javax.xml.bind.JAXBException;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <This class is used for main start of the application>
 */

public class Application {

  private final InputTransformer inputTransformer;
  private final OutputTransformer outputTransformer;
  private final AthleteManager athlteRepository;

  private Application(InputTransformer inputParser, OutputTransformer outputTransformer,
      AthleteManager athlteRepository) {
    this.inputTransformer = inputParser;
    this.outputTransformer = outputTransformer;
    this.athlteRepository = athlteRepository;
  }

  /**
   * The main method accepts an input csv file and will produce a new xml file using input file name at same path
   */
  public static void main(String[] args)
      throws IOException, JAXBException, InitializationException, InvalidFormatException {
    Application application = new Application(new CSVTransformer(), new XmlTransformer(),
        new AthleteManagerImpl());
    if (args.length == 0) {
      System.out.println("Input file path is missing, plz provide path to an input csv file");
      System.exit(1);
    }
    String inputFilePath = args[0];
    application.getAthlteRepository().register(application.getInputTransformer()
        .unmarshal(new BufferedReader(new FileReader(inputFilePath))));
    application.getAthlteRepository().calculateRanking();
    File outPutFile = changeExtension(new File(inputFilePath), ".xml");
    PrintStream printWriter = new PrintStream(outPutFile);
    application.getOutputTransformer()
        .marshal(application.getAthlteRepository().getAthleteResult(), printWriter);
  }

  public static File changeExtension(File f, String newExtension) {
    int i = f.getName().lastIndexOf('.');
    String name = f.getName().substring(0, i);
    return new File(f.getParent() + "/" + name + newExtension);
  }

  public InputTransformer getInputTransformer() {
    return inputTransformer;
  }

  public OutputTransformer getOutputTransformer() {
    return outputTransformer;
  }

  public AthleteManager getAthlteRepository() {
    return athlteRepository;
  }

}
