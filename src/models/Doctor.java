package models;

public class Patient extends Person {
    protected String disease;
    protected String bloodType;
    protected String medicalHistory;

    public Patient(int id, String name, int age, String gender, String disease, String bloodType,
            String medicalHistory) {
        super(id, name, age, gender);
        this.disease = disease;
        this.bloodType = bloodType;
        this.medicalHistory = medicalHistory;

    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDisease() {
        return disease;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Disease: " + disease);
        System.out.println("Blood Type: " + bloodType);
        System.out.println("Medical History: " + medicalHistory);
    }

}
