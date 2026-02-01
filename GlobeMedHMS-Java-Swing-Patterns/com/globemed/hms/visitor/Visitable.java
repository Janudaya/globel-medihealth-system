package com.globemed.hms.visitor;

public interface Visitable {
    void accept(ReportVisitor visitor);
}
