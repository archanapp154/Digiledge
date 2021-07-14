package com.example.digiledge.Controller;

import com.example.digiledge.Entity.Patient;
import com.example.digiledge.Service.patientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class covidController {

    @Autowired
    patientService patientRepository;


    @GetMapping("CovidManagement/Add Patient/")    // Will show Add Patient Form
    public String showAddPatientForm(Patient patient) {
        return "AddPatient";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("patients", patientRepository.findAll());    // Will display all the patients
        return "index";
    }

    @GetMapping("CovidManagement/UpdateForm/{id}")
    public String UpdateForm(@PathVariable("id") int id, Model model) {     //Will show Update Patient Form
        Patient patient = patientRepository.findById(id).get();
        model.addAttribute("patient", patient);
        return "UpdatePatient";
    }

    @GetMapping("CovidManagement/Delete/{id}")
    public String deleteStudent(@PathVariable("id") int id, Model model) {
        Patient patient = patientRepository.findById(id).get();
        patientRepository.delete(patient);
        model.addAttribute("patients", patientRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addStudent( Patient patient ){   // This will add patient (Business code, form's action )
                                                    //which have list of all patients
        patientRepository.save(patient);
        return "redirect:list";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") int id,Patient patient,Model model) {  //Businesss code for updating patient

        patientRepository.save(patient);
        model.addAttribute("patients", patientRepository.findAll());
        return "index";
    }
}
