package com.globemed.hms.command;

import java.time.LocalDateTime;

public class BookAppointmentCommand implements Command {
    private AppointmentService service;
    private String id, doctor;
    private LocalDateTime when;
    public BookAppointmentCommand(AppointmentService s, String id, String doctor, LocalDateTime when){
        this.service = s; this.id = id; this.doctor = doctor; this.when = when;
    }
    @Override public String execute(){
        service.book(id, doctor, when);
        return "Booked appointment " + id + " with Dr." + doctor + " at " + when;
    }
}
