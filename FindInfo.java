import java.util.Scanner;

public class FindInfo {

	Scanner scan = new Scanner(System.in);	
	public String firstName;
	public String lastName;
	public int age;
	public double weight;
	public int height;
	public char gender;
	public int activityLevel;
	public String trash;
	public int count =0;
	public char contin;
	public double ideal = 0.0;
	
	public work workObj;

	
	public void getInfo()
	{
		System.out.println("Please provide me with the following information: ");
		if (count ==1) {
			trash = scan.nextLine();
		}
		System.out.print("First Name: ");
		firstName = scan.nextLine();
		firstName = firstName.toLowerCase();
		
		System.out.print("Last Name: ");
		lastName = scan.nextLine();
		lastName = lastName.toLowerCase();
		
		System.out.print("Age: ");
		age = scan.nextInt();
		if (age<=0) {
			count =1;
			System.out.println("Age cannot be equal to or below 0");
			getInfo();
		} 
		
		System.out.print("Weight(in pounds): ");
		weight = scan.nextDouble();
		if (weight<=0) {
			count = 1;
			System.out.println("Weight cannot be equal to or below 0");
			getInfo();
		}
		
		System.out.print("Height(in inches): ");
		height = scan.nextInt();
		if (height<=0) {
			count =1;
			System.out.println("Height cannot be equal to or below 0");
			getInfo();
		}
		
		trash = scan.nextLine();
		System.out.println("Gender:(M/F)");
		gender = scan.nextLine().toLowerCase().charAt(0);
		if ((gender == 'f') || (gender == 'm')) {
			
		}
		else {
			count =1;
			System.out.println("Gender must be male of female");
			getInfo();
		}
		System.out.println("Activity Level according to the following categories: ");
		System.out.println("\t1 = Sedentary(Little to no exercise with a desk job)");
		System.out.println("\t2 = Light(Little exercise/ Sports 3-5 times per week)");
		System.out.println("\t3 = Moderate(Moderate exercise/ sports 3-5 times per week)");
		System.out.println("\t4 = Active(Hard exercise/ sports 6-7 times per week)");
		System.out.println("\t5 = Very Active(Hard daily exercise)");
		activityLevel = scan.nextInt();
		if ((activityLevel >= 6) || (activityLevel <=0)) {
			System.out.println("Invalid response");
			count =1;
			getInfo();
		}
		trash = scan.nextLine();
		System.out.println("Would you like to continue and see your ideal weight according to your stats?(Y/N)");
		contin = scan.nextLine().toLowerCase().charAt(0);
		workObj = new work(firstName, lastName, age, weight, height, activityLevel, gender);
	}
		
	
	public void printResults() {
		System.out.println("----------------------------------------");
		System.out.println(firstName + " " + lastName + "'s information");
		System.out.println("Weight is  "+ weight + " pounds or " +  workObj.getNewWeight() + " Kilograms.");
		System.out.println("Height is  "+ height + " inches or " +  workObj.getNewHeight() + " Centimeters.");;
		System.out.println("Age: "+ age);
		
		System.out.print("The following are for a ");
		if (gender == 'm')
			System.out.println("male.");
		else
			System.out.println("female.");
		
		System.out.println("BMR or Basal Metabolic Rate, is the measure of the amount of calories you would"
				+ " burn during a day of rest.");
		System.out.println("Your BMR: " + workObj.getBMR()+"\n");
		System.out.println("BMI or Body Mass Index, is the measure of body fat based on your height and weight.");
		System.out.println("Your BMI: " + workObj.getBMI()+"\n");
		System.out.print("Based on your BMI you are categorized as ");
		double bmi = workObj.getBMI();
		if (bmi<18.5)
			System.out.println("UnderWeight");
		if(bmi>18.5 && bmi<25)
			System.out.println("Normal Weight");
		if(bmi>25 && bmi<30)
			System.out.println("OverWeight");
		if(bmi>30 && bmi<35)
			System.out.println("Class 1 Obesity");
		if(bmi>35 && bmi<40)
			System.out.println("Class 2 Obesity");
		double holdTDEE = workObj.getTDEE();
		System.out.println("TDEE or Total Daily Energy Expenditure is the measure of the the amount of "
				+ "calories we burn during a day, it takes into account the BMR and activity level.");
		System.out.println("Your TDEE: " + workObj.getTDEE()+ "\n");
		
		System.out.println("If youre trying to lose weight(cut) you need to eat at "+(holdTDEE-500)+" calories a day");
		System.out.println("If youre trying to maintain your current weight you need ot eat at "+ (holdTDEE)+" calories a day");
		System.out.println("If youre trying to gain weight(bulk) you need to eat at "+(holdTDEE+500)+" calories a day");
		if (contin == 'y') {
			ideal = workObj.getIdeal();
			System.out.println("Your ideal weight according to your height should be: "+ ideal + " Pounds");
		}
		
	}
}
