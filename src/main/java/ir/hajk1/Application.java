package ir.hajk1;

import ir.hajk1.facade.CSVTransformer;
import ir.hajk1.facade.InputTransformer;
import ir.hajk1.facade.OutputTransformer;
import ir.hajk1.facade.XmlTransformer;
import ir.hajk1.service.AthleteRepositoryImpl;
import ir.hajk1.service.AthlteRepository;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import javax.xml.bind.JAXBException;

/**
 * Created by k1 on 8/26/18.
 * email:<k1.tehrani@gmail.com>
 */

public class Application {

  private final InputTransformer inputTransformer;
  private final OutputTransformer outputTransformer;
  private final AthlteRepository athlteRepository;

  private Application(InputTransformer inputParser, OutputTransformer outputTransformer,
      AthlteRepository athlteRepository) {
    this.inputTransformer = inputParser;
    this.outputTransformer = outputTransformer;
    this.athlteRepository = athlteRepository;
  }

  public static void main(String[] args) throws IOException, JAXBException {
    Application application = new Application(new CSVTransformer(), new XmlTransformer(),
        new AthleteRepositoryImpl());
    if (args.length == 0) {
      System.out.println("Input file path is missing");
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

  public AthlteRepository getAthlteRepository() {
    return athlteRepository;
  }

}
