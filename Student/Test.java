package Student;

/**
 * Test class.
 * @author Alex
 */
public class Test {

    public static void main(String[] args) {
        Student stu1 = new Student("Yi", 35, "Male", new Address("123", 
                "Fakestreet", "21", "Montreal", "Quebec", "A1X 1A1"));
        System.out.println(stu1);
        
        stu1.setAddress(new Address("223", "Fakestreet", "21", "Montreal", 
                "Quebec", "A1X 1A1"));
        System.out.println(stu1);             // redundant
        
        stu1.getAddress().setApartNum("223");
        stu1.getAddress().setStreetNum("141");
        stu1.getAddress().setZipcode("H1H 5D1");
        System.out.println(stu1);
        stu1.checkCity();
        
        stu1.getAddress().setCityName("Toronto");
        stu1.getAddress().setProvince("Ontario");
        stu1.checkCity();
    }
}
