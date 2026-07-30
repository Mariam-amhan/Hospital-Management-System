package services;

import java.util.ArrayList;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

import models.Doctor;
import models.Patient;
import models.Appointment;


public class FileManager {
    public void savePatients(ArrayList<Patient> patients) 
    {
        try {
            FileWriter writer = new FileWriter("patients.txt");
            BufferedWriter bw = new BufferedWriter(writer);

            for (Patient patient : patients) 
                {
                    bw.write(
                    patient.getId() + "," +
                    patient.getName() + "," +
                    patient.getAge() + "," +
                    patient.getGender() + "," +
                    patient.getDisease() + "," +
                    patient.getBloodType() + "," +
                    patient.getMedicalHistory()
                    );
                 bw.newLine();
                }
                bw.close();

           } catch (IOException e) {
              e.printStackTrace();
           } 
        }

    public ArrayList<Patient> loadPatients() 
    {
           ArrayList<Patient> patients = new ArrayList<>();
            try {
                FileReader reader = new FileReader("patients.txt");
                BufferedReader br = new BufferedReader(reader);
                String line;
                while ((line = br.readLine()) != null) 
                    {
                    String[] data = line.split(",");
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String gender = data[3];
                    String disease = data[4];
                    String bloodType = data[5];
                    String medicalHistory = data[6];
                    Patient patient = new Patient(id, name, age, gender, disease, bloodType, medicalHistory);
                    patients.add(patient);
                }
                br.close();

            } catch (IOException e) {
               e.printStackTrace();
            }

            return patients;

         }

    public void saveDoctors(ArrayList<Doctor> doctors)
    {
      try {
        FileWriter writer = new FileWriter("doctors.txt");
            BufferedWriter bw = new BufferedWriter(writer);

            for (Doctor doctor : doctors) 
                {
                    bw.write(
                    doctor.getId() + "," +
                    doctor.getName() + "," +
                    doctor.getAge() + "," +
                    doctor.getGender() + "," +
                    doctor.getSpecialization() + "," +
                    doctor.getSalary() + "," +
                    doctor.getYearsOfExperience()
                    );

                 bw.newLine();

                }
                bw.close();

           } catch (IOException e) {
              e.printStackTrace();
           }
    }

    public ArrayList<Doctor> loadDoctors() 
    {
           ArrayList<Doctor> doctors = new ArrayList<>();
            try {
                FileReader reader = new FileReader("doctors.txt");
                BufferedReader br = new BufferedReader(reader);
                String line;
                while ((line = br.readLine()) != null) 
                    {
                    String[] data = line.split(",");
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String gender = data[3];
                    String specialization = data[4];
                    double salary = Double.parseDouble(data[5]);
                    int yearsOfExperience = Integer.parseInt(data[6]);
                    Doctor doctor = new Doctor(id,name,age,gender,specialization,salary,yearsOfExperience);
                    doctors.add(doctor);

                  }
                 br.close();

                }catch (IOException e){
                   e.printStackTrace();
                }

            return doctors;

         }
    
    public void saveAppointments(ArrayList<Appointment> appointments) {
        try {
            FileWriter writer = new FileWriter("appointments.txt");
            BufferedWriter bw = new BufferedWriter(writer);

            for (Appointment appointment : appointments) {
                bw.write(
                    appointment.getAppointmentId() + "," +
                    appointment.getPatient().getId() + "," +
                    appointment.getDoctor().getId() + "," +
                    appointment.getDate() + "," +
                    appointment.getTime()
                );
                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Appointment> loadAppointments(ArrayList<Patient> patients, ArrayList<Doctor> doctors) {
        ArrayList<Appointment> appointments = new ArrayList<>();
        try {
            FileReader reader = new FileReader("appointments.txt");
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int appointmentId = Integer.parseInt(data[0]);
                int patientId = Integer.parseInt(data[1]);
                int doctorId = Integer.parseInt(data[2]);
                String date = data[3];
                String time = data[4];

                Patient patient = null;
                Doctor doctor = null;

                for (Patient p : patients) {
                    if (p.getId() == patientId) {
                        patient = p;
                        break;
                    }
                }

                for (Doctor d : doctors) {
                    if (d.getId() == doctorId) {
                        doctor = d;
                        break;
                    }
                }

                if (patient != null && doctor != null) {
                    Appointment appointment = new Appointment(appointmentId, patient, doctor, date, time);
                    appointments.add(appointment);
                }
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return appointments;
    }
 }

    

