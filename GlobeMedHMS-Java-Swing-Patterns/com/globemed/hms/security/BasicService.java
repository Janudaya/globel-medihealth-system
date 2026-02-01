package com.globemed.hms.security;

public class BasicService implements SecureService {
    private String serviceName;
    public BasicService(String name){ this.serviceName = name; }
    @Override public String name(){ return serviceName; }
    @Override public String perform(String action){ return "["+serviceName+"] performed: " + action; }
}
