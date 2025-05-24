import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Person {
    private String name;
    private Date dob;
    private int age;

    public Person(String name, String dob) throws ParseException {
        this.name = name;
        this.dob = new SimpleDateFormat("dd-MM-yyyy").parse(dob);
        this.age = calculateAge();
    }

    private int calculateAge() {
        Calendar birthCal = Calendar.getInstance();
        birthCal.setTime(dob);

        Calendar today = Calendar.getInstance();

        int years = today.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);

       
        int currentMonth = today.get(Calendar.MONTH);
        int birthMonth = birthCal.get(Calendar.MONTH);

        int currentDay = today.get(Calendar.DAY_OF_MONTH);
        int birthDay = birthCal.get(Calendar.DAY_OF_MONTH);

        if (currentMonth < birthMonth || (currentMonth == birthMonth && currentDay < birthDay)) {
            years--;
        }

        return years;
    }

    public void displayPersonDetails() {
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + new SimpleDateFormat("dd-MM-yyyy").format(dob));
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) throws ParseException {
        Person person = new Person("John Doe", "10-05-1985");
        person.displayPersonDetails();
    }
}
