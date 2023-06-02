
/**
 * Class  which is a list for nodes of Months and a field for Professional class 
 *
 */
public class Diary {

	/**
	 * head node
	 */
	private Month head;
	
	/**
	 * Default constructor
	 */
	public Diary()
	{
		head = null;
	}

	/**
	 * Method to get the object reference to the head Month node
	 * @return head of type Month
	 */
	public Month getHead() {
		return head;
	}

	/**
	 * Method to set the object reference to the head Month node
	 * @param head of type Month
	 */
	public void setHead(Month head) {
		this.head = head;
	}
	
	/**
	 * Method to check if a new month has been already added
	 * @param newMonth number of a month
	 * @return foundMonth a reference of Month object
	 */
	 public Month findInList(int newMonth)
     {
        Month marker, foundMonth=null;
        
        //for loop when marker and the month are null, going through nodes to find a match
        for (marker = head; marker != null && foundMonth == null; marker=marker.getNext())
        {
            if (newMonth == marker.getMonth())
            {
            	foundMonth = marker;
            }
        }
        return foundMonth;  
     }
	 
	/**
	 * Method to add a new month to a diary
	 * @param newMonth number of a month
	 * @return aMonth a reference of Month object
	 */
	public Month addMonth(int newMonth)
	{
		Month aMonth = new Month(newMonth);
		
		//checking if a month is within range 
    	if(newMonth > 0 && newMonth < 13)
    	{
			//checking if list of months is empty or new month is earlier than head month of a list
    		if(true == isListEmpty() || newMonth <= head.getMonth())
        	{
    			aMonth.setNext(head);
    			head = aMonth;
    			return head;
        	}
    		//checking if new month is later than already added months 
	    	else if (newMonth >= head.getMonth())
	    		{
	    			Month current = head;
	    			//while current is not null
	    			while(current != null)
	    			{
	    				//if there is no next node or current month is less than new month and the next month is bigger than the new month
	    				//set month
	    				if(current.getNext() == null || (current.getMonth() < newMonth && current.getNext().getMonth() > newMonth) )
	    				{
	    					aMonth.setNext(current.getNext());
	    					current.setNext(aMonth);
	    	        		return aMonth;
	    				}
	    				current = current.getNext();
	    			}	
	    		}
    	}else
    		aMonth = null;
    	return aMonth;
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
    	//list is empty when head is null
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
     * Method to iterate through months that have appointments
     */
    public void displayMonthsWithAppointments()
    {
    	Month current = head;
    	
    	 // if the list is empty then there are no appointments
    	 
    	if(isListEmpty() == true)
    		System.out.println("No appointments");
    	else
    	{
    		 while(current != null)
    		 {
    			 //show the user days with appointments
    			 current.displayDaysWithAppointments();
    			 System.out.println(" ");
    			 //move to next node
    			 current = current.getNext();
    		 }
    	}
    }
}
