package hosPatelDirectory;

import java.util.ArrayList;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.*;

public class Hospital {
    
    ArrayList<Staff> staffList;
    ArrayList<Patient> patientList;

    // constructor to initialize staffList and patientList
    public Hospital() {
        
        staffList = new ArrayList<Staff>();
        patientList = new ArrayList<Patient>();
    }

    // method to add a new staff member to the hospital
    public void addStaff(String name, String id, String position) {
        
        Staff newStaff = new Staff(name, id, position);
        staffList.add(newStaff);
        
    }

    // method to add a new patient to the hospital
    public void addPatient(String name, String id, String disease, String healthStatus) {
        Patient newPatient = new Patient(name, id, disease, healthStatus);
        patientList.add(newPatient);
    }
    
    // method to assign a staff member to a patient
    public void assignStaffToPatient(String staffId, String patientId) {
        
    	// locates a specific staff member by id 
        Staff staff = findStaffById(staffId);
        
        if(findStaffById(staffId) == null) {    
        	
        	System.out.println("Staff member not found");
        	return;

        }
        
    	// locates a specific patient by id 
        Patient patient = findPatientById(patientId);
        
        if(findPatientById(patientId) == null) {    
        	
        	System.out.println("Patient not found");
        	return;

        }
        
        // sets the found staff member to the specified patient
        patient.setStaff(staff);
        
        // calls a method in the patient class to print a sentence regarding the staff member and the patient
        patient.seeStaff();
        
    }
    
    // method to assign a staff member to a patient
    public void assignPatientToStaff(String patientId, String staffId) {
        
    	// locates a specific staff member by id 
        Staff staff = findStaffById(staffId);
        
        if(findStaffById(staffId) == null) {    
        	
        	System.out.println("Staff member not found");
        	return;

        }
        
    	// locates a specific patient by id 
        Patient patient = findPatientById(patientId);
        
        if(findPatientById(patientId) == null) {    
        	
        	System.out.println("Patient not found");
        	return;

        }
        
        // sets the found patient to the specified staff member
        staff.setPatient(patient);
        
        // calls a method in the staff class to print a sentence regarding the staff member and the patient
        staff.seePatient();
        
    }
    
    // display all data on all doctors
    public void displayPatientData() {
       
        if (patientList.isEmpty()) {
            System.out.println("No patients to display.");
            return;
        }
        
        for (int i = 0; i < patientList.size(); i++) {
            Patient patient = patientList.get(i);
            System.out.println("Patient: " + (i+1) );
            System.out.println("");
            System.out.println("Name: " + patient.getName());
            System.out.println("ID: " + patient.getId());
            System.out.println("Disease: " + patient.getDisease());
            System.out.println("Health Status: " + patient.getHealthStatus());
            System.out.println("");
        }
    }
    
    // method to display information about a specific patient
    public void displayPatientInfo(String patientId) {
        Patient patient = findPatientById(patientId);
        
        if(findPatientById(patientId) == null) {    
        	
        	System.out.println("Patient not found");
        	return;

        }
        
        System.out.println("Name: " + patient.getName());
        System.out.println("ID: " + patient.getId());
        System.out.println("Disease: " + patient.getDisease());
        System.out.println("Health Status: " + patient.getHealthStatus());
    }
    
    // method to remove all info about a specific patient
    public void removePatient(String patientId) {
        for (int i = 0; i < patientList.size(); i++) {
            Patient patient = patientList.get(i);
            if (patient.getId().equals(patientId)) {
                patientList.remove(i);
                System.out.println("patient has been removed");
                return;
            }
        }
        System.out.println("Staff member not found");
    }
    
    // display all data on all staff
    public void displayStaffData() {
        
        if (staffList.isEmpty()) {
            
            System.out.println("No Staff Memebers to display.");
            return;
        }
        
        for (int i = 0; i < staffList.size(); i++) {
            
            Staff staff = staffList.get(i);
            System.out.println("Staff memeber: " + (i+1) );
            System.out.println("");
            System.out.println("Name: " + staff.getName());
            System.out.println("ID: " + staff.getId());
            System.out.println("Position: " + staff.getPosition());
            System.out.println("");
        }
    }
    
