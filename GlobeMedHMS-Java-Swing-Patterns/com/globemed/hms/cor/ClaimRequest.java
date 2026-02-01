package com.globemed.hms.cor;

public class ClaimRequest {
    public String patientId;
    public double amount;
    public boolean eligible = true;
    public boolean covered = true;
    public boolean supervisorApproved = true;
    public boolean paid = false;

    public ClaimRequest(String patientId, double amount){
        this.patientId = patientId; this.amount = amount;
    }
}
