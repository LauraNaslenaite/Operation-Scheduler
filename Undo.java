import java.util.*;

/**
* stack collection class
*/
public class Undo {
	
	/**
	 * creating stacks for appointments and professionals
	 */
	private Stack<Appointment> undoApp;
	private Stack<Professional> undoProf;
	
	
	
	public Undo()
	{
		/**
		 * instances of the stack
		 */
		undoApp = new Stack<Appointment>();
		undoProf = new Stack<Professional>();
	}
	
	/**
	 * Method to add an element to a stack
	 */
	public Appointment addToStack(Appointment appoint)
	{
		return undoApp.push(appoint);
	}
	
	/**
	 * Method to remove an appointment from stack
	 * @return appointment object reference
	 */
	public Appointment undoApp()
	{
		/**
		 * if stack is empty then undo cannot be done
		 */
		if(undoApp.empty() == true)
		{
			System.out.println("Undo method is not possible");
			return null;
		}
		else
		{
			/**
			 * pop element of the appointment stack
			 */
			return undoApp.pop();		
		}
	}
	
	/**
	 * Method to add an element to a stack ( professional object)
	 */
	public Professional addToStack(Professional prof)
	{
		return undoProf.push(prof);
	}
	
	/**
	 * Method to remove a professional from stack
	 * @return 
	 */
	public Professional undoProf()
	{
		/**
		 * undo cannot be done with an empty stack
		 */
		if(undoProf.empty() == true)
		{
			System.out.println("Undo method is not possible");
			return null;
		}
		else
		{
			/**
			 * pop element
			 */
			return undoProf.pop();		
		}
	}
	
	/**
	 * Method to clear appointment stack
	 */
	public void clearAppStack()
	{
		undoApp.clear();
	}
	
	/**
	 * method to clear professional stack
	 */
	public void clearProfStack()
	{
		undoProf.clear();
	}
	
	/**
	 * Method to check if appointment stack is empty
	 */
	public boolean isAppStackEmpty()
	{
		return undoApp.empty();
	}
	/**
	 * method to check if professional stack is empty
	 * @return
	 */
	public boolean isProfStackEmpty()
	{
		return undoProf.empty();
	}
	/**
	 * method to get undoApp
	 * @return
	 */
	public Stack<Appointment> getUndoApp() {
		return undoApp;
	}
	/**
	 * method to set undoApp
	 * @param undoApp
	 */
	public void setUndoApp(Stack<Appointment> undoApp) {
		this.undoApp = undoApp;
	}
	/**
	 * method to get undoProf
	 * @return
	 */
	public Stack<Professional> getUndoProf() {
		return undoProf;
	}
	/**
	 * method to set undoProf
	 * @param undoProf
	 */
	public void setUndoProf(Stack<Professional> undoProf) {
		this.undoProf = undoProf;
	}
}