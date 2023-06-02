

/**
 * Class  which is a list for nodes of Days and a list node for Diary class 
 *
 */
public class Month {
	
	private int month;
	private Month next;
	
	/**
	 * sorted linked list of days in that month ( based on day number)
	 */
	private Day head; 
	
	/**
	 * Default constructor
	 */
	public Month()
	{
		month = 0;
		next = null;
		head = null;
	}
	
	/**
	 * Alternative constructor
	 * @param newMonth of type int
	 */
	public Month(int newMonth)
	{
		month = newMonth;
		next = null;
		head = null;
	}

	/**
	 * Method to get an object reference to next Month node
	 * @return next of type Month
	 */
	public Month getNext() {
		return next;
	}

	/**
	 * Method to set an object reference to next Day node
	 * @param next of type Month
	 */
	public void setNext(Month next) {
		this.next = next;
	}

	/**
	 * Method to get a month number
	 * @return month of type int
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Method to set a month number
	 * @param month of type int
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Method to get the object reference to the head Day node
	 * @return head of type Day
	 */
	public Day getHead() {
		return head;
	}

	/**
	 * Method to set the object reference to the head Day node
	 * @param head of type Day
	 */
	public void setHead(Day head) {
		this.head = head;
	}
	
	/**
	 * Method to check if a new day has been already added
	 * @param newDay of type int
	 * @return foundDay of type Day
	 */
	 public Day findInList(int newDay)
     {
        Day marker, foundDay=null;
        
        //for loop, start at head of list; for as long as the current node is not null and search has not be found; move to next node
        for (marker = head; marker != null && foundDay == null; marker=marker.getNext())
        {
        	//if search is the same as node then they are equal
            if (newDay == marker.getDay())
            {
                foundDay = marker;
            }
        }
        return foundDay;  
     }
	 
	/**
	 * Method to add a new day to a month 
	 * @param newDay number of a day
	 * @return aDay an object reference to an added day to a list
	 */
	public Day addDay(int newDay)
	{ 
		Day aDay = new Day(newDay);
		
		//checking if a month is within the range 
    	if(newDay > 0 && newDay < 32)
    	{
			//checking if a list of days is empty or new day is earlier than head day of a list
    		if(true == isListEmpty() || newDay <= head.getDay())
        	{
    			aDay.setNext(head);
    			head = aDay;
    			return head;
        	}
    
    		//checking if a new day is later than already added days 
    		else if (newDay >= head.getDay())
    		{
    			Day current = head;
    			while(current != null)
    			{
    				if(current.getNext() == null || (current.getDay() < newDay && current.getNext().getDay() > newDay) )
    				{
    					aDay.setNext(current.getNext());
    					current.setNext(aDay);
    	        		return aDay;
    				}
    				current = current.getNext();
    			}	
    		}
    	}else
    		aDay = null;
    	return aDay;
	}	
    	
	
	/**
     * Method for checking whether the list contains any nodes(days)
     * 
     * @return boolean value 
     * true stands for list being empty 
     * false stands for list containing nodes 
     */
    public boolean isListEmpty()
    {
    	boolean empty = true;
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
     * Method to display days with appointments and appointment's details
     */
    public void displayDaysWithAppointments()
    {
    	Day current = head;
    	if(isListEmpty() != true)
    	{
    		while( current != null)
    		{
    			current.displayAppointmentsBooked();
    			current = current.getNext();
    		}
    	}
    }
    
}
