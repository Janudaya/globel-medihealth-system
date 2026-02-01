package com.globemed.hms.decorator;

import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class FileDataSource implements DataSource {
    private Path path;
    public FileDataSource(String filename){
        this.path = Paths.get(filename);
    }
    @Override
    public void writeData(String data) throws Exception {
        if (!Files.exists(path.getParent())) Files.createDirectories(path.getParent());
        Files.write(path, data.getBytes(StandardCharsets.UTF_8));
    }
    @Override
    public String readData() throws Exception {
        if (!Files.exists(path)) return "";
        return new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
    }
}
