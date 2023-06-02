
/**
 * Class which holds information on a list node ( appointment)
 *
 */
public class Appointment {
	
/**
 * fields for holding all details about an appointment
 */
	private int dayNum;
	private int monthNum;
	private int appointmentID;
	private double startTime;
	private double endTime;
	private String patientName;
	private String patientSurname;
	private String appointmentType;
	private int numOfProfessionals;
	private String location;
	private String description;
	private Appointment next;
	private int patientsBirthYear;
	private int professionalID;
	
	/**
	 * Default constructor
	 */
	public Appointment()
	{
		dayNum = 0;
		monthNum = 0;
		appointmentID = 0;
		startTime = 0.00;
		endTime = 0.00;
		patientName = "unknown";
		patientSurname = "unknown";
		patientsBirthYear = 0;
		appointmentType = "unknown";
		numOfProfessionals = 0;
		location = "unknown";
		description = "unknown";
		professionalID = 0;
		next = null;
	}
	
	/**
	 * Alternative constructor with date parameters and patient information
	 * @param newMonthNum int type
	 * @param newDayNum int type
	 * @param newAppointmentID int type
	 * @param newStartTime double type
	 * @param newEndTime double type
	 * @param newPatientName String type
	 * @param newPatientSurname String type
	 * @param newAppointmentType String type
	 * @param newNumOfProfessionals int type
	 * @param newLocation String type
	 * @param newDescription String type
	 * @param newPatientsBirthYear int type
	 */
	public Appointment(int newMonthNum, int newDayNum, int newAppointmentID, double newStartTime, double newEndTime, 
			 String newPatientName, String newPatientSurname, String newAppointmentType,
			 int newNumOfProfessionals, String newLocation, String newDescription, int newPatientsBirthYear, int newProfessionalID)
	{
		dayNum =  newDayNum;
		monthNum =  newMonthNum;
		appointmentID = newAppointmentID;
		startTime = newStartTime;
		endTime = newEndTime;
		patientName = newPatientName;
		patientSurname = newPatientSurname;
		patientsBirthYear = newPatientsBirthYear;
		appointmentType = newAppointmentType;
		numOfProfessionals = newNumOfProfessionals;
		location = newLocation;
		description = newDescription;
		professionalID = newProfessionalID;
		next = null;
	}
	
	/**
	 * Alternative constructor with date parameters only
	 * @param newStartTime double type
	 * @param newEndTime double type
	 */
	public Appointment(double newStartTime, double newEndTime)
	{
		monthNum = 1;
		dayNum = 1;
		appointmentID = 1;
		startTime = newStartTime;
		endTime = newEndTime;
		patientName = "unknown";
		patientSurname = "unknown";
		patientsBirthYear = 1;
		appointmentType = "unknown";
		numOfProfessionals = 1;
		location = "unknown";
		description = "unknown";
		professionalID = 0;
		next = null;
	}
	
	/**
	 * Method to get a day number of an appointment
	 * @return dayNum of type int
	 */
	public int getDayNum() {
		return dayNum;
	}
	
	/**
	 * Method to set a day number of an appointment
	 * @param dayNum of type int
	 */
	public void setDayNum(int dayNum) {
		this.dayNum = dayNum;
	}

	/**
	 * Method to get a month number of an appointment
	 * @return monthNum of type int
	 */
	public int getMonthNum() {
		return monthNum;
	}
	
	/**
	 * Method to set a month number of an appointment
	 * @param monthNum of type int
	 */
	public void setMonthNum(int monthNum) {
		this.monthNum = monthNum;
	}

	/**
	 * Method to get a reference to next Appointment node
	 * @return next of Appointment type
	 */
	public Appointment getNext() {
		return next;
	}

	/**
	 * Method to set a reference to next Appointment node
	 * @param next of Appointment type
	 */
	public void setNext(Appointment next) {
		this.next = next;
	}

	/**
	 * Method to get a birth year of a patient
	 * @return patientsBirthYear of type int
	 */
	public int getPatientsBirthYear() {
		return patientsBirthYear;
	}

	/**
	 * Method to set a birth year of a patient
	 * @param patientsBirthYear of type int
	 */
	public void setPatientsBirthYear(int patientsBirthYear) {
		this.patientsBirthYear = patientsBirthYear;
	}

