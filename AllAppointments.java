import java.util.ArrayList;

/**
 *  A class to store all appointments in a joint list 
 *
 */
public class AllAppointments {
	
/**
 * creating an array list from collection class
 */

 	private  ArrayList<Appointment> list;
 

	public AllAppointments()
	{
		list = new ArrayList<Appointment>();
	}
	
	/**
	 * Method to add an appointment to a list
	 */
	public void addAppointmentToJointList(Appointment newApp)
	{
		list.add(newApp);
	}
	
	/**
	 * Method to get a reference number of an  appointment
	 */
	public int referenceNumber(Appointment newApp)
	{
		int referenceNum = 0;
		int arraySize = list.size();
		if(arraySize != 0)
			referenceNum = arraySize - 1;
		else
			referenceNum = arraySize;
		return referenceNum;
	}
	
	/**
	 * Method to check if an appointment exists
	 */
	public Appointment exist(int num)
	{
		//if the size of the list(-1) is less than num
		if((list.size()-1) < num)
			return null;
		else
			//get the num
			return list.get(num);
	}
	
	/**
	 * Method to get a size of a list
	 */
	public int size()
	{
		return list.size();
	}
	
	/**
	 * method that clears the list
	 */
	public void clear()
	{
		list.clear();
	}
	
	/**
	 * method that gets list
	 * @return
	 */
	public ArrayList<Appointment> getList() {
		return list;
	}
	/**
	 * method that sets list
	 * @param list
	 */
	public void setList(ArrayList<Appointment> list) {
		this.list = list;
	}
}
