package com.globemed.hms.model;

import com.globemed.hms.visitor.Visitable;
import com.globemed.hms.visitor.ReportVisitor;

public class Invoice implements Visitable {
    private String id;
    private double amount;
    private boolean paid;

    public Invoice(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }
    public String getId() { return id; }
    public double getAmount() { return amount; }
    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }

    @Override
    public void accept(ReportVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() { return "Invoice{" + id + ", $" + amount + ", paid=" + paid + "}"; }
}
