package com.globemed.hms.decorator;

public interface DataSource {
    void writeData(String data) throws Exception;
    String readData() throws Exception;
}
