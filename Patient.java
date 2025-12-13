package hosPatelDirectory;

class Patient extends Inheritance {
    
    private String name;
    private String id;
    private String disease;
    private Staff staff;
    private String healthStatus;

    // constructor for Patient class
    public Patient(String name, String id, String disease, String healthStatus) {
        
        super(name, id);
        this.disease = disease;
        this.healthStatus = healthStatus;
        
    }
    
    // method to get the health status
    public String getHealthStatus() { 
        
        return healthStatus; 
        
    }
    
    // method to update health status
    public void setHealthStatus(String healthStatus) {
        
        this.healthStatus = healthStatus;
        
    }
    
    // method to get the patient's disease
    public String getDisease() { 
        
        return disease; 
        
    }
    
    // method to get staff member responsible for the patient
    public void setStaff(Staff staff) {
       
        this.staff = staff;
        
    }
    
    public void seeStaff() {
        
        // use the staff object 
        System.out.println(getName() + " is seeing " + staff.getName() + " who is a " + staff.getPosition());
    }
    
    public String toString(){
	    
    	return getName() + ", " + getId() + ", " + disease + ", " + healthStatus;
	}
}
