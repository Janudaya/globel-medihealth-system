package com.globemed.hms.command;

public class CancelAppointmentCommand implements Command {
    private AppointmentService service;
    private String id;
    public CancelAppointmentCommand(AppointmentService s, String id){ this.service = s; this.id = id; }
    @Override public String execute(){
        return service.cancel(id) != null ? "Canceled " + id : "No appointment " + id;
    }
}
