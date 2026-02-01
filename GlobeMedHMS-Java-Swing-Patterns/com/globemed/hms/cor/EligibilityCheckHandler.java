package com.globemed.hms.cor;

public class EligibilityCheckHandler extends ClaimHandler {
    @Override protected String process(ClaimRequest req){
        if (!req.eligible) return "Eligibility failed for " + req.patientId;
        return "Eligibility OK for " + req.patientId;
    }
}
