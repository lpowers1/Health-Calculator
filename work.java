import java.lang.Math;
public class work{

	private String firstName;
	private String lastName;
	private int age;
	private double weight;
	private double height;
	private char gender;
	private int activityLevel;
	private double BMR;
	private double TDEE;
	private double BMI;
	private double weight2;
	private double height2;
	public double ideal;
	
	public work(String firstName, String lastName, int age, double weight, int height, int activityLevel, char gender) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.gender = gender;
		this.activityLevel = activityLevel;
		
	}
	
	//sets weight to kilograms to allow for easier conversion
	private void setWeight() {
		weight2 = weight * .45359;
	}
	
	private void setHeight() {
		height2 = height * 2.54;
	}
	
	public double getNewWeight() {
		setWeight();
		return weight2;
	}
	
	public double getNewHeight() {
		setHeight();
		return height2;
	}
	
	public String getName() {
		return (firstName + " " + lastName);
	}
	
	public double getBMR() {
		
		if(gender == 'm')
		{
			BMR = (66+(13.75 * getNewWeight())+(5 * getNewHeight())-(6.8 * age));
		}
		else
		{
			BMR = (655+(9.6 * getNewWeight()) + (1.8 * getNewHeight()) - (4.7 * age));
		}
		BMR = Math.round(BMR*100);
		BMR = BMR/100;
		return BMR;
	}
	
	public double getTDEE() {
		
		switch (activityLevel)
		{
		case 1:
			TDEE = BMR*1.2;
			break;
		case 2:
			TDEE = BMR *1.375;
			break;
		case 3:
			TDEE = BMR *1.55;
			break;
		case 4:
			TDEE = BMR *1.725;
			break;
		case 5:
			TDEE  = BMR * 1.9;
			break;
		}
		TDEE = Math.round(TDEE*100);
		TDEE = TDEE/100;
		return TDEE;

	}
	
	public double getBMI() {
		BMI = (weight/(height*height))*703;
		BMI = Math.round(BMI*100);
		BMI = BMI/100;
		return BMI;
	}
	
	public double getCorrectPounds(){
		return (ideal*2.204);
	}
	
	public double getIdeal() {
		if (height<60) {
			return 0.0;
		}
		else {
			if (gender == 'm') {
					ideal = 50+((height-60)*2.3);
					ideal = getCorrectPounds();
					ideal = Math.round(ideal*100);
					ideal = ideal/100;
					return ideal;
			}
			else {
				ideal = 45.5+((height-60)*2.3);
				ideal = getCorrectPounds();
				ideal = Math.round(ideal*100);
				ideal = ideal/100;
				return ideal;
			}
		}
	}
}
