import java.util.Set;

/**
 * Class which initialises a Professional object and is a list node for Hospital class
 */
public class Professional {

	/**
	 * fields which will hold details about a professional
	 */
	private String name;
	private String role;
	private int professionalID;
	private Diary diary;
	private Professional next;
	private Day aDay;

	/**
	 * Default constructor
	 */
	public Professional()
	{
		name = "unknown";
		role = "unknown";
		professionalID = 0;
		diary = new Diary();
		aDay = new Day();
		next = null;
	}
	
	/**
	 * Alternative constructor
	 * @param newName of type String
	 * @param newRole of type String
	 * @param newProfessionalID of type int
	 */
	public Professional(String newName, String newRole, int newProfessionalID)
	{
		name = newName;
		role = newRole;
		professionalID = newProfessionalID;
		diary = new Diary();
		aDay = new Day();
		next = null;
	}
	
	/**
	 * Method to get a certain day in order to call methods of its class
	 * @return aDay of type Day
	 */
	public Day getaDay() {
		return aDay;
	}

	/**
	 * Method to set a certain day in order to call methods of its class
	 * @param aDay of type Day
	 */
	public void setaDay(Day aDay) {
		this.aDay = aDay;
	}

	/**
	 * Method to get an object reference to next Professional node
	 * @return next of type Professional
	 */
	public Professional getNext() {
		return next;
	}

	/**
	 * Method to set an object reference to next Professional node
	 * @param next of type Professional
	 */
	public void setNext(Professional next) {
		this.next = next;
	}

	/**
	 * Method to get a name of a professional
	 * @return name of type String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to set a name of professional
	 * @param name of type String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method to get a role of a professional
	 * @return role of type String
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Method to set a role of a professional
	 * @param role of type String
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Method to get an ID of a professional
	 * @return professionalID of type int
	 */
	public int getprofessionalID() {
		return professionalID;
	}

	/**
	 * Method to set an ID of a professional
	 * @param professionalID of type int
	 */
	public void setprofessionalID(int professionalID) {
		this.professionalID = professionalID;
	}

	/**
	 * Method to get the reference to Diary object 
	 * @return diary of type Diary
	 */
	public Diary getDiary() {
		return diary;
	}

	/**
	 * Method to set the reference to Diary object
	 * @param diary of type Diary
	 */
	public void setDiary(Diary diary) {
		this.diary = diary;
	}

	/**
	 * Method to add a new entry to a diary(only new month and a new day)
	 * @param monthNum number of a month of type int
	 * @param dayNum number of a day of type int
	 * @param newStartTime number of a start time of type double
	 * @param newEndTime number of an end time of type double
	 */
	public Appointment addingFullDateToDiary(int monthNum, int dayNum, double newStartTime, double newEndTime)
	{
		//instances of Month and Appointment classes
		Month aMonth = new Month();		
		Appointment aAppointment= new Appointment();		
		
		//if
		if(addingMonth(monthNum) != null)
		{
			aMonth = addingMonth(monthNum);
			if(addingDay(aMonth, dayNum) != null)
			{
				aDay = addingDay(aMonth, dayNum);
				
				aAppointment = addingDayTime(aDay, newStartTime, newEndTime);
				return aAppointment;
			}else
			{
				return null;
			}
		}else
		{
			return null;
		}
	}
	
	/**
	 * Method of checking whether a month object based on its number already exists
	 * If it does not, a new month is created
	 * It it does, an object of already existing month is returned
	 * @param month type int
	 * @return newMonth
	 * 					If a month object of particular number does not exist, a new month object is created and returned
	 * 					It a month object of particular number exists, an object of already existing month is returned
	 */
	public Month addingMonth(int month)
	{
		Month newMonth = new Month(month);
		if(diary.findInList(month) == null)
		{	
			if(diary.addMonth(month) != null)
			{
				return newMonth;
			}	
			else
				return null;
		}
		else
			return diary.findInList(month);
	}
	
