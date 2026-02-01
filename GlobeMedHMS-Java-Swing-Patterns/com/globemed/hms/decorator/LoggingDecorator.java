package com.globemed.hms.decorator;

public class LoggingDecorator extends DataSourceDecorator {
    public LoggingDecorator(DataSource ds){ super(ds); }
    @Override public void writeData(String data) throws Exception {
        System.out.println("[LOG] write " + Math.min(30, data.length()) + " chars");
        super.writeData(data);
    }
    @Override public String readData() throws Exception {
        System.out.println("[LOG] read");
        return super.readData();
    }
}
