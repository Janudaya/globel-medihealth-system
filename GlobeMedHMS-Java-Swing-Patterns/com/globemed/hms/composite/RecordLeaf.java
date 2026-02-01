package com.globemed.hms.composite;

import com.globemed.hms.visitor.ReportVisitor;

public class RecordLeaf extends RecordComponent {
    private String content;
    public RecordLeaf(String title, String content){
        super(title);
        this.content = content;
    }
    public String getContent(){ return content; }

    @Override
    public void accept(ReportVisitor visitor){
        visitor.visit(this); // leaf visit
    }
}
