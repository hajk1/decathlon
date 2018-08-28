package ir.hajk1;

import ir.hajk1.facade.CSVTransformer;
import ir.hajk1.facade.InputTransformer;
import ir.hajk1.facade.OutputTransformer;
import ir.hajk1.facade.XmlTransformer;
import ir.hajk1.model.Athlete;
import ir.hajk1.model.AthleteListResult;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by k1 on 8/26/18.
 * email:<k1.tehrani@gmail.com>
 */

public class Application {

    private final InputTransformer inputTransformer;
    private final OutputTransformer outputTransformer;

    private Application(InputTransformer inputParser, OutputTransformer outputTransformer) {
        this.inputTransformer = inputParser;
        this.outputTransformer = outputTransformer;
    }

    public static void main(String[] args) throws IOException, JAXBException {
        Application application = new Application(new CSVTransformer(), new XmlTransformer());
        if (args.length == 0) {
            System.out.println("Input file path is missing");
            System.exit(1);
        }
        String inputFilePath = args[0];
        String[] athleteRows = application.inputTransformer.parse(new BufferedReader(new FileReader(inputFilePath)));
        List<Athlete> athleteList = new ArrayList<>(athleteRows.length);
        for (String row : athleteRows) {
            athleteList.add(new Athlete(row));
        }
        Collections.sort(athleteList);
        List<Integer> rankList = athleteList.stream().map(Athlete::getTotalScore).collect(Collectors.toList());
        athleteList.forEach(a -> a.setPlace(calculateSharedPlace(rankList, a.getTotalScore())));
        application.outputTransformer.marshal(new AthleteListResult(athleteList), System.out);
    }

    private static String calculateSharedPlace(List<Integer> rankList, Integer totalScore) {
        int firstIndex = rankList.indexOf(totalScore), lastIndex = rankList.lastIndexOf(totalScore);
        if (firstIndex == lastIndex)
            return String.valueOf(firstIndex + 1);
        else
            return (firstIndex + 1) + "-" + (lastIndex + 1);
    }
}
