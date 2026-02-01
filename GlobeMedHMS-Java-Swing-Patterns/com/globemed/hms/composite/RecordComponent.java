package com.globemed.hms.composite;

import java.util.ArrayList;
import java.util.List;
import com.globemed.hms.visitor.Visitable;
import com.globemed.hms.visitor.ReportVisitor;

public abstract class RecordComponent implements Visitable {
    protected String title;
    protected List<RecordComponent> children = new ArrayList<>();
    public RecordComponent(String title){ this.title = title; }
    public String getTitle(){ return title; }
    public void add(RecordComponent c){ children.add(c); }
    public void remove(RecordComponent c){ children.remove(c); }
    public List<RecordComponent> getChildren(){ return children; }

    @Override
    public void accept(ReportVisitor visitor){
        visitor.visit(this);
        for (RecordComponent c : children) c.accept(visitor);
    }
}
