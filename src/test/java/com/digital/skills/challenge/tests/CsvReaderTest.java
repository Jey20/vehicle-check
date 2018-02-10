package com.digital.skills.challenge.tests;

import com.digital.skills.challenge.domain.VehicleDetails;
import com.digital.skills.challenge.reader.CsvReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CsvReaderTest {

    private CsvReader csvReader;

    @Test
    public void shouldReturnVehicleDetailsTest(){
        csvReader = new CsvReader();
        List<VehicleDetails> vehicleDetailsList = csvReader.readCSVForVehicleRegistrationNumber();
        Assert.assertFalse(vehicleDetailsList.isEmpty());
    }

}
