package hosPatelDirectory;

class Staff extends Inheritance{
    
    private String name;
    private String id;
    private String position;
    private Patient patient;

    // constructor for Staff class
    public Staff(String name, String id, String position) {
        
        super(name, id);
        this.position = position;
    }
    
    public String getPosition() { 
        
        return position; 
        
    }
    
    // method to get patient for the staff member
    public void setPatient(Patient patient) {
       
        this.patient = patient;
        
    }
    
    public void seePatient() {
        
        // use the patient object
        System.out.println(getName() + " is seeing " + patient.getName() + " who has: " + patient.getDisease());
    }
    
    public String toString(){
	    
    	return getName() +", "+ getId() +", "+ position;
	}
}
