import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class  which is a list for nodes of Professionals 
 *
 */
public class Hospital {
	
	private Professional head;	
	
	/**
	 * Default constructor
	 */
	public Hospital()
	{
		head = null;
	}
	
	/**
	 * Method to get the object reference to the head Professional node
	 * @return head of type Professional
	 */
	public Professional getHead() {
		return head;
	}


	/**
	 * Method to set the object reference to the head Professional node
	 * @param head of type Professional
	 */
	public void setHead(Professional head) {
		this.head = head;
	}

	/**
	 * Method to check if a new professional has been already added according to his/her ID
	 * @param professionalID of type int
	 * @return professional object reference if it was found, if not - return null
	 */
	 public Professional findInList(int professionalID)
     {
		 Professional marker, foundOne=null;
        //start at the head of the list, for as long as the node is not null and it is not found, move to the next node
        for (marker = head; marker != null && foundOne == null; marker=marker.getNext())
        {
        	//if the search ID is the same as ID in list then the search is the node
            if (professionalID == marker.getprofessionalID())
            {
            	foundOne = marker;
            }
        }
        return foundOne;  
     }

	 /**
	  * Method to add a list node ( new professional)
	  * @param name type String 
	  * @param role type String
	  * @param professionalID type int
	  * @return professional object reference
	  */
	public Professional addProfessional(String name, String role, int professionalID)
	{ 
		Professional aProfessional = new Professional(name, role, professionalID);
		
		//if there is no identical professional ID in the list
		if(findInList(professionalID) == null)
			{
			//set professional in list
				aProfessional.setNext(head);
				head = aProfessional;
				return head;
			}
		else
			return null;
	}	
    	
	  /**
     * Method for checking whether the list contains any nodes(professionals)
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
     * Method to print the list of professionals, starting at head
     */
     public void printListOfProfessionals()
     {
        Professional marker = head;

        if (isListEmpty())
        {
        	System.out.println("The list is empty.");  
        	return;
        }
        //while the head is not null so list has nodes
        while (marker != null)
        {
        	//print node of professional and details and continue for the next node(s)
        	System.out.println(marker.displayDetails());  
	        marker=marker.getNext();
        }
    }
     
     /**
      * Method to print a list of professionals to a text file, starting at head
      */
      public void printListOfProfessionalsToFile()
      {
        //checks if list is empty
         if (isListEmpty())
         {
         	System.out.println("The list is empty.");  
         	return;
         }
         //try catch statement
         try {
         	String outputFileName;
         	//will create and write to a file called "professional.txt"
             outputFileName = "professional.txt";
             PrintWriter printWriter = null;
             FileOutputStream outputStream = null;
             outputStream = new FileOutputStream(outputFileName,true);
             printWriter = new PrintWriter(outputStream);
             Professional marker = head; 

        // while marker/head is not null
         while (marker != null)
         {
         	//String name = marker.getName();
         	String name2 = marker.displayDetails();
         	printWriter.println(name2);
         	System.out.println(marker.displayDetails());  
 	        marker=marker.getNext();
         
         }
         printWriter.close();
         }
         catch (IOException e)
         {
         	System.out.println("Error in file write: " + e);
         }
     }
      /**
       * Method to read from a file of professionals
       */
      public void readSavedFileOfProfessionals()
      {
          FileReader fileReader = null;
          BufferedReader bufferedReader = null;
           
          try
          {
        	  //using FileReader and BufferedReader to read each line in from "professional.txt"
              fileReader = new FileReader("professional.txt");
              bufferedReader = new BufferedReader(fileReader); 

              String nextLine = bufferedReader.readLine();
              
              while (nextLine != null)
              {
            	  //display the line and move to the next line
                  System.out.println(nextLine);
                  nextLine = bufferedReader.readLine();
                  
              }
              //closing the BufferedReader
              bufferedReader.close();
              //System.out.println("file read");
          }
          catch (IOException e)
          {
              System.out.println("IO Error reading from file: " + e);
          }
      }
     
     /**
      * Method to calculate how many professionals are added to the list
      * @return number of int type
      */
     public int numOfProfessional()
     {
    	 Professional nextNode;
    	 nextNode = head;
    	 int number = 0;
    	    	
    	    	while ( nextNode != null)
    	    	{
    	    		number ++;
    	    		nextNode = nextNode.getNext();
    	    	}
    	 return number;   
     }
     
     /**
 	 * Method to iterate through all appointments booked for a professional
 	 */
 	public void displayTimetableOfAppointments(int professionalID)
 	{
 		findInList(professionalID).diary();
 	}
    
 	/**
 	 * Method to delete a professional 
 	 */
 	public void deleteProfessional(Professional prof)
 	{
 		Professional nodeAfter;
 		Professional nodeBefore = null;
 		Professional current = head;
    	if (head == null)
    	{
    	     System.out.println("No professionals added");
    	}
    	//if the id of the head node is the professional to be deleted
    	else if(head.getprofessionalID() == prof.getprofessionalID())
    	{
    		//set head to the next node and delete
    		head = prof.getNext();
    		prof = null;
    	}
    	else
    	{
    		//while ID to be deleted is not the current node, keep going through list
    		while(prof.getprofessionalID() != current.getprofessionalID())
    		{
    			nodeBefore = current;
    			current = current.getNext();
    		}
    		
    	    nodeAfter = prof.getNext(); 
    	    nodeBefore.setNext(nodeAfter);
    	    prof = null;
    	}	    
 	}
}
