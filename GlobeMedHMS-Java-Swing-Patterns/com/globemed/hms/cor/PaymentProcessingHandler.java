package com.globemed.hms.cor;

public class PaymentProcessingHandler extends ClaimHandler {
    @Override protected String process(ClaimRequest req){
        if (req.eligible && req.covered && req.supervisorApproved){
            req.paid = true;
            return "Payment processed: $" + req.amount;
        }
        return "Payment blocked";
    }
}
