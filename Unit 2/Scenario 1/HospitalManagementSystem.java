// Class representing MedicalHistory (Composition: Patient has a MedicalHistory)
class MedicalHistory {
    private String condition;
    private String treatment;

    MedicalHistory(String condition, String treatment) {
        this.condition = condition;
        this.treatment = treatment;
    }

    String getCondition() {
        return condition;
    }

    String getTreatment() {
        return treatment;
    }

    void updateCondition(String condition) {
        this.condition = condition;
    }

    void updateTreatment(String treatment) {
        this.treatment = treatment;
    }
}

// Class representing a Patient (Composition: Patient has a MedicalHistory)
class Patient {
    private String name;
    private int age;
    private MedicalHistory medicalHistory;

    Patient(String name, int age, String condition, String treatment) {
        this.name = name;
        this.age = age;
        this.medicalHistory = new MedicalHistory(condition, treatment);
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    void updateMedicalHistory(String condition, String treatment) {
        this.medicalHistory.updateCondition(condition);
        this.medicalHistory.updateTreatment(treatment);
    }
}

// Class representing a Doctor (Association: Doctor is associated with Patients)
class Doctor {
    private String name;
    private String specialty;

    Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    String getName() {
        return name;
    }

    String getSpecialty() {
        return specialty;
    }

    void assignPatient(Patient patient) {
        System.out.println("Doctor " + name + " assigned to patient " + patient.getName());
    }
}

// Class representing an Appointment (Aggregation: A Doctor may have multiple Appointments)
class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;

    Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    Appointment(Patient patient, Doctor doctor, String date, String time) {
        this(patient, doctor, date); // Reusing the constructor
        this.time = time;
    }

    void displayAppointmentDetails() {
        System.out.println("Appointment for Patient: " + patient.getName());
        System.out.println("Doctor: " + doctor.getName() + ", Specialty: " + doctor.getSpecialty());
        System.out.println("Date: " + date + (time != null ? ", Time: " + time : ""));
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        // Create Doctors
        Doctor doctor1 = new Doctor("Dr. Sharma", "Cardiology");
        Doctor doctor2 = new Doctor("Dr. Gupta", "Neurology");

        // Create Patients
        Patient patient1 = new Patient("Ravi Kumar", 45, "Heart Disease", "Medication");
        Patient patient2 = new Patient("Simran Kaur", 30, "Migraine", "Painkillers");

        // Assign Doctors to Patients
        doctor1.assignPatient(patient1);
        doctor2.assignPatient(patient2);

        // Create Appointments (Method Overloading)
        Appointment appointment1 = new Appointment(patient1, doctor1, "2024-11-15");
        Appointment appointment2 = new Appointment(patient2, doctor2, "2024-11-16", "10:00 AM");

        // Display Appointments
        appointment1.displayAppointmentDetails();
        appointment2.displayAppointmentDetails();

        // Update Medical History of a Patient
        patient1.updateMedicalHistory("Heart Surgery", "Post-Surgery Care");
        System.out.println("Updated Medical History for " + patient1.getName() + ":");
        System.out.println("Condition: " + patient1.getMedicalHistory().getCondition());
        System.out.println("Treatment: " + patient1.getMedicalHistory().getTreatment());
    }
}