    // method to sort staff by first name 
    
    public void sortStaffName(){
        
        boolean swap = true;
        while (swap){
            swap = false;
            
            // the code loops through the size of the ArrayList
            
            for (int i = 0; i<staffList.size(); i++){
                
                if(i != staffList.size() - 1){
                    
                	// staff = current staff name 
                	
                	Staff staff = staffList.get(i);
                	
                	// staffTwo = staff name in front of current name
                	Staff staffTwo = staffList.get(i + 1);
                
                    // if .compareTo is greater than 0 this means that the current name comes after the next name
                    	
                    if (staff.getName().compareTo(staffTwo.getName()) > 0){
                    	
                    	// a temporary staff variable is created to store all values where the name is
                    	
                        Staff foundStaffMember = staff;
                        
                        // the current staff variable is now equal to the staff variable in front of it
                        
                        staffList.set(i, staffTwo);
                        
                        // the staff variable in front of the current staff variable is now equal to the temporary contact
                        
                        staffList.set(i + 1, foundStaffMember);
                        
                        // a swap has taken place so the swap value is now true
                        
                        swap = true;
                    }
                }
            }
        }
    }
    
    public void importStaffData() throws FileNotFoundException {

	    // Clears all data from the ArrayList before importing
	    
    	staffList.clear();

	    // Scans input from the user for the file name
	    
	    Scanner input = new Scanner(System.in);
	    System.out.println("Enter a file name to import data from:  ");
	    String fileName = input.nextLine();
	    System.out.println();

	    // Scans the file with the specified file name
	    
	    Scanner fileRead = new Scanner(new File(fileName));

	    // while there are still lines in the file, the following code runs
	    
	    while (fileRead.hasNext()) {
	        String line = fileRead.nextLine();
	        
	        // Scans each line for the specific values separated by ", "
	        
	        Scanner itemsFound = new Scanner(line);
	        
	        itemsFound.useDelimiter(", ");
	        
	        // Puts the found the values in the correct variables
	        
	        String name = itemsFound.next();
	        String id = itemsFound.next();
	        String position = itemsFound.next();
	        Staff staff = new Staff(name, id, position);
	        
	        // Closes the itemFound scanner
	        
	        itemsFound.close();
	        
	        // adds the contact to the ArrayList
	        
	        staffList.add(staff);
	    }
	    
	    fileRead.close();
    }
    
    // This method exports all the data in the staff ArrayList to a file that the user names 
    public void exportStaffData() throws FileNotFoundException {
        
    	// asks the user essentially what they want the file name to be
    	Scanner input = new Scanner(System.in);
        System.out.println("Enter a file name to export staff data to:  ");
        String fileName = input.nextLine();
        System.out.println();
        
        
		// PrintWriter creates the file with the inputed file name

        PrintWriter export = new PrintWriter(fileName);

        for(int i = 0; i < staffList.size(); i++) {
            
        	// access the element of the list by index i
        	
        	export.print(staffList.get(i).toString());
            if(i != staffList.size() - 1) {
                export.print(", ");
            }
            export.println();
        }
        export.close();
    }
    
    
    public void importPatientData() throws FileNotFoundException {

	    // Clears all data from the ArrayList before importing
	    
    	staffList.clear();

	    // Scans input from the user for the file name
	    
	    Scanner input = new Scanner(System.in);
	    System.out.println("Enter a file name to import data from:  ");
	    String fileName = input.nextLine();
	    System.out.println();

	    // Scans the file with the specified file name
	    
	    Scanner fileRead = new Scanner(new File(fileName));

	    // while there are still lines in the file, the following code runs
	    
	    while (fileRead.hasNext()) {
	        String line = fileRead.nextLine();
	        
	        // Scans each line for the specific values separated by ", "
	        
	        Scanner itemsFound = new Scanner(line);
	        
	        itemsFound.useDelimiter(", ");
	        
	        // Puts the found the values in the correct variables
	        
	        String name = itemsFound.next();
	        String id = itemsFound.next();
	        String disease = itemsFound.next();
	        String healthStatus = itemsFound.next();
	        Patient patient = new Patient(name, id, disease, healthStatus);
	        
	        // Closes the itemFound scanner
	        
	        itemsFound.close();
	        
	        // adds the contact to the ArrayList
	        
	        patientList.add(patient);
	    }
	    
	    fileRead.close();
    }
    
