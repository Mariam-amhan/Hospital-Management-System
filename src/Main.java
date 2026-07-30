import java.util.Scanner;

import models.Patient;
import models.Doctor;
import models.Appointment;

import services.HospitalSystem;
import services.FileManager;



public class Main {
    
    public static void main(String[] args) { 

        HospitalSystem hospital = new HospitalSystem(); 
        FileManager fileManager = new FileManager();
        Scanner input = new Scanner(System.in);

        for (Patient patient : fileManager.loadPatients()) {
             hospital.addPatient(patient);
             }

        for (Doctor doctor : fileManager.loadDoctors()) {
             hospital.addDoctor(doctor);
             }

        for (Appointment appointment : fileManager.loadAppointments( hospital.getPatients(), hospital.getDoctors())) {
             hospital.addAppointment(appointment);
             }

        int choice;

        do {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. Display Patients");
            System.out.println("5. Display Doctors");
            System.out.println("6. Display Appointments");
            System.out.println("7. Search Patient");
            System.out.println("8. Search Doctor");
            System.out.println("9. Search Appointment");
            System.out.println("10. Update Patient");
            System.out.println("11. Update Doctor");
            System.out.println("12. Remove Patient");
            System.out.println("13. Remove Doctor");
            System.out.println("14. Remove Appointment");
            System.out.println("15. Save and Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();

         

         switch (choice) {

    case 1: {

        System.out.print("Enter patient ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter patient name: ");
        String name = input.nextLine();

        System.out.print("Enter patient age: ");
        int age = input.nextInt();
        input.nextLine();

        System.out.print("Enter patient gender: ");
        String gender = input.nextLine();

        System.out.print("Enter patient disease: ");
        String disease = input.nextLine();

        System.out.print("Enter patient blood type: ");
        String bloodType = input.nextLine();

        System.out.print("Enter patient medical history: ");
        String medicalHistory = input.nextLine();

        Patient patient = new Patient(id, name, age, gender, disease, bloodType, medicalHistory);
        hospital.addPatient(patient);
        System.out.println("Patient added successfully.");

        break;
    }

    case 2: {

        System.out.print("Enter doctor ID: ");
        int doctorId = input.nextInt();
        input.nextLine();

        System.out.print("Enter doctor name: ");
        String doctorName = input.nextLine();

        System.out.print("Enter doctor age: ");
        int doctorAge = input.nextInt();
        input.nextLine();

        System.out.print("Enter doctor gender: ");
        String doctorGender = input.nextLine();

        System.out.print("Enter doctor specialization: ");
        String specialization = input.nextLine();

        System.out.print("Enter doctor salary: ");
        double salary = input.nextDouble();
        input.nextLine();

        System.out.print("Enter doctor years of experience: ");
        int yearsOfExperience = input.nextInt();
        input.nextLine();

        Doctor doctor = new Doctor(doctorId, doctorName, doctorAge, doctorGender, specialization, salary, yearsOfExperience);
        hospital.addDoctor(doctor);
        System.out.println("Doctor added successfully.");

        break;
    }

    case 3: {

        System.out.print("Enter patient ID: ");
        int patientId = input.nextInt();

        System.out.print("Enter doctor ID: ");
        int doctorId = input.nextInt();
        input.nextLine();

        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String date = input.nextLine();

        System.out.print("Enter appointment time (HH:MM): ");
        String time = input.nextLine();

        Patient patient = hospital.searchPatientById(patientId);
        Doctor doctor = hospital.searchDoctorById(doctorId);

        if (patient == null) {
            System.out.println("Patient not found.");
        break;
        }

        if(doctor == null){
            System.out.println("Doctor not found.");
        break;
        }

        boolean success = hospital.bookAppointment(patientId,doctorId,date,time);

        if (success) {
            System.out.println("Appointment booked successfully.");
        } else {
            System.out.println("Failed to book appointment.");
        }
        break;
        } 

    case 4: {
        hospital.displayAllPatients();
        break;
        } 

    case 5: {
        hospital.displayAllDoctors();
        break;
        }

    case 6: {
        hospital.displayAllAppointments();
        break;
        }
    
    case 7: {
        System.out.print("Enter patient ID to search: ");
        int searchPatientId = input.nextInt();
        Patient foundPatient = hospital.searchPatientById(searchPatientId);
        if (foundPatient != null) {
            foundPatient.displayInfo();
        } else {
            System.out.println("Patient not found.");
        }
        break;
        }

    case 8: {
        System.out.print("Enter doctor ID to search: ");
        int searchDoctorId = input.nextInt();
        Doctor foundDoctor = hospital.searchDoctorById(searchDoctorId);
        if (foundDoctor != null) {
            foundDoctor.displayInfo();
        } else {
            System.out.println("Doctor not found.");   
        }
        break;
        }

    case 9: {
        System.out.print("Enter appointment ID to search: ");
        int searchAppointmentId = input.nextInt();
        Appointment foundAppointment = hospital.searchAppointmentById(searchAppointmentId);
        if (foundAppointment != null) {
            foundAppointment.displayInfo();
        } else {
            System.out.println("Appointment not found.");
        }
        break;
        }

    case 10: {
        System.out.print("Enter patient ID to update: ");
        int updatePatientId = input.nextInt();
        input.nextLine();

        System.out.print("Enter new patient name: ");
        String newPatientName = input.nextLine();

        System.out.print("Enter new patient age: ");
        int newPatientAge = input.nextInt();
        input.nextLine();

        System.out.print("Enter new patient gender: ");
        String newPatientGender = input.nextLine();

        System.out.print("Enter new patient disease: ");
        String newPatientDisease = input.nextLine();

        System.out.print("Enter new patient blood type: ");
        String newPatientBloodType = input.nextLine();

        System.out.print("Enter new patient medical history: ");
        String newPatientMedicalHistory = input.nextLine();

        boolean patientUpdated = hospital.updatePatientById(updatePatientId, newPatientName, newPatientAge, newPatientGender, newPatientDisease, newPatientBloodType, newPatientMedicalHistory);
        if (patientUpdated) {
            System.out.println("Patient updated successfully.");
        } else {
            System.out.println("Patient not found.");
        }

        break;
        }

    case 11: {
        System.out.print("Enter doctor ID to update: ");
        int updateDoctorId = input.nextInt();
        input.nextLine();

        System.out.print("Enter new doctor name: ");
        String newDoctorName = input.nextLine();

        System.out.print("Enter new doctor age: ");
        int newDoctorAge = input.nextInt();
        input.nextLine();

        System.out.print("Enter new doctor gender: ");
        String newDoctorGender = input.nextLine();

        System.out.print("Enter new doctor specialization: ");
        String newDoctorSpecialization = input.nextLine();

        System.out.print("Enter new doctor salary: ");
        double newDoctorSalary = input.nextDouble();
        input.nextLine();

        System.out.print("Enter new doctor years of experience: ");
        int newDoctorYearsOfExperience = input.nextInt();
        input.nextLine();

        boolean doctorUpdated = hospital.updateDoctorById(updateDoctorId, newDoctorName, newDoctorAge, newDoctorGender, newDoctorSpecialization, newDoctorSalary, newDoctorYearsOfExperience);
        if (doctorUpdated) {
            System.out.println("Doctor updated successfully.");
        } else {
            System.out.println("Doctor not found.");
        }

        break;
        }

    case 12: {
        System.out.print("Enter patient ID to remove: ");
        int removePatientId = input.nextInt();
        boolean patientRemoved = hospital.removePatientById(removePatientId);
        if (patientRemoved) {
            System.out.println("Patient removed successfully.");
        } else {
            System.out.println("Patient not found.");
        }

        break;
        }

    case 13: {
        System.out.print("Enter doctor ID to remove: ");
        int removeDoctorId = input.nextInt();
        boolean doctorRemoved = hospital.removeDoctorById(removeDoctorId);
        if (doctorRemoved) {
            System.out.println("Doctor removed successfully.");
        } else {
            System.out.println("Doctor not found.");
        }

        break;
        }

    case 14: {
        System.out.print("Enter appointment ID to remove: ");
        int removeAppointmentId = input.nextInt();
        boolean appointmentRemoved = hospital.removeAppointmentById(removeAppointmentId);
        if (appointmentRemoved) {
            System.out.println("Appointment removed successfully.");
        } else {
            System.out.println("Appointment not found.");
        }

        break;
        }

    case 15: {

    System.out.println("Saving data...");

    fileManager.savePatients(hospital.getPatients());
    fileManager.saveDoctors(hospital.getDoctors());
    fileManager.saveAppointments(hospital.getAppointments());

    System.out.println("Data saved successfully.");
    System.out.println("Goodbye!");

    input.close();
    break;
    }

    default: {
    System.out.println("Invalid choice.");
    break;
    }

  }


   } while (choice != 15) ;

  }

}



 