	/**
	 * Method of checking whether a day object based on its number already exists
	 * @param newMonth type Month ( to call methods of its class)
	 * @param day type int
	 * @return newDay
	 * 					If a day object of particular number does not exist, a new day object is created and returned
	 * 					It a day object of particular number exists, an object of already existing day is returned
	 */
	public Day addingDay(Month newMonth, int day)
	{
		Day newDay = new Day(day);

		if(newMonth.findInList(day) == null)
		{	
			if(newMonth.addDay(day) != null)
				return newDay;
			else
				return null;
		}
		else
			return newMonth.findInList(day);
	}
	
	/**
	 * Method to add start and end type for an appointment
	 * @param newDay type Day ( to call its methods)
	 * @param newStartTime type double
	 * @param newEndTime type double
	 * @return newApp ( if it is null , appointment cannot be added)
	 */
	public Appointment addingDayTime(Day newDay, double newStartTime, double newEndTime)
	{
		Appointment newApp = newDay.addAppointmentTime(newStartTime, newEndTime);
		return newApp;
	}
	
	/**
	 * Method to add full patient information ( excluding date and time)
	 * @param anApp type Appointment
	 * @param newAppointmentID of type int 
	 * @param newPatientName of type String
	 * @param newPatientSurname of type String
	 * @param newAppointmentType of type String
	 * @param newNumOfProfessionals of type int 
	 * @param newLocation of type String
	 * @param newDescription of type String
	 * @param newPatientsBirthYear of type int 
	 * @return appointment object reference with both time and patient data 
	 */
	public Appointment addingFullAppointentDetailsToDiary(Appointment anApp,int newMonthNum, int newDayNum, int newAppointmentID, 
											String newPatientName, String newPatientSurname, String newAppointmentType,
											int newNumOfProfessionals, String newLocation, String newDescription, int newPatientsBirthYear)
	{
		 return aDay.addAppoinment(anApp,newMonthNum,newDayNum, newAppointmentID,newPatientName, newPatientSurname, newAppointmentType,
			 newNumOfProfessionals, newLocation, newDescription, newPatientsBirthYear, professionalID);
	}
	
	/**
	 * Method to display details of a professional
	 * @return info of type String
	 */
	public String displayDetails()
	{
		String info = "ID " + professionalID + " \t" + name + "\t" + role;
		return info;
	}
	
	/**
	 * Method to check whether a certain month is already added to a diary
	 * @param month month number of type int
	 * @return boolean true - added/ false - not added
	 */
	public boolean isMonthAdded(int month)
	{
		if(diary.findInList(month) == null)
		{	
			return false;
		}
		else
			return true;	
	}
	
	/**
	 * Method to check whether a certain day is already added to a diary
	 * @param newMonth type Month( to call methods from its class)
	 * @param day number of type int
	 * @return boolean true - added/ false - not added
	 */
	public boolean isDayAdded(Month newMonth, int day)
	{
		if(newMonth.findInList(day) == null)
		{	
			return false;
		}
		else
			return true;
	}
	
	/**
	 * Method to get free time slots of a specialist in a particular month on a particular day
	 * @param monthNum of type int
	 * @param dayNum of type int
	 * @return set of integers with indicates time slots that are not booked for a certain specialist
	 */
	 public Set<Integer> freeTime(int monthNum, int dayNum)
	 {
	 	Month aMonth = new Month();
	 	Day aDay = new Day();
	 	if(isMonthAdded(monthNum) == true)
	 	{
	 		aMonth = addingMonth(monthNum);
	 		if(isDayAdded(aMonth, dayNum) == true) //if month and day was already added
	 		{
	 			aDay = addingDay(aMonth, dayNum);
	 			//returning a set that is influenced by working hours
	 			return aDay.identifyingFreeTime(); 
	 		}
	 		else
	 		{
	 			// returning a set that contains hours from 8-19
	 			return aDay.identifyingFreeTime(); 
	 		}
	 	}else
	 	{
	 		// returning a set that contains hours from 8-19
	 		return aDay.identifyingFreeTime();
	 	}
	 }
	
	/**
	 * Method to iterate through all appointments booked for a professional
	 */
	public void diary()
	{
		diary.displayMonthsWithAppointments();
	}
}