    // This method exports all the data in the staff ArrayList to a file that the user names 
    public void exportPatientData() throws FileNotFoundException {
        
    	// asks the user essentially what they want the file name to be
    	Scanner input = new Scanner(System.in);
        System.out.println("Enter a file name to export staff data to:  ");
        String fileName = input.nextLine();
        System.out.println();
        
        
		// PrintWriter creates the file with the inputed file name

        PrintWriter export = new PrintWriter(fileName);

        for(int i = 0; i < patientList.size(); i++) {
            
        	// access the element of the list by index i
        	
        	export.print(patientList.get(i).toString());
            if(i != patientList.size() - 1) {
                export.print(", ");
            }
            export.println();
        }
        export.close();
    }
    
	    
    public void sortPatientName(){
        
        boolean swap = true;
        while (swap){
            swap = false;
            
            // the code loops through the size of the ArrayList
            
            for (int i = 0; i<patientList.size(); i++){
                
                if(i != patientList.size() - 1){
                    
                	// patient = current patient name 
                	
                	Patient patient = patientList.get(i);
                	
                	// patientTwo = patient name in front of current name
                	Patient patientTwo = patientList.get(i + 1);
                
                    // if .compareTo is greater than 0 this means that the current name comes after the next name
                    	
                    if (patient.getName().compareTo(patientTwo.getName()) > 0){
                    	
                    	// a temporary patient variable is created to store all values where the name is
                    	
                        Patient foundPatient = patient;
                        
                        // the current patient variable is now equal to the patient variable in front of it
                        
                        patientList.set(i, patientTwo);
                        
                        // the patient variable in front of the current patient variable is now equal to the temporary contact
                        
                        patientList.set(i + 1, foundPatient);
                        
                        // a swap has taken place so the swap value is now true
                        
                        swap = true;
                    }
                }
            }
        }
    }

    // method to display information about a specific staff member
    public void displayStaffInfo(String staffId) {
        
        Staff staff = findStaffById(staffId);
        
        
        if(findStaffById(staffId) == null) {    
        	
        	System.out.println("Staff member not found");
        	return;

        }
        
        System.out.println("Name: " + staff.getName());
        System.out.println("ID: " + staff.getId());
        System.out.println("Position: " + staff.getPosition());
        
    }
    
    // method to all info about a specific staff member
    public void removeStaffMember(String staffId) {
        
        for (int i = 0; i < staffList.size(); i++) {
            Staff staff = staffList.get(i);
            if (staff.getId().equals(staffId)) {
                staffList.remove(i);
                System.out.println("Staff member has been removed");
                return;
            }
        }
        System.out.println("Staff member not found");
    }

    // method to update patient's health status
    
    public void updatePatientHealth(String patientId, String healthStatus) {
        
        Patient patient = findPatientById(patientId);
        patient.setHealthStatus(healthStatus);
        
    }
    
    // helper method to find a staff member by id
    public Staff findStaffById(String id) {
        for (int i = 0; i < staffList.size(); i++) {
            Staff staff = staffList.get(i);
            if (staff.getId().equals(id)) {
                return staff;
            }
        }
		return null;
    }

    // helper method to find a patient by id
    public Patient findPatientById(String id) {
        for (int i = 0; i < patientList.size(); i++) {
            Patient patient = patientList.get(i);
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        return null;
    }
}
