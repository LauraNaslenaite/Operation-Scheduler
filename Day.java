import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Class which is a list for nodes of Appointments and a list node for Month class 
 * 
 *
 */
public class Day {

	private int day;
	private Appointment head;
	private Day next;
	
	/**
	 * creating a set of integers for free time and working time
	 */
	private Set<Integer> freeTime;
	private Set<Integer> workingTime;
	/**
	 * Default constructor
	 */
	public Day()
	{
		day = 0;
		head = null;
		next = null;
		freeTime = new LinkedHashSet<Integer>();
		workingTime = new LinkedHashSet<Integer>();
	}
	
	/**
	 * Alternative constructor
	 * @param newDay  of int type
	 */
	public Day(int newDay)
	{
		day = newDay;
		head = null;
		next = null;
		freeTime = new LinkedHashSet<Integer>();
		workingTime = new LinkedHashSet<Integer>();

	}
	
	/**
	 * Method to get an object reference to next Day node
	 * @return next of type Day
	 */
	public Day getNext() {
		return next;
	}

	/**
	 * Method to set an object reference to next Day node
	 * @param next of type Day
	 */
	public void setNext(Day next) {
		this.next = next;
	}

	/**
	 * Method to get a day number
	 * @return day of type int 
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Method to set a day number
	 * @param day of type int 
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * Method to get the object reference to the head Appointment node
	 * @return head of type Appointment
	 */
	public Appointment getHead() {
		return head;
	}

	/**
	 * Method to set the object reference to the head Appointment node
	 * @param head of type Appointment
	 */
	public void setHead(Appointment head) {
		this.head = head;
	}
	
	/**
	 * Method to get a set of free time slots on a specific day
	 * @return freeTime of type Set which holds double 
	 */
	public Set<Integer> getFreeTime() {
		return freeTime;
	}

	/**
	 * Method to set a set of free time slots on a specific day
	 * @param freeTime of type Set which holds double
	 */
	public void setFreeTime(Set<Integer> freeTime) {
		this.freeTime = freeTime;
	}

	/**
	 * Method to get a set of booked appointment time slots on a specific day
	 * @return workingTime of type Set which holds double
	 */
	public Set<Integer> getWorkingTime() {
		return workingTime;
	}

	/**
	 * Method to set a set of booked appointment time slots on a specific day
	 * @param workingTime of type Set which holds double
	 */
	public void setWorkingTime(Set<Integer> workingTime) {
		this.workingTime = workingTime;
	}

	/**
	 * Method to set a start and end time of a new appointment to a specific list node(=day)
	 * @param newStartTime of type double
	 * @param newEndTime of type double
	 * @return aAppointment of type Appointment which has only start and end times arranged
	 */
	public Appointment addAppointmentTime(double newStartTime, double newEndTime)
    {
    	Appointment aAppointment;
    	aAppointment = new Appointment(newStartTime, newEndTime);
    	
    	//checking if appointment time is within the range of specialists' working time
    	//which is 8-19, if not appointment cannot be added and method returns false
    	if(newStartTime>=8.00 && newEndTime<=19.00)
    	{
    		if(true == isListEmpty())
        	{
    			aAppointment.setNext(head);
    			head = aAppointment;
        	}
    		else
    		{
    			//List is not empty
    			//checking if a new appointment has an earlier time slot than the very first
    			//appointment (=head)
    			if(newEndTime <= head.getStartTime())
    			{
    				aAppointment.setNext(head);
        			head = aAppointment;
    				return head;
    			}
    			//checking if the list contains only one appointment(=head) and if a new appointment 
    			// is later than head appointment
    			else if( head.getNext() == null && head.getEndTime() <= newStartTime)
    			{
    				head.setNext(aAppointment);
    				return aAppointment;
    			}
    			//checking if a new appointment is later than the current appointment and earlier 
    			//than the current's next appointment
    			else if (newStartTime >= head.getEndTime())
    			{
    				Appointment current = head;
    				
    				while(current != null)
    				{
    					if(current.getNext() == null)
    					{
    						if(current.getEndTime() <= newStartTime)
    						{
    							aAppointment.setNext(current.getNext());
        						current.setNext(aAppointment);
        						return aAppointment;
    						}
    					}
    					else
    					{
    						if(current.getEndTime() <= newStartTime && newEndTime  <= current.getNext().getStartTime() )
    						{
	    						aAppointment.setNext(current.getNext());
	    						current.setNext(aAppointment);
        						return aAppointment;

    						}
    					}
    					current = current.getNext();
    				}
    				aAppointment = null;
    			}
    			else
    				aAppointment = null;    				
    		}
    			
    	}else
    		aAppointment = null;
    	return aAppointment;
    }
	
