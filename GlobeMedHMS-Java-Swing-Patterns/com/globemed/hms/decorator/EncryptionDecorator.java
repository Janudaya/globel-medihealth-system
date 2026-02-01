package com.globemed.hms.decorator;

public class EncryptionDecorator extends DataSourceDecorator {
    private int key = 42;
    public EncryptionDecorator(DataSource ds){ super(ds); }
    private String xor(String s){
        char[] out = new char[s.length()];
        for (int i=0;i<s.length();i++) out[i] = (char)(s.charAt(i) ^ key);
        return new String(out);
    }
    @Override public void writeData(String data) throws Exception { super.writeData(xor(data)); }
    @Override public String readData() throws Exception { return xor(super.readData()); }
}
