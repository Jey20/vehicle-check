package com.digital.skills.challenge;

import com.digital.skills.challenge.domain.FileDetail;
import com.digital.skills.challenge.util.PropertyHelper;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ScanDirectory {


    public  List<FileDetail> getFileDetailsForGivenFilePath(String filePath) {
        return getFileDetailsForGivenFilePathWithFileNameExtensionFilter(filePath, false);
    }

    public List<File> getFileForGivenFilePathAndExtension(String filePath, String fileNameFilter) {

        FileFilter fileFilter;

        if(!fileNameFilter.isEmpty() && fileNameFilter.contains(",")){
            fileFilter = new FileExtensionFilter(fileNameFilter.split(","));
        } else {
            fileFilter = new FileExtensionFilter(fileNameFilter);
        }

        File folder = new File(filePath);
        File[] listOfFiles = folder.listFiles(fileFilter);

        List<File> files = new ArrayList<>();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (!file.isDirectory()) {
                    files.add(file);
                }
            }
        }
        return files;
    }


    public List<FileDetail> getFileDetailsForGivenFilePathWithFileNameExtensionFilter(String filePath, boolean isFileFilterEnabled) {

        FileFilter fileFilter = null;

        if (isFileFilterEnabled) {
            String property = PropertyHelper.getInstance().getProperty("supported.file.extension");
            fileFilter = new FileExtensionFilter(property.split(","));
        }

        File folder = new File(filePath);
        File[] listOfFiles = folder.listFiles(fileFilter);

        List<FileDetail> fileDetailList = new ArrayList<>();
        MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (!file.isDirectory()) {
                    String extension = file.getName().replaceAll(".*\\.", "");
                    FileDetail fileDetail = new FileDetail();
                    fileDetail.setFileName(file.getName());
                    fileDetail.setFileExtension(extension);
                    fileDetail.setFileSize(file.length());
                    fileDetail.setFileMimeType(mimeTypesMap.getContentType(file));

                    fileDetailList.add(fileDetail);
                }
            }
        }
        return fileDetailList;

    }


    public List<FileDetail> getFileDetailsForGivenFilePathAndMimeType(String filePath, String... mimeType) {
        List<FileDetail> fileDetailList = getFileDetailsForGivenFilePath(filePath);
        return fileDetailList.stream().filter(fileDetail -> Arrays.asList(mimeType).contains(fileDetail.getFileMimeType())).collect(toList());
    }


}
