package com.digital.skills.challenge.reader;

import com.digital.skills.challenge.ScanDirectory;
import com.digital.skills.challenge.domain.VehicleDetails;
import com.digital.skills.challenge.util.PropertyHelper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CsvReader {

    public  List<VehicleDetails> readCSVForVehicleRegistrationNumber(){

        String filePath = PropertyHelper.getInstance().getProperty("folder.location");

        ScanDirectory scanDirectory = new ScanDirectory();

        List<File> fileForGivenFilePathAndExtension = scanDirectory.getFileForGivenFilePathAndExtension(filePath, ".csv");

        Optional<File> anyFile = fileForGivenFilePathAndExtension.stream().findAny();

        if(!anyFile.isPresent())
            throw new RuntimeException("No File present for the given format in specified location ");

        File file = anyFile.get();

        List<VehicleDetails> vehicleDetailsList = new ArrayList<>();

        try (
                Reader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim());
        ) {
            for (CSVRecord csvRecord : csvParser.getRecords()) {

                VehicleDetails vehicleDetails = new VehicleDetails();
                vehicleDetails.setRegistrationNumber(csvRecord.get("Registration Number"));
                vehicleDetails.setColour(csvRecord.get("Colour"));
                vehicleDetails.setMake(csvRecord.get("Make"));

                vehicleDetailsList.add(vehicleDetails);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vehicleDetailsList;
    }
}
