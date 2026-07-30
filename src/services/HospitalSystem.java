package services;

import java.util.ArrayList;

import models.Patient;
import models.Doctor;
import models.Appointment;

public class HospitalSystem {

    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Appointment> appointments;

    public HospitalSystem() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public Patient searchPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }

        return null;
    }

    public boolean removePatientById(int id) {
        Patient patient = searchPatientById(id);

        if (patient != null) {
            patients.remove(patient);
            return true;
        }

        return false;
    }

    public Doctor searchDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }

        return null;
    }

    public boolean removeDoctorById(int id) {
        Doctor doctor = searchDoctorById(id);

        if (doctor != null) {
            doctors.remove(doctor);
            return true;
        }

        return false;
    }

    public Appointment searchAppointmentById(int appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId() == appointmentId) {
                return appointment;
            }
        }

        return null;
    }

    public boolean removeAppointmentById(int appointmentId) {
        Appointment appointment = searchAppointmentById(appointmentId);

        if (appointment != null) {
            appointments.remove(appointment);
            return true;
        }

        return false;
    }

    public void displayAllPatients() {
        for (Patient patient : patients) {
            patient.displayInfo();
            System.out.println("--------------------");
        }
    }

    public void displayAllDoctors() {
        for (Doctor doctor : doctors) {
            doctor.displayInfo();
            System.out.println("--------------------");
        }
    }

    public void displayAllAppointments() {
        for (Appointment appointment : appointments) {
            appointment.displayInfo();
            System.out.println("--------------------");
        }
    }

    public boolean updatePatientById(
            int id,
            String name,
            int age,
            String gender,
            String disease,
            String bloodType,
            String medicalHistory
    ) {
        Patient patient = searchPatientById(id);

        if (patient != null) {
            patient.setName(name);
            patient.setAge(age);
            patient.setGender(gender);
            patient.setDisease(disease);
            patient.setBloodType(bloodType);
            patient.setMedicalHistory(medicalHistory);

            return true;
        }

        return false;
    }

    public boolean updateDoctorById(
            int id,
            String name,
            int age,
            String gender,
            String specialization,
            double salary,
            int yearsOfExperience
    ) {
        Doctor doctor = searchDoctorById(id);

        if (doctor != null) {
            doctor.setName(name);
            doctor.setAge(age);
            doctor.setGender(gender);
            doctor.setSpecialization(specialization);
            doctor.setSalary(salary);
            doctor.setYearsOfExperience(yearsOfExperience);

            return true;
        }

        return false;
    }

    public boolean bookAppointment(
            int patientId,
            int doctorId,
            String date,
            String time
    ) {
        Patient patient = searchPatientById(patientId);
        Doctor doctor = searchDoctorById(doctorId);

        if (patient != null && doctor != null) {

            for (Appointment appointment : appointments) {
                if (appointment.getDoctor().getId() == doctorId
                        && appointment.getDate().equals(date)
                        && appointment.getTime().equals(time)) {

                    return false;
                }
            }

            int appointmentId = generateAppointmentID();

            Appointment appointment = new Appointment(
                    appointmentId,
                    patient,
                    doctor,
                    date,
                    time
            );

            addAppointment(appointment);
            return true;
        }

        return false;
    }

    public int generateAppointmentID() {

    int maxId = 0;

    for (Appointment appointment : appointments) {
        if (appointment.getAppointmentId() > maxId) {
            maxId = appointment.getAppointmentId();
        }
    }

    return maxId + 1;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
}