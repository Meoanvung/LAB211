/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Doctor;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class function {

    Map<String, Doctor> doctorMap;

    public function() {
        doctorMap = new HashMap<>();
    }

    public void addDoctor(Doctor doctor) throws Exception {
        if (doctorMap.containsKey(doctor.getNewCode())) {
            throw new Exception("Doctor code " + doctor.getNewCode() + " is duplicate");
        }

        doctorMap.put(doctor.getNewCode(), doctor);
    }

    public void updateDoctor(Doctor doctor) throws Exception {
        if (!doctorMap.containsKey(doctor.getNewCode())) {
            throw new Exception("Doctor code " + doctor.getNewCode() + " does not exist");
        }

        Doctor existingDoctor = doctorMap.get(doctor.getNewCode());

        // Update the doctor information if not blank
        if (doctor.getNewName() != null && !doctor.getNewName().isEmpty()) {
            existingDoctor.setNewName(doctor.getNewName());
        }
        if (doctor.getnewSpecialization() != null && !doctor.getnewSpecialization().isEmpty()) {
            existingDoctor.setNewSpecialization(doctor.getnewSpecialization());
        }
        if (doctor.getNewAvailability() >= 0) {
            existingDoctor.setNewAvailability(doctor.getNewAvailability());
        }
    }

    public void deleteDoctor(String code) throws Exception {
        if (!doctorMap.containsKey(code)) {
            throw new Exception("Doctor code " + code + " does not exist");
        }

        doctorMap.remove(code);
    }

    public Map<String, Doctor> searchDoctor(String input) throws Exception {
        Map<String, Doctor> result = new HashMap<>();

        for (Map.Entry<String, Doctor> entry : doctorMap.entrySet()) {
            Doctor doctor = entry.getValue();
            if (doctor.getNewName().contains(input) || doctor.getnewSpecialization().contains(input)) {
                result.put(entry.getKey(), doctor);
            }
        }

        return result;
    }
}
