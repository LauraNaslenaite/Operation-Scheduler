import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Main class of the package
 * @author 
 *
 */
public class Tester {

	private Hospital GreySloanMemorialHospital;
	private AllAppointments list;
	private Undo undo;
	
	/**
	 * Default constructor
	 */
	public Tester()
	{
		GreySloanMemorialHospital = new Hospital();
		list = new AllAppointments();
		undo = new Undo();
	}
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tester myTest = new Tester();
		myTest.menu();
		
	}
	
	/**
	 * Method to run automated tests
	 */
	public void runAutomatedTests()
	{
		// print empty list of professionals
		GreySloanMemorialHospital.printListOfProfessionals();
				
		//add new professionals 
		Professional prof1 = GreySloanMemorialHospital.addProfessional("Jim", "Doctor", 1);
		Professional prof2 = GreySloanMemorialHospital.addProfessional("Kai", "Nurse", 2);
		
		//print empty list of professionals
		GreySloanMemorialHospital.printListOfProfessionals();
		
		//add a professional with the same ID
		GreySloanMemorialHospital.addProfessional("Sara", "Doctor", 1);
		
		
		//find a professional based on ID
		if(GreySloanMemorialHospital.findInList(1) != null)
			System.out.println("Professional was found");
		else
			System.out.println("Professional was not found");
		
		if(GreySloanMemorialHospital.findInList(13) != null)
			System.out.println("Professional was found");
		else
			System.out.println("Professional was not found");
		
		System.out.println("----------------------------------");
		
		//adding an appointment
		Professional aProf = GreySloanMemorialHospital.findInList(1);
		Appointment anApp = aProf.addingFullDateToDiary(2,3,12.30,14);
		if(anApp != null)
		{
			aProf.addingFullAppointentDetailsToDiary(anApp,2,3,1,"Laura","Nas", "Blood Test",1, "None", "None", 2020);
			System.out.println("Appointment was added");
		}
		else
			System.out.println("Appointment was not added");
	
		
		//adding an appointment with non -existent month
		Appointment anApp1 = aProf.addingFullDateToDiary(15,3,12.30,14);
		if( anApp1 != null)
			{
				aProf.addingFullAppointentDetailsToDiary(anApp1,15,3,1,"Laura","Nas", "Blood Test",1, "None", "None", 2020);
				System.out.println("Appointment was added");
			}
		else
			System.out.println("Appointment was not added");
		
		//adding an appointment with non -existent day
		Appointment anApp2 =aProf.addingFullDateToDiary(2,45,12.30,14);
		if(anApp2 != null)
		{
			aProf.addingFullAppointentDetailsToDiary(anApp2,2,45,1,"Laura","Nas", "Blood Test",1, "None", "None", 2020);
			System.out.println("Appointment was added");
		}
		else
			System.out.println("Appointment was not added");
		
		//adding an appointment with non-working hours
		Appointment anApp3=aProf.addingFullDateToDiary(1,1,4.50,6);
		if(anApp3 != null)
		{
			aProf.addingFullAppointentDetailsToDiary(anApp3,1,1,1,"Laura","Nas", "Blood Test",1, "None", "None", 2020);
			System.out.println("Appointment was added");
		}
		else
			System.out.println("Appointment was not added");
		

		//adding an appointment that was already added for that date
		Appointment anApp4 = aProf.addingFullDateToDiary(2,3,12.30,14);
		if(anApp4 != null)
		{
			aProf.addingFullAppointentDetailsToDiary(anApp4,2,3,1,"Laura","Nas", "Blood Test",1, "None", "None", 2020);
			System.out.println("Appointment was added");
		}
		else
			System.out.println("Appointment was not added");
		
		System.out.println("----------------------------------");

		//print a set with no appointments
		System.out.println(aProf.freeTime(3,13));
		
		// print a set with appointments added
		System.out.println(aProf.freeTime(2,3));
		
		System.out.println("----------------------------------");

	    // delete all professionals
		GreySloanMemorialHospital.deleteProfessional(prof1);
		GreySloanMemorialHospital.deleteProfessional(prof2);
		System.out.println(GreySloanMemorialHospital.isListEmpty());
		
		// writing / reading from a file
		Professional prof3 = GreySloanMemorialHospital.addProfessional("white", "nurse", 123);
		Professional prof4 = GreySloanMemorialHospital.addProfessional("green", "surgeon", 123);
		Professional prof5 = GreySloanMemorialHospital.addProfessional("blue", "nurse", 234);
		Professional prof6 = GreySloanMemorialHospital.addProfessional("back", "surgeon", 456);
		GreySloanMemorialHospital.printListOfProfessionalsToFile();
		System.out.println("");
		GreySloanMemorialHospital.readSavedFileOfProfessionals();
		
		System.out.println("----------------------------------");

		//stack for professionals
		undo.addToStack(prof3);
		undo.addToStack(prof5);
		System.out.println(undo.isProfStackEmpty());
		Professional prof0 = undo.undoProf();
		System.out.println(prof0.displayDetails());
		undo.clearProfStack();
		
		//stack for appointments
		System.out.println(undo.isAppStackEmpty());
		Appointment app =prof3.addingFullDateToDiary(2,45,12.30,14);
		undo.addToStack(aProf.addingFullAppointentDetailsToDiary(anApp2,2,45,1,"Laura","Nas", "Blood Test",1, "None", "None", 2020));
		System.out.println(undo.isAppStackEmpty());
		undo.clearAppStack();
		System.out.println(undo.isAppStackEmpty());

		System.out.println("----------------------------------");

		//testing array list
		list.addAppointmentToJointList(app);
		System.out.println(list.referenceNumber(app));
		System.out.println(list.size());
		
		GreySloanMemorialHospital.deleteProfessional(prof3);
		GreySloanMemorialHospital.deleteProfessional(prof5);
		GreySloanMemorialHospital.deleteProfessional(prof6);
		undo.clearAppStack();
		undo.clearProfStack();
		list.clear();

	}
	
	/**
	 * Method to display menu options
	 */
	public void displayMenu()
	{
		System.out.println("~M~E~N~U~");
		System.out.println("Option 1 - run automated tests");
		System.out.println("Option 2 - add a professional to a Hospital");
		System.out.println("Option 3 - add an appointment");
		System.out.println("Option 4 - print a list of all appointments booked for a specialist");
		System.out.println("Option 5 - edit information about a professional/an appointment");
		System.out.println("Option 6 - delete a professional/ an appointment");
		System.out.println("Option 7 - display a list of professionals and write their details to file");
		System.out.println("Option 8 - read professional data from file");
		System.out.println("Option 0 - exit");
	}
	
	/**
	 * Method for choosing an option from displayMenu() method
	 */
	public void menu()
	{
		int option = 0;
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~Welcome to Grey Sloan Memorial Hospital~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		do
		{
			displayMenu();
			do 
			{
				option = validInt("Enter your option ");
				
			//option numbers from displayMenu()
			}while(option<0 || option > 8);
			
			switch(option)
			{
				case 1:
					// automated tests
					System.out.println("");
					System.out.println("*******************");
					System.out.println("Run automated tests");
					System.out.println("*******************");
					runAutomatedTests();
					System.out.println("");

					break;
				case 2:
					//adding professional case
					System.out.println("");
					System.out.println("********************************");
					System.out.println("Add a professional to a Hospital");
					System.out.println("********************************");
					addProfessional2();
					System.out.println("");
					break;
				case 3:
					// adding appointment case
					System.out.println("");
					System.out.println("******************");
					System.out.println("Add an appointment");
					System.out.println("******************");
					addAppointment();
					
					System.out.println("");
					break;
				case 4:
					// printing case
					System.out.println();
					System.out.println("*******************************************************");
					System.out.println("Print a list of all appointments booked for a specialist");
					System.out.println("*******************************************************");
					displayAppointments();
					
					System.out.println("");
					break;
				case 5:
					// edit either professional or appointment details
					System.out.println();
					System.out.println("****");
					System.out.println("Edit");
					System.out.println("****");
					edit();
					
					System.out.println("");
					break;
				case 6:
					// deletion case
					System.out.println();
					System.out.println("******");
					System.out.println("Delete");
					System.out.println("******");
					delete();
					System.out.println("");
					break;
				case 7:
					System.out.println();
					System.out.println("****************************************************************************");
					System.out.println("Display a list of professionals, this list is also saved to professional.txt");
					System.out.println("****************************************************************************");
					writeToAFile();
					//case to call a method to write to a file
					
					System.out.println("");
					break;
					
				case 8:
					System.out.println();
					System.out.println("********************************************");
					System.out.println("Read professional data from professional.txt");
					System.out.println("********************************************");
					readSavedFileOfProfessionals();
					// case to call a method to read a saved file
				
					System.out.println("");
					break;
			}
		}while(option!=0);
		
	}
	
	/** method for reading professional data on file
	 * 
	 */
	public void readSavedFileOfProfessionals()
	{
		GreySloanMemorialHospital.readSavedFileOfProfessionals();
	}
	
	/**
	 * method for writing to file a list of professionals
	 */
	public void writeToAFile()
    {  
		GreySloanMemorialHospital.printListOfProfessionalsToFile(); 
    }
	
	/**
	 * Method to add a professional to a list 
	 */
	public void addProfessional2()
	{
		int stop = 0;
		do
		{
			int professionalID;
			// receive professional ID number from user
			
			do 
			{
				professionalID = validInt("Enter professional's ID (a number) ");
			}while(professionalID < 0);
			 
			// receive the professional's name and role from the user
			String name = validString("Enter professional's name ");
			String role = validString("Enter professional's role ");
				
			/*
			 * if there is not identical ID in the list
			 * add professional's details to a node and add to stack in Undo class
			 * ask to add more prof or stop */
				if(GreySloanMemorialHospital.findInList(professionalID) == null)
				{
					GreySloanMemorialHospital.addProfessional(name, role, professionalID);
					undo.addToStack(GreySloanMemorialHospital.findInList(professionalID));
					undoMethod();
					System.out.println("");
					System.out.println("To stop adding professionals, press 0");
					System.out.println("To continue adding professionals, press 1");
					do 
					{
						stop = validInt("Enter your option ");
					}while(stop < 0 || stop > 1);
					
					System.out.println("");
				}
				
				else
				{
					// when an ID is entered which is already used by another professional
					System.out.println("Professional with such ID is already added. Please, add a professional with a different ID.");
					stop = 1;
					System.out.println("");
				}
				
			}while(stop != 0);
		
	}
	
	/**
	 * Method to define how many specialists are needed for an appointment and to call 
	 * particular methods based on that number
	 */
	public void addAppointment()
	{
		if(GreySloanMemorialHospital.isListEmpty() == false)
		{
			System.out.println("How many specialists are required for an appointment?");
			System.out.println("Option -1- one professional");
			System.out.println("Option -2- several professionals");
			
			int option;
			do 
			{
				option = validInt("Enter your option ");
			}while(option < 1 || option > 2);
			
			switch(option)
			{
			case 1:
				// 1 is received and will add appointment for one professional
				System.out.println("-*-*-*-*-*-*-*-*");
				System.out.println("One professional");
				System.out.println("-*-*-*-*-*-*-*-*");
				oneProfessionalChosen();
				undoMethod();
				break;
			case 2:
				/*
				 * 2 is received
				 * checks if option 2 is valid as there could be only one professional
				 */
				if(GreySloanMemorialHospital.numOfProfessional() ==1)
				{
					System.out.println("Only one professional is added to the list");
					System.out.println(" ");
					oneProfessionalChosen();
				}
				else
				{
					System.out.println("-*-*-*-*-*-*-*-*-*-*-");
					System.out.println("Several professionals");
					System.out.println("-*-*-*-*-*-*-*-*-*-*-");
					severalProfessionalsChosen();
				}
				undoMethod();
				break;
			}
		}else
			System.out.println("List of professionals is empty. Please, add a professional first");
		
	}
	
	/**
	 * Method to add an appointment for one specialist only
	 */
	public void oneProfessionalChosen()
	{
		Appointment anApp = null;
		int id, month, day;
		double appStartTime, appEndTime;
		boolean validDay = true;
		
		//printing the list of professionals 
		GreySloanMemorialHospital.printListOfProfessionals();
		
	
		// do while loop to get ID of professional while id is null
		do
		{
			id = validInt("Enter ID of a professional for the appointment ");			
		}while(GreySloanMemorialHospital.findInList(id) == null);
		
		//new professional = id in list
		Professional newProf = GreySloanMemorialHospital.findInList(id);
		
		System.out.println("");
		System.out.println("Enter date for an appointment");
		// do while loop for getting the month of the appointment
		do
		{
				month = validInt("\tA number of a month ");
		}while(month < 1 || month > 12);
		
		//receiving the day of the appointment
		do
		{
				day = validInt("\tA number of a day ");
				
				// checks if the month and the day are in range
				validDay = isDayValid(month, day);
		}while(validDay == false);
		
		//loop to find appropriate time slot for an appointment
	
		boolean valid = true; 
			int repeat = 0;
		do
		{
			
			do
			{
				if( repeat != 0)
					System.out.println("This time for an appointment is not possible");
				// here it is possible to add double type number for time
				 
				System.out.println("");
				System.out.println("Please, choose the time: " + newProf.freeTime(month,day));
				appStartTime = validDouble("\tStart time (24h time format) ");
				appEndTime = validDouble("\tEnd time (24h time format) ");
				
				/*
				 * if the appointment time is before 8am or after 7pm AND the end time is less than 8am or after 7pm
				 * then this is not valid
				 */
				if((appStartTime < 8 || appStartTime >19) && (appEndTime < 8 || appEndTime > 19))
					valid = false;
				else
				{
					/*
					 * appointment start time cannot be after end time
					 */
					if(appStartTime>appEndTime)
						valid = false;
					else
						valid = true;
				}
			}while(valid == false);
			repeat += 1;
			
			/*
			 * add appointment to professional diary
			 */
			anApp = newProf.addingFullDateToDiary(month, day, appStartTime, appEndTime);
		}while(anApp== null);
		
		int appointmentID;
		do
		{ 
			appointmentID = validInt("\tAppointment ID ");
		}while(appointmentID<0);
			
		/*
		 * ask the user for each of the patients details
		 */
			String patName = validString("\tPatient's name ");
			String patSurname = validString("\tPatient's surname ");
			int patBirthYear = validInt("\tPatient's birth year ");
			String appType = validString("\tAppointment Type ");
			String location = validString("\tLocation ");
			String description = validString("\tDescription ");
			
			/*
			 * if professional has an free time, then add the appointment with all the details
			 */
			 if(newProf.addingFullAppointentDetailsToDiary(anApp,month,day,appointmentID,patName,patSurname,appType,1,location,description,patBirthYear)!=null)
			 {
				System.out.println("");
				System.out.println("Appointment was added");
				list.addAppointmentToJointList(anApp);
				System.err.println("Reference number of an appointment "+list.referenceNumber(anApp));
			 }
			/*
			 * add appointment to stack in Undo class
			 */
			undo.addToStack(anApp);
	}
	
	/*
	 * Method to add one appointment for several specialists
	 */
	public void severalProfessionalsChosen()
	{
		/*
		 * display a list of professionals
		 */
		GreySloanMemorialHospital.printListOfProfessionals();
		int numOfSpecialists;
		
		do 
		{
			 numOfSpecialists = validInt("Enter a number of how many professionals are needed for an appointment ");
		}while(numOfSpecialists > GreySloanMemorialHospital.numOfProfessional() || numOfSpecialists <= 0);
		
		/*
		 * creating an array of ID of needed professionals
		 */
		int[] arrayOfID = new int[numOfSpecialists];
		
		/*
		 * creating an array of professional objects
		 */
		Professional[] arrayOfProfessionals = new Professional[numOfSpecialists];
		
		/*
		 *  a loop to initialise an array of ID and an array of professionals corresponding to their ID
		 */
		for(int i = 0; i < arrayOfID.length; i++)
		{
			/*
			 * loop to get non repeating IDs
			 */
			do
			{
				/*
				 * loop to get valid IDs
				 */
				do
				{
					arrayOfID[i] = validInt(i+1 + ". Enter professional ID ");
				}
				while(GreySloanMemorialHospital.findInList(arrayOfID[i]) == null);
				
				if(i==0)
					break;
			}while(arrayOfID[i-1] == arrayOfID[i]);
			arrayOfProfessionals[i] = GreySloanMemorialHospital.findInList(arrayOfID[i]);
		}
		
		
		/*
		 * asking for a month and a day of an appointment
		 */
		System.out.println("");
		System.out.println("Enter  a month and a range of days for an appointment");
		int month;
		/*
		 * asking for month
		 */
		do
		{
				month = validInt("Month ");
		}while(month < 1 || month > 12);
			
		int day, day1;
		boolean validDay = true, validDay1= true;
		
		
		/*
		 * creating a copy set so retain all does not delete elements
		 */
		Set<Integer> copy_set = new LinkedHashSet<Integer>();
		
		/*
		 * asking for a starting day and an ending day
		 */
		do
		{
				day = validInt("Day from ");
				day1 = validInt("Day to ");
				/*
				 * makes sure the month and day is allowable
				 */
				validDay = isDayValid(month, day);
				validDay1 = isDayValid(month, day1);
		}while(validDay == false || validDay1 == false || day > day1);
		
		System.out.println("");

		/*
		 * loop to find appropriate time in each day 
		 */
		for(int d = day ; d <= day1 ; d++)
		{
			/*
			 * loop to delete the information in sets that was added before
			 */
			for(int j = 0 ; j < arrayOfProfessionals.length;  j++ )
			{
				arrayOfProfessionals[j].freeTime(month,d).clear();
			}
			
			/*
			 * loop to find suitable time range in timetables of each professional  
			 */
			for(int j = 0 ; j < arrayOfProfessionals.length;  j++ )
			{    
				arrayOfProfessionals[j].freeTime(month,d);

				if(j==0)
				{
					copy_set = arrayOfProfessionals[j].freeTime(month,d);
					continue;
				}
				/*
				 * use copy_set so retainAll does not delete elements
				 * checking for matches of professionals with free time
				 */
				copy_set.retainAll(arrayOfProfessionals[j].freeTime(month,d));
			}
			
			System.out.println("DAY " + d);
			System.out.println("Potential time slots: " + copy_set);
		}
		
		/*
		 * asking to choose the appropriate day and time for an appointment
		 */
		int chosenStartTime, chosenEndTime;
		int chosenDay = 0;
		int repeat = 0;
		
		/*
		 * choosing day
		 */
		if(day == day1) 
		{
			chosenDay = day;
		}
		else
		{
			do
			{
				chosenDay = validInt("Please, choose the day ");
			}while(chosenDay<day || chosenDay>day1);
		}
		
		/*
		 * choosing time
		 * do while start time or end time is not in the set/ these times are not available
		 */
		do
		{
			if( repeat != 0)
				System.out.println("This time slot is not available.");
			chosenStartTime = validInt("Please, choose the start time ");
			chosenEndTime = validInt("Please, choose the end time ");
			repeat += 1;
		}while(copy_set.contains(chosenStartTime) == false || (copy_set.contains(chosenEndTime) == false));
		
		
		System.out.println("Enter appointment details:");
		int appointmentID;
		/*
		 * assign appointment ID
		 */
		do
		{ 
			appointmentID = validInt("\tAppointment ID ");
		}while(appointmentID<0);
			
		/*
		 * ask for patient details , name, dob etc
		 */
		String patName = validString("\tPatient's name ");
		String patSurname = validString("\tPatient's surname ");
		int patBirthYear = validInt("\tPatient's birth year ");
		String appType = validString("\tAppointment Type ");
		String location = validString("\tLocation ");
		String description = validString("\tDescription ");
			
		Appointment anAppointment = null;
		
		/*
		 * loop to add the same appointment for a number of doctors
		 */
		for(int j = 0 ; j < arrayOfProfessionals.length;  j++ )
		{  
			anAppointment = arrayOfProfessionals[j].addingFullDateToDiary(month, day, chosenStartTime, chosenEndTime);
			if(arrayOfProfessionals[j].addingFullAppointentDetailsToDiary(anAppointment,month,day,appointmentID,patName,patSurname,appType,arrayOfProfessionals.length,location,description,patBirthYear) != null)
			{
				/*
				 * adding appointment to stack in Undo class
				 * appointment has been made with full details and reference number is given
				 */
				undo.addToStack(anAppointment);
				System.out.println(" ");
				list.addAppointmentToJointList(anAppointment);
				System.err.println("Reference number of an appointment "+list.referenceNumber(anAppointment));
				System.out.println("Appointment was added for " + arrayOfProfessionals[j].getRole()+ " " + arrayOfProfessionals[j].getName());
			}
			else
				System.out.println("Appointment was not added for " + arrayOfProfessionals[j].getRole()+ " " + arrayOfProfessionals[j].getName());
		}
	}
	
	/**
	 * Method to to delete an added appointment = undo option
	 */
	public void undoMethod()
	{
		System.out.println(" ");
		System.out.println("Undo - delete");
		System.out.println("Option -1- Yes");
		System.out.println("Option -2- No");
		int option;
		/*
		 * asking user for option
		 */
		do 
		{
			option = validInt("Enter your option ");
		}while(option < 1 || option > 2);
		
		
		switch(option)
		{
		case 1:
			/*
			 * yes - delete
			 */
			System.out.println("");
			System.out.println("YES");
			/*
			 * if the appointment stack is not empty
			 * delete the appointment
			 * else if prof stack is not empty
			 * then delete professional
			 */
			if(undo.isAppStackEmpty() == false)
			{
				do {
				deleteAppoint(undo.undoApp());
				}while(undo.isAppStackEmpty() == false);
			}
			else if(undo.isProfStackEmpty() == false)
				deleteProfessional(undo.undoProf());
			else
				System.out.println("Undo is not possible");
			break;
			
		case 2:
			/*
			 * no - continue
			 * empty the appointment stack
			 * empty professional stack
			 */
			if(undo.isAppStackEmpty() == false)
				undo.clearAppStack();
			else if(undo.isProfStackEmpty() == false)
				undo.clearProfStack();
			else
				System.out.println("Undo is not possible");
			break;
		}
		
	}
	
	/**
	 * Method to display a list of booked appointments for a professional
	 */
	public void displayAppointments()
	{
		if(GreySloanMemorialHospital.isListEmpty() == false)
		{
			int id;
			/*
			 * printing the list of professionals
			 */
			GreySloanMemorialHospital.printListOfProfessionals();
			
			/*
			 * asking user for Id of the professional while id is not in the list
			 */
			do
			{
				id = validInt("Enter ID of a professional ");			
			}while(GreySloanMemorialHospital.findInList(id) == null);
			
			
			/*
			 * display the details of the professional
			 * display the timetable of their appointments		
			 */
			Professional newProf = GreySloanMemorialHospital.findInList(id);
			System.out.println("");
			System.out.println(newProf.displayDetails());
			GreySloanMemorialHospital.displayTimetableOfAppointments(id);
		}
		else
			System.out.println("List of professionals is empty");
	}
	
	/**
	 * Method to edit booked appointments
	 */
	public void edit()
	{
		/*
		 * if hospital list is not empty
		 */
		if(GreySloanMemorialHospital.isListEmpty() == false)
		{
			/*
			 * ask user to choose which to edit - professional or appointment
			 */
			System.out.println("Option -1- professional");
			System.out.println("Option -2- appointment");
			
			int option;
			do 
			{
				option = validInt("Enter your option ");
			}while(option < 1 || option > 2);
			
			switch(option)
			{
			case 1:
				/*
				 * option 1 - professional
				 * call edit prof method
				 */
				System.out.println("-*-*-*-*-*-*");
				System.out.println("Professional");
				System.out.println("-*-*-*-*-*-*");
				editProfessionalInfo();
				break;
			case 2:
				/*
				 * option 2 - appointment
				 * call edit appointment method
				 */
				System.out.println("-*-*-*-*-*-");
				System.out.println("Appointment");
				System.out.println("-*-*-*-*-*-");
				editAppointmentInfo();
				
				break;
			}
		}else
			/*
			 * list is empty
			 */
			System.out.println("List of professionals is empty. Please, add a professional first");
	}
	
	/**
	 * Method to edit information about a professional
	 */
	public void editProfessionalInfo()
	{			
		Professional newProf = getProfObj();
		
		int option;
		
		/*
		 * ask what detail of the professional should be edited, display current details
		 */
		do
		{
			System.out.println("");
			System.out.println(newProf.displayDetails());
			System.out.println("Edit");
			System.out.println("Option -1- ID");
			System.out.println("Option -2- Name");
			System.out.println("Option -3- Role");
			System.out.println("Option -0- Exit");
			do 
			{
				option = validInt("Enter your option ");
			/*
			 * option numbers from displayMenu()
			 */
			}while(option<0 || option > 3);
			
			switch(option)
			{
				case 1:
					System.out.println("");
					System.out.println("**");
					System.out.println("ID");
					System.out.println("**");
					
					int professionalID;
					/*
					 * ask user for new ID and set this as profID
					 */
					do
					{
						professionalID = validInt("Enter new ID ");			
					}while(GreySloanMemorialHospital.findInList(professionalID) != null);
					newProf.setprofessionalID(professionalID);
					System.out.println("");

					break;
				case 2:
					System.out.println("");
					System.out.println("*****");
					System.out.println("NAME");
					System.out.println("****");
					
					/*
					 * ask user for new name and set this as the professional name
					 */
					String name;
					name = validString("Enter new name ");
					newProf.setName(name);
					System.out.println("");
					break;
				case 3:
					System.out.println("");
					System.out.println("****");
					System.out.println("ROLE");
					System.out.println("****");
					
					/*
					 * ask user for new role and set this in the role field
					 */
					String role;
					role = validString("Enter new role ");
					newProf.setRole(role);
					System.out.println("");
					
					break;
			}
		}while(option!=0);
	}
	
	/**
	 * Method to edit information about an appointment
	 */
	public void editAppointmentInfo()
	{
	
		/*
		 * if size of the list is 0 then there are no appointments
		 */
		if(list.size() == 0)
		{
			System.out.println("List of appointments is empty");
		}
		else
		{
			Appointment app = getAppointObj();
			
			int option;
			/*
			 * display appointment details and ask what should be edited
			 */
			do
			{
				System.out.println("");
				app.displayAppointmentDetails();
				System.out.println("");
				System.out.println("EDIT");
				System.out.println("Option -1- ID");
				System.out.println("Option -2- Name of a patient");
				System.out.println("Option -3- Surname of a patient");
				System.out.println("Option -4- Birth Year of a patient");
				System.out.println("Option -5- Type of an appointment");
				System.out.println("Option -6- Location of an appointment");
				System.out.println("Option -7- Description of an appointment");
				System.out.println("Option -0- Exit");
				/*
				 * receive option from user
				 */
				do 
				{
					option = validInt("Enter your option ");
				//option numbers from displayMenu()
				}while(option<0 || option > 7);
				
				switch(option)
				{
					case 1:
						System.out.println("");
						System.out.println("**");
						System.out.println("ID");
						System.out.println("**");
						
						/*
						 * ask for new ID and set as id
						 */
						int idN;
						idN = validInt("Enter new ID ");			
						app.setAppointmentID(idN);
						System.out.println("");
						break;
					case 2:
						System.out.println("");
						System.out.println("****");
						System.out.println("NAME");
						System.out.println("****");
						
						/*
						 * ask for new name and set to nName field
						 */
						String nName;
						nName = validString("Enter a new name ");
						app.setPatientName(nName);
						System.out.println("");
						break;
					case 3:
						System.out.println("");
						System.out.println("*******");
						System.out.println("SURNAME");
						System.out.println("*******");
						
						/*
						 * similar idea as above
						 */
						String nSurname;
						nSurname = validString("Enter a new surname ");
						app.setPatientSurname(nSurname);
						System.out.println("");
						break;
					case 4:
						System.out.println("");
						System.out.println("**********");
						System.out.println("BIRTH YEAR");
						System.out.println("**********");
						
						int nYear;
						nYear = validInt("Enter a new birth year ");
						app.setPatientsBirthYear(nYear);
						System.out.println("");
						break;	
					case 5:
						System.out.println("");
						System.out.println("*****************");
						System.out.println("APPOINTMENT TYPE");
						System.out.println("*****************");
						
						String nType;
						nType = validString("Enter a new appointment type ");
						app.setAppointmentType(nType);
						System.out.println("");
						break;	
					case 6:
						System.out.println("");
						System.out.println("********");
						System.out.println("LOCATION");
						System.out.println("********");
						
						String nLocation;
						nLocation = validString("Enter a new location ");
						app.setLocation(nLocation);;
						System.out.println("");
						break;	
					case 7:
						System.out.println("");
						System.out.println("***********");
						System.out.println("DESCRIPTION");
						System.out.println("***********");
						
						String nDescription;
						nDescription = validString("Enter a new description ");
						app.setDescription(nDescription);
						System.out.println("");
						break;	
						
				}
			}while(option!=0);
		}
	}
	
	/**
	 * Method to get an appointment object based on reference number
	 */
	public Appointment getAppointObj()
	{
		int referenceNum;
		/*
		 * ask for reference number while reference number is null
		 */
		do
		{
			referenceNum = validInt("Enter a valid reference number ");			
		}while(list.exist(referenceNum)== null);
		Appointment app = list.exist(referenceNum);
		return app;
	}
	
	/**
	 * Method to get professional object 
	 */
	public Professional getProfObj()
	{
		int id;
		/*
		 * display all professionals
		 */
		GreySloanMemorialHospital.printListOfProfessionals();
		
		/*
		 * ask for professional ID while id is null
		 */
		do
		{
			id = validInt("Enter ID of a professional ");			
		}while(GreySloanMemorialHospital.findInList(id) == null);
				
		Professional newProf = GreySloanMemorialHospital.findInList(id);
		return newProf;
	}
	
	/**
	 * Method to delete appointment/professional
	 */
	public void delete()
	{
		/*
		 * if list is not empty
		 */
		if(GreySloanMemorialHospital.isListEmpty() == false)
		{
			System.out.println("Option -1- a professional");
			System.out.println("Option -2- an appointment");
			
			int option;
			/*
			 * ask user for option
			 */
			do 
			{
				option = validInt("Enter your option ");
			}while(option < 1 || option > 2);
			
			switch(option)
			{
			case 1:
				System.out.println("-*-*-*-*-*-*");
				System.out.println("Professional");
				System.out.println("-*-*-*-*-*-*");
				deleteProfessional(null);
				break;
			case 2:
				if(list.size() != 0)
				{
					System.out.println("-*-*-*-*-*-");
					System.out.println("Appointment");
					System.out.println("-*-*-*-*-*-");
					deleteAppoint(null);
				}
				else
					System.out.println("No appointments are added.");

				break;
			}
		}else
			System.out.println("List of professionals is empty. Please, add a professional first");
	}	
	
	/**
	 * Method to delete an appointment
	 */
	public void deleteAppoint(Appointment app)
	{
		/*
		 * if app is null
		 * get ID for desired deletion
		 */
		if(app == null)
			app = getAppointObj();
		Professional aProf = GreySloanMemorialHospital.findInList(app.getProfessionalID());
		Month aMonth = aProf.addingMonth(app.getMonthNum());
		Day aDay = aProf.addingDay(aMonth, app.getDayNum());
		aDay.deleteAppointment(app);
		System.out.println("Appointment was deleted");
	}
	
	/**
	 * Method to delete a professional
	 */
	public void deleteProfessional(Professional prof)
	{
		/*
		 * if professional is null
		 * get ID for desired deletion
		 */
		if(prof == null)
			prof = getProfObj();
		GreySloanMemorialHospital.deleteProfessional(prof);
		System.out.println("Professional was deleted");

	}
	/**
	 * Method to check if inputed day is in a particular month
	 * @param month number 
	 * @param newDay to be checked whether it belongs to a certain month
	 * @return boolean ( if a day belongs to a month - true,
	 * 					 if not - false)
	 */
	public boolean isDayValid(int month, int newDay)
	{
			switch(month)
			{
			
			 //checks if January, March etc are within 31 days
			 
			case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
				if(newDay>0 && newDay<32)
				{
					return true;
				}
				break;
			
			 //checks if months are within 30 days
			 
			case 4: case 6: case 9: case 11:
				if(newDay>0 && newDay<31)
				{
					return true;
				}
				break;
			case 2:
				if(newDay>0 && newDay<29)
				{
					return true;
				}
				break;
				
			}
		return false;
	}
	
	/**
	 * Method for checking whether user's input is of valid int type
	 * @param text which is displayed for a user
	 * @return option for menu, ID of an item(node)
	 */
	public int validInt(String text)
	{
		
		//Scanner for getting user input
		
		Scanner s = new Scanner(System.in);
		int option = 0;
		boolean valid = true;
		do
		{
			try 
			{
				System.out.print(text);
				option = s.nextInt();

				valid = true;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid input");
				s.next();
				
				valid = false;
			}
		}while(!valid);
		
		return option;
	}
	
	/**
	 * Method for checking whether user's input is of valid String type
	 * (if numerical data is entered, no exception is thrown since it is considered to be 
	 * of String type)
	 * @param text which is displayed for a user
	 * @return name of String type
	 */
	public String validString(String text)
	{
		Scanner s1 = new Scanner(System.in);
		String name = "";
		boolean valid = true;
		do
		{
			try 
			{
				System.out.print(text);
				name = s1.nextLine();
	
				valid = true;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid input");
				s1.next();
				
				valid = false;
			}
		}while(!valid);
		
		return name;
		}	
	
	/**
	 * Method for checking whether user's input is of valid double type
	 * @param text which is displayed for a user
	 * @return number of double type
	 */
	public double validDouble(String text)
	{
		Scanner s2 = new Scanner(System.in);
		double number = 0.00;
		boolean valid = true;
		do
		{
			try 
			{
				System.out.print(text);
				number = s2.nextDouble();
	
				valid = true;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid input");
				s2.next();
				
				valid = false;
			}
		}while(!valid);
		
		return number;
	} 
	/**
	 * getter method to return hospital field
	 * @return
	 */
	public Hospital getGreySloanMemorialHospital() {
		return GreySloanMemorialHospital;
	}
	/**
	 * setter method for hospital field
	 * @param greySloanMemorialHospital
	 */
	public void setGreySloanMemorialHospital(Hospital greySloanMemorialHospital) {
		this.GreySloanMemorialHospital = greySloanMemorialHospital;
	}
	/**
	 * method to get list
	 * @return
	 */
	public AllAppointments getList() {
		return list;
	}
	/**
	 * method to set list
	 * @param list
	 */
	public void setList(AllAppointments list) {
		this.list = list;
	}
	/**
	 * method to get undo
	 * @return
	 */
	public Undo getUndo() {
		return undo;
	}
	/**
	 * method to set undo
	 * @param undo
	 */
	public void setUndo(Undo undo) {
		this.undo = undo;
	}
	
}