package com.globemed.hms.cor;

public class SupervisorApprovalHandler extends ClaimHandler {
    @Override protected String process(ClaimRequest req){
        if (!req.supervisorApproved) return "Supervisor rejected";
        return "Supervisor approved";
    }
}
