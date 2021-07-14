package com.example.digiledge.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //@NotBlank(message = "Name is mandatory")
    @Column(name = "patientName")
    private String patientName;
    @NotBlank(message = "Status is mandatory")
    private String covidStatus;
    @NotBlank(message = "Number is mandatory")
    private String contactNo;
    private String address;


}
