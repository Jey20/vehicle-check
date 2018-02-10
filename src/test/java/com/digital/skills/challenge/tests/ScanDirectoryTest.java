package com.digital.skills.challenge.tests;

import com.digital.skills.challenge.ScanDirectory;
import com.digital.skills.challenge.domain.FileDetail;
import com.digital.skills.challenge.util.PropertyHelper;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ScanDirectoryTest {

    private ScanDirectory scanDirectory;
    private String filePath = PropertyHelper.getInstance().getProperty("folder.location");


    @Test
    public void shouldReturnListWithFileDetailsTest(){
        scanDirectory = new ScanDirectory();
        List<FileDetail> fileDetailList = scanDirectory.getFileDetailsForGivenFilePath(filePath);
        Assert.assertTrue(fileDetailList.size()>0);
    }

    @Test
    public void shouldReturnListWithFileExtensionFilterTest(){
        scanDirectory = new ScanDirectory();
        List<FileDetail> fileDetailList = scanDirectory.getFileDetailsForGivenFilePathWithFileNameExtensionFilter(filePath,true);
        Assert.assertTrue(fileDetailList.size()>0);
        String fileExtension = PropertyHelper.getInstance().getProperty("supported.file.extension");
        List<String> fileExtensions = Arrays.asList(fileExtension.split(","));
        Assert.assertFalse(fileDetailList.stream().filter(o -> !fileExtensions.contains(o.getFileExtension())).findAny().isPresent());
    }

    @Test
    public void shouldReturnFullListOfFilesWhenExtensionFilterIsDisabledTest(){
        scanDirectory = new ScanDirectory();
        List<FileDetail> fileDetailList = scanDirectory.getFileDetailsForGivenFilePathWithFileNameExtensionFilter(filePath,false);
        Assert.assertTrue(fileDetailList.size()>0);
        String fileExtension = PropertyHelper.getInstance().getProperty("supported.file.extension");
        List<String> fileExtensions = Arrays.asList(fileExtension.split(","));
        Assert.assertTrue(fileDetailList.stream().filter(o -> fileExtensions.contains(o.getFileExtension())).findAny().isPresent());
    }


    @Test
    public void shouldReturnEmptyListForInvalidFilePathTest(){
        scanDirectory = new ScanDirectory();
        List<FileDetail> fileDetailList = scanDirectory.getFileDetailsForGivenFilePath("/Users/invalid");
        Assert.assertTrue(fileDetailList.isEmpty());
    }


    @Test
    public void shouldReturnListWithGivenFileMimeTypeTest(){
        scanDirectory = new ScanDirectory();
        String mimeType = "application/octet-stream";
        List<FileDetail> fileDetailList = scanDirectory.getFileDetailsForGivenFilePathAndMimeType(filePath, mimeType);
        Assert.assertFalse(fileDetailList.isEmpty());
        Assert.assertFalse(fileDetailList.stream().filter(o -> !o.getFileMimeType().equals(mimeType)).findAny().isPresent());
    }

    @Test
    public void shouldReturnListWithGivenFileMimeTypesTest(){
        scanDirectory = new ScanDirectory();
        String mimeType_octet = "application/octet-stream";
        String mimeType_Jpeg = "image/jpeg";
        String mimeType_JSON = "application/json";
        String[] mimeType = {mimeType_Jpeg,mimeType_octet};

        List<FileDetail> fileDetailList = scanDirectory.getFileDetailsForGivenFilePathAndMimeType(filePath, mimeType);
        Assert.assertTrue(fileDetailList.size()>0);
        Assert.assertFalse(fileDetailList.stream().filter(o -> o.getFileMimeType().equals(mimeType)).findAny().isPresent());
    }

    @Test
    public void shouldReturnEmptyListForGivenFileMimeTypeTest(){
        scanDirectory = new ScanDirectory();
        String mimeType = "application/json";
        List<FileDetail> fileDetailList = scanDirectory.getFileDetailsForGivenFilePathAndMimeType(filePath, mimeType);
        Assert.assertTrue(fileDetailList.isEmpty());
    }

    @Test
    public void shouldReturnListOfFileForValidPath(){
        scanDirectory = new ScanDirectory();
        List<File> fileList = scanDirectory.getFileForGivenFilePathAndExtension(filePath, ".csv");
        Assert.assertFalse(fileList.isEmpty());
    }

    @Test
    public void shouldReturnListOfFileForValidPathWithMultipleExtension(){
        scanDirectory = new ScanDirectory();
        List<File> fileList = scanDirectory.getFileForGivenFilePathAndExtension(filePath, ".json,.pdf");
        Assert.assertTrue(fileList.isEmpty());
    }

    @Test
    public void shouldReturnEmptyListForInValidPath(){
        scanDirectory = new ScanDirectory();
        List<File> fileList = scanDirectory.getFileForGivenFilePathAndExtension("/user/invalid", ".csv");
        Assert.assertTrue(fileList.isEmpty());
    }
}
