package hosPatelDirectory;

import java.util.*;
import java.io.*;

public class HosPatelMain
{
    public static void main(String[] args) throws FileNotFoundException {
        
        // Create a new hospital object
        
        Hospital hospital = new Hospital();
        
        System.out.println("Welcome to the Hospatel (Hospital) directory");
        System.out.println("");
        Scanner input = new Scanner(System.in);
        
        boolean menu = true;
        
        while (menu) {
            
            System.out.println("1. Staff directory ");
            System.out.println("2. Patient directory ");
            System.out.println("3. Exit ");
            System.out.println("");
            int directoryChoice = input.nextInt();
            
            // Check for valid input
            while (directoryChoice <=0 || directoryChoice > 3){
                
                System.out.println("");
                System.out.println("Invalid input");
                System.out.println("");
                System.out.println("1. Staff directory ");
                System.out.println("2. Patient directory ");
                System.out.println("3. Exit ");
                System.out.println("");
                directoryChoice = input.nextInt();
                
            }
            
            if(directoryChoice == 1){
                
                System.out.println("");
                System.out.println("1. Add a staff member ");
                System.out.println("2. Assign staff member to patient ");
                System.out.println("3. Display all staff Data ");
                System.out.println("4. Search for a staff member ");
                System.out.println("5. Remove a staff member ");
                System.out.println("6. Sort staff member by Name ");
                System.out.println("7. Export staff Data ");
                System.out.println("8. Import staff Data ");
                System.out.println("9. Exit ");
                System.out.println("");
                
                Scanner sc = new Scanner(System.in);
                System.out.print("Select an option: ");
                int choiceStaff = input.nextInt();
                
                while(choiceStaff >0 && choiceStaff <=9){
                    
                    if (choiceStaff == 1){
                        
                        // Add a new staff member
                        System.out.println("Enter the staff member's name:");
                        String name = sc.nextLine();
                        System.out.println("Enter the staff member's ID:");
                        String id = sc.nextLine(); 
                        System.out.println("Enter the staff member's position:");
                        String position = sc.nextLine();
                        hospital.addStaff(name, id, position);
                        
                        //hospital.addStaff("John Smith", "12345", "Plastic Surgeon");
                        //hospital.addStaff("Jane Joe", "67890", "Neuro Surgeon");
                        //hospital.addStaff("Bob Johnson Jr.", "09876", "Dermatologist");
                        //hospital.addStaff("Sara Lee Smith", "54321", "Radiologist");
                        //hospital.addStaff("Mike Down", "24689", "Intern");
                        
                    }
                    
                    if (choiceStaff == 2){
                        
                        System.out.println("Enter the ID of the staff member to assign to the patient:");
                        String staffId = sc.nextLine();
                        System.out.println("Enter the ID of the patient:");
                        String patientId = sc.nextLine();
                        hospital.assignStaffToPatient(staffId, patientId);
                        
                    }
                    
                    if (choiceStaff == 3){
                        
                        hospital.displayStaffData();
                        
                    }
                    
                    if (choiceStaff == 4){
                        
                        System.out.println("Enter the id of the staff member you want to find: ");
                        String id = sc.nextLine();
                        System.out.println("");
                        hospital.displayStaffInfo(id);
                    }
                    
                    if (choiceStaff == 5){
                        
                        System.out.println("Enter the id of the staff member you want to remove: ");
                        String id = sc.nextLine();
                        System.out.println("");
                        
                        sc.nextLine(); 
                        
                        System.out.println("Are you sure you want to remove this staff member? (Yes/No): ");
                        String removalPick = sc.nextLine(); 
                        
                        if(removalPick.equals("yes") || removalPick.equals("Yes")){
                            
                            hospital.removeStaffMember(id);
                        }
                        
                        else{
                            
                            System.out.println("Staff member was not removed");
                        }
                    }
                    
                    if (choiceStaff == 6){
                        
                        hospital.sortStaffName();
                        System.out.println("");
                        System.out.println("Staff members have been sorted by name ");
                        System.out.println("");
                    }
                    
                    if(choiceStaff == 7) {
                    	
                    	hospital.exportStaffData();
                    	
                    }
                    
                    if (choiceStaff == 8){
                        
                        hospital.importStaffData();
                    }
                    
                    if (choiceStaff == 9){
                        
                        System.out.println("");
                        System.out.println("Exited ");
                        System.out.println("");
                        
                        break;
                    }
                    
                    System.out.println(" ");
                    
                    System.out.println("1. Add a staff member ");
                    System.out.println("2. Assign staff member to patient ");
                    System.out.println("3. Display all staff Data ");
                    System.out.println("4. Search for a staff member ");
                    System.out.println("5. Remove a staff member ");
                    System.out.println("6. Sort staff member by Name ");
                    System.out.println("7. Export staff Data ");
                    System.out.println("8. Import staff Data ");
                    System.out.println("9. Exit ");
                    
                    System.out.println(" ");
                    
                    System.out.print("Choose a method: ");
                    choiceStaff = input.nextInt();
                }
            }
            
            if(directoryChoice == 2){
                
                System.out.println("");
                System.out.println("1. Add a patient ");
                System.out.println("2. Assign patient to a staff member ");
                System.out.println("3. Display all patient Data ");
                System.out.println("4. Search for a patient ");
                System.out.println("5. Change health status for a patient ");
                System.out.println("6. Remove a patient ");
                System.out.println("7. Sort patient by Name ");
                System.out.println("8. Export patient Data ");
                System.out.println("9. Import patient Data ");
                System.out.println("10. Exit ");
                System.out.println("");
                
                Scanner sc = new Scanner(System.in);
                System.out.print("Select an option: ");
                int choicePatient = input.nextInt();
                
                while(choicePatient >0 && choicePatient <=10){
                    
                    if (choicePatient == 1){
                        
                        Scanner sc1 = new Scanner(System.in);
                        
                        // Add a new patient
                        System.out.println("Enter the patient's name:");
                        String name = sc1.nextLine();
                        System.out.println("Enter the patient's ID:");
                        String id = sc1.nextLine();
                        sc1.nextLine();
                        System.out.println("Enter the patient's disease:");
                        String disease = sc1.nextLine();
                        System.out.println("Enter the patient's health status:");
                        String healthStatus = sc1.nextLine();
                        hospital.addPatient(name, id, disease, healthStatus);
                        
                        //hospital.addPatient("Joe Cent", "12345", "Flu", "Recovering");
                        //hospital.addPatient("Moe Jane", "67890", "Diabetes", "Stable");
                        //hospital.addPatient("Mary Joetic", "09876", "Cancer", "Critical");
                        //hospital.addPatient("Cindy Leon", "54321", "Asthma", "Stable");
                        //hospital.addPatient("Windy Smith", "24689", "Heart Disease","Recovering");
                    }
                    
                    if(choicePatient == 2){
                        
                        System.out.println("Enter the ID of the patient to assign to a staff member:");
                        String patientId = sc.nextLine();
                        System.out.println("Enter the ID of the staff member:");
                        String staffId = sc.nextLine();
                        hospital.assignPatientToStaff(patientId, staffId);
                        
                    }
                    
                    if(choicePatient == 3){
                        
                        hospital.displayPatientData();
                        
                    }
                    
                    if (choicePatient == 4){
                        
                        System.out.println("Enter the id of the patient you want to find: ");
                        String id = sc.nextLine();
                        System.out.println("");
                        hospital.displayPatientInfo(id);
                    }
                    
                    if (choicePatient == 5){
                        
                        System.out.println("Enter the id of the patient you want to remove: ");
                        String id = sc.nextLine();
                        System.out.println("");
                        
                        //sc.nextLine(); 
                        
                        System.out.println("Are you sure you want to remove this patient? (Yes/No): ");
                        String removalPick = sc.nextLine(); 
                        
                        if(removalPick.equals("yes") || removalPick.equals("Yes")){
                            
                            hospital.removePatient(id);
                        }
                        
                        else{
                            
                            System.out.println("Patient was not removed");
                        }
                    }
                    
                    if (choicePatient == 6){
                        
                        System.out.println("Enter the id of the patient you want to change the health status of: ");
                        String id = sc.nextLine();
                        System.out.println("");
                        
                        //sc.nextLine();
                        
                        System.out.println("Enter the new health status of the patient: ");
                        String healthStatus = sc.nextLine();
                        System.out.println("");
                        
                        hospital.updatePatientHealth(id, healthStatus);
                    }
                    
                    if(choicePatient == 7){
                        
                        hospital.sortPatientName();
                    }
                    
                    if(choicePatient == 8) {
                    	
                    	hospital.exportPatientData();
                    	
                    }
                    
                    if(choicePatient == 9) {
                    	
                    	hospital.importPatientData();
                    	
                    }
                    
                    
                    if (choicePatient == 10){
                        
                        System.out.println("");
                        System.out.println("Exited ");
                        System.out.println("");
                        break;
                    }
                    
                    System.out.println(" ");
                    
                    System.out.println("1. Add a patient ");
                    System.out.println("2. Assign patient to a staff member ");
                    System.out.println("3. Display all patient Data ");
                    System.out.println("4. Search for a patient ");
                    System.out.println("5. Change health status for a patient ");
                    System.out.println("6. Remove a patient ");
                    System.out.println("7. Sort patient by Name ");
                    System.out.println("8. Export patient Data ");
                    System.out.println("9. Import patient Data ");
                    System.out.println("10. Exit ");
                    
                    System.out.println(" ");
                    
                    System.out.print("Choose a method: ");
                    choicePatient = input.nextInt();  
                }
            }
            
            if (directoryChoice == 3){
                
                System.out.println("Exited ");
                menu = false;
                
            }
        }
    }
}
