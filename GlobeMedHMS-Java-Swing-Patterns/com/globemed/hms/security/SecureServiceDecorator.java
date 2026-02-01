package com.globemed.hms.security;

public class SecureServiceDecorator implements SecureService {
    private SecureService wrappee;
    private Role currentRole;
    public SecureServiceDecorator(SecureService s, Role r){ this.wrappee = s; this.currentRole = r; }
    @Override public String name(){ return wrappee.name(); }
    @Override public String perform(String action){
        // Only ADMIN and DOCTOR can perform actions containing "record"
        if (action.toLowerCase().contains("record")){
            if (currentRole == Role.ADMIN || currentRole == Role.DOCTOR){
                return wrappee.perform(action);
            } else {
                return "[ACCESS DENIED] " + currentRole + " cannot " + action;
            }
        }
        return wrappee.perform(action);
    }
}
