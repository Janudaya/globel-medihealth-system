package com.globemed.hms.decorator;

public abstract class DataSourceDecorator implements DataSource {
    protected DataSource wrappee;
    public DataSourceDecorator(DataSource ds){ this.wrappee = ds; }
    @Override public void writeData(String data) throws Exception { wrappee.writeData(data); }
    @Override public String readData() throws Exception { return wrappee.readData(); }
}