	/**
	 * Method to get an appointment ID
	 * @return appointmentID of type int
	 */
	public int getAppointmentID() {
		return appointmentID;
	}
	
	/**
	 * Method to set an appointment ID
	 * @param appointmentID of type int
	 */
	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}
	
	/**
	 * Method to get a start time of an appointment 
	 * @return startTime of type double
	 */
	public double getStartTime() {
		return startTime;
	}
	
	/**
	 * Method to set a start time of an appointment 
	 * @param startTime of type double
	 */
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * Method to get an end time of an appointment 
	 * @return endTime of type double
	 */
	public double getEndTime() {
		return endTime;
	}
	
	/**
	 * Method to set an end time of an appointment
	 * @param endTime of type double
	 */
	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * Method to get a name of a patient
	 * @return patientName of type String
	 */
	public String getPatientName() {
		return patientName;
	}
	
	/**
	 * Method to set a name of a patient
	 * @param patientName of type String
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	/**
	 * Method to get a surname of a patient
	 * @return patientSurname of type String
	 */
	public String getPatientSurname() {
		return patientSurname;
	}
	
	/**
	 * Method to set a surname of a patient
	 * @param patientSurname of type String
	 */
	public void setPatientSurname(String patientSurname) {
		this.patientSurname = patientSurname;
	}
	
	/**
	 * Method to get a type of an appointment
	 * @return appointmentType of type String
	 */
	public String getAppointmentType() {
		return appointmentType;
	}
	
	/**
	 * Method to set a type of an appointment
	 * @param appointmentType of type String
	 */
	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}
	
	/**
	 * Method to get a number of professionals for an appointment
	 * @return numOfProfessionals of type int
	 */
	public int getNumOfProfessionals() {
		return numOfProfessionals;
	}
	
	/**
	 * Method to set a number of professionals for an appointment
	 * @param numOfProfessionals of type int
	 */
	public void setNumOfProfessionals(int numOfProfessionals) {
		this.numOfProfessionals = numOfProfessionals;
	}
	
	/**
	 * Method to get a location for an appointment
	 * @return location of type String
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Method to set a location for an appointment
	 * @param location of type String
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Method to get a description for an appointment
	 * @return description of type String
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Method to set a description for an appointment
	 * @param description of type String
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Method to get a profession ID for an appointment
	 * @return
	 */
	public int getProfessionalID() {
		return professionalID;
	}

	/**
	 * Method to set a professional ID for an appointment
	 * @param professionalID
	 */
	public void setProfessionalID(int professionalID) {
		this.professionalID = professionalID;
	}

	/**
     * Method to display the details of appointment
     */
    public void displayAppointmentDetails()
    {
    	System.out.println("Month " + monthNum);
    	System.out.println("Day " + dayNum);
    	System.out.println("Appointment ID " + appointmentID);
    	System.out.println("Start time " + startTime);
    	System.out.println("End time " + endTime);
    	System.out.println("Patient "+patientName+" "+patientSurname);
    	System.out.println("Birth Year " + patientsBirthYear);
    	System.out.println("Appointment Type " + appointmentType);
    	System.out.println("Location " + location);
    	System.out.println("Description " + description);
    	System.out.println("Number of specialist " + numOfProfessionals);
    	
    }
    
    /**
     * Method to set details of appointment at once
     * @param newAppointmentID int type
     * @param newPatientName String type
     * @param newPatientSurname String type
     * @param newAppointmentType String type
     * @param newNumOfProfessionals int type
     * @param newLocation String type
     * @param newDescription String type
     * @param newPatientsBirthYear int type
     */
    public void setDetailsForApp(int newMonthNum, int newDayNum,int newAppointmentID, 
			 String newPatientName, String newPatientSurname, String newAppointmentType,
			 int newNumOfProfessionals, String newLocation, String newDescription, int newPatientsBirthYear, int newProfessionalID)
    {
    	monthNum = newMonthNum;
    	dayNum = newDayNum;
    	appointmentID = newAppointmentID;
		patientName = newPatientName;
		patientSurname = newPatientSurname;
		patientsBirthYear = newPatientsBirthYear;
		appointmentType = newAppointmentType;
		numOfProfessionals = newNumOfProfessionals;
		professionalID = newProfessionalID;
		location = newLocation;
		description = newDescription;
    }
}
