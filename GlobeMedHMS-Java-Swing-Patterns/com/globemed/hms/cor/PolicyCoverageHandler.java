package com.globemed.hms.cor;

public class PolicyCoverageHandler extends ClaimHandler {
    @Override protected String process(ClaimRequest req){
        if (!req.covered) return "Policy coverage denied";
        return "Policy coverage OK";
    }
}
