package com.example.ProjectQuanLyHocSinh.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemsStorageService implements StorageService{

    private final Path rootLocation = Paths.get("src/main/resources/static/uploads");
    @Override
    public void store(MultipartFile file) {

    }
}
