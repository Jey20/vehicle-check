package com.digital.skills.challenge;

import java.io.File;
import java.io.FileFilter;

public class FileExtensionFilter implements FileFilter {

    private final String[] extensionNames;

    public FileExtensionFilter(String... extensionNames) {
        this.extensionNames = extensionNames;
    }

    public boolean accept(File fileName) {
        if (fileName.isDirectory()) {
            return true;
        }

        for (String extension : extensionNames) {
            if (fileName.getName().toLowerCase().endsWith(extension)) {
                return true;
            }
        }

        return false;
    }
}
