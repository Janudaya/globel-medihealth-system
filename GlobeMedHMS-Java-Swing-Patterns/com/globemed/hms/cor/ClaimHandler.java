package com.globemed.hms.cor;

public abstract class ClaimHandler {
    protected ClaimHandler next;
    public ClaimHandler linkWith(ClaimHandler next){ this.next = next; return next; }
    public String handle(ClaimRequest req){
        String res = process(req);
        if (next != null) res += "\n" + next.handle(req);
        return res;
    }
    protected abstract String process(ClaimRequest req);
}
