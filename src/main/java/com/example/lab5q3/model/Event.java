package com.example.lab5q3.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Event {
    private String  id;
    private int capacity;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate ;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

}
