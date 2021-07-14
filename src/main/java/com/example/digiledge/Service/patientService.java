package com.example.digiledge.Service;


import com.example.digiledge.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface patientService extends JpaRepository<Patient,Integer> {

}