	/**
	 * Method to set patient details of a new appointment of a specific list node(=day)
	 * @param appointmentWithTime of type Appointment
	 * @param newAppointmentID of type int
	 * @param newPatientName of type String
	 * @param newPatientSurname of type String
	 * @param newAppointmentType of type String
	 * @param newNumOfProfessionals
	 * @param newLocation of type String
	 * @param newDescription of type String
	 * @param newPatientsBirthYear of type int
	 * @return appointmentWithTime of type Appointment which has  full information for an appointment
	 */
	public Appointment addAppoinment(Appointment appointmentWithTime,int newMonthNum, int newDayNum,int newAppointmentID, 
			 String newPatientName, String newPatientSurname, String newAppointmentType,
			 int newNumOfProfessionals, String newLocation, String newDescription, int newPatientsBirthYear, int newProfessionalID)
	{
		if(appointmentWithTime != null)
		{
			if(numofApp() == 1 || numofApp() > 2)
				appointmentWithTime.setDetailsForApp(newMonthNum,newDayNum,newAppointmentID, newPatientName, newPatientSurname, newAppointmentType, newNumOfProfessionals, newLocation, newDescription, newPatientsBirthYear,newProfessionalID);
			else if(numofApp() == 2)
			{
				Appointment anApp = head.getNext();
				if(anApp.getStartTime() == appointmentWithTime.getStartTime())
					appointmentWithTime = anApp;
				appointmentWithTime.setDetailsForApp(newMonthNum,newDayNum,newAppointmentID, newPatientName, newPatientSurname, newAppointmentType, newNumOfProfessionals, newLocation, newDescription, newPatientsBirthYear,newProfessionalID);
			}
			return appointmentWithTime;
		}
		else
			return null;
	}
	
	/**
     * Method for checking whether the list contains any nodes(appointments)
     * 
     * @return boolean value 
     * true stands for list being empty 
     * false stands for list containing nodes 
     */
    public boolean isListEmpty()
    {
    	boolean empty = true;
    	/**
    	 * the list is empty if the head is null
    	 */
    	if( head == null )
    		{
    			empty = true;
    		}
    	else
    		{
    			empty = false;
    		}
    	return empty;
    }
    /**
     * Method to find free time in a day
     * @return copy_set_freeTime of type Set that holds double
     */
    public Set<Integer> identifyingFreeTime()
    {
    	/**
    	 * call settingFreeTime method to add the times of the day to create a timetable
    	 */
    	settingFreeTime();
    	
    	if(isListEmpty() == true)
    	{
    		return freeTime;
    	}
    	else
    	{
    		settingWorkingHours();
    		//the copy of freeTime set is compared with workingTime set
    		//during removeAll method, after which all common elements of both sets are removed
    		//from the former set
    		Set<Integer> copy_set_freeTime = new HashSet<Integer>(freeTime);
    		copy_set_freeTime.removeAll(workingTime);
    		
    		Set<Integer> copy_set_freeTime2 = new HashSet<Integer>(copy_set_freeTime);
    		Set<Integer> orderedTime = new LinkedHashSet<Integer>();
    		for (int j = 8; j<=19; j++)
    		{
    			copy_set_freeTime2.add(j);
    			if(copy_set_freeTime2.size() == copy_set_freeTime.size())
    				orderedTime.add(j);
    			else
    				copy_set_freeTime2.remove(j);
    		}
    		
    		return orderedTime;
    	}
    }
    
    /**
     * Method to create a set of all appointments of that day
     */
    public void settingWorkingHours()
    {
    	Appointment current = head;
    	while ( current != null)
    	{
    		//get start and end times 
    		int start = (int)current.getStartTime() ;
    		int end = (int)current.getEndTime() ;
    		
    		if(current.getEndTime() > end)
    			end =+ 1;
    		int num = 0;
    		if(start != 8)
    			num=start + 1;
    		else
    			num=start;
    		
    		//so that 19 hour could not be shown 
    		if(end == 19)
    		{
	    		for(int i = num; i <= end; i++)
	        	{
	        		workingTime.add(i);
	        	}
    		}
    		else
    		{
	    		for(int i = num; i < end; i++)
	        	{
	        		workingTime.add(i);
	        	}
    		}
    		current = current.getNext();
    	}
    }
    
    /**
     * Method to fill a set with free hours
     */
    public void settingFreeTime()
    {
    	//working time from 8-19, making a day free of appointments first
    	for(int i = 8; i <20; i++)
    	{
    		freeTime.add(i);
    	}
    }
    /**
     * Method to iterate through booked appointments on a specific day 
     */
    public void displayAppointmentsBooked()
    {
    	Appointment current = head;
    	//if the list is not empty
    	if(isListEmpty() == false)
    	{
    		//while current is not null, display the appointment and call getNext method
    		while(current != null)
    		{
    			current.displayAppointmentDetails();
    			current = current.getNext();
    		}
    	}
    }
    
    /**
     * Method to delete an appointment
     */
    public void deleteAppointment(Appointment appToDelete)
    {
    	Appointment nodeAfter;
    	Appointment nodeBefore = null;
    	Appointment current = head;
    	
    	// if the head is null then there are no appointments
    	if (head == null)
    	{
    	     System.out.println("No appointments added");
    	}
    	
    	// else if the node that is to be deleted is the head, change the head to the next node
    	else if(head.getStartTime() == appToDelete.getStartTime())
    	{
    		head = appToDelete.getNext();
    		appToDelete = null;
    		settingWorkingHours();
    	}
    	else
    	{
    		//searching for node to be deleted
    		while(appToDelete.getStartTime() != current.getStartTime())
    		{
    			nodeBefore = current;
    			current = current.getNext();
    		}
    		
    	    nodeAfter = appToDelete.getNext(); 
    	    nodeBefore.setNext(nodeAfter);
    	    appToDelete = null;
    	    settingWorkingHours();
    	}	    
    }
    /**
     * Method to count how many appointments are added to the list
     * @return number of int type
     */
    public int numofApp()
    {
   	 Appointment nextNode;
   	 nextNode = head;
   	 int number = 0;
   	    	//while the next node is not null, add 1 to number field and move to the next node
   	    	while ( nextNode != null)
   	    	{
   	    		number ++;
   	    		nextNode = nextNode.getNext();
   	    	}
   	 return number;   
    }   
}