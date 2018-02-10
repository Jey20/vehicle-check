package com.digital.skills.challenge.domain;

public class FileDetail {

    private String fileName;
    private String fileMimeType;
    private Long fileSize;
    private String fileExtension;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileMimeType() {
        return fileMimeType;
    }

    public void setFileMimeType(String fileMimeType) {
        this.fileMimeType = fileMimeType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }


    @Override
    public String toString() {
        return "FileDetail{" +
                "fileName='" + fileName + '\'' +
                ", fileMimeType='" + fileMimeType + '\'' +
                ", fileSize=" + fileSize +
                ", fileExtension='" + fileExtension + '\'' +
                '}';
    }
}
