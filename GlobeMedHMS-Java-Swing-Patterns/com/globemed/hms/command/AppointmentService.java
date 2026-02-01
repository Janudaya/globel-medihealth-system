package com.globemed.hms.command;

import java.time.LocalDateTime;
import java.util.*;
import com.globemed.hms.model.Appointment;

public class AppointmentService {
    private Map<String, Appointment> store = new LinkedHashMap<>();
    public Appointment book(String id, String doctor, LocalDateTime when){
        Appointment a = new Appointment(id, doctor, when);
        store.put(id, a);
        return a;
    }
    public Appointment cancel(String id){
        return store.remove(id);
    }
    public Collection<Appointment> list(){ return store.values(); }
}
