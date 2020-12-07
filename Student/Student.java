/*
Static var: belong to the class.
Non-static var: belong to the objects.

Static method: can only put static var and static methods. You should only call 
               a static method through a class (Xxxxxx.method()).
    Examples:
            String.format()
            Math.xxxx()
            Character.xxxx()
Non-static method: Can put anything in a non-static method(static var, static 
                   method, non static var, non-static method). You can only call
                   a non-static method through an object (xxxx()).

99% of methods in a class should be non-static
*/
package Student;

/**
 * Class of Student.
 * @author Alex Nguyen
 */
public class Student {
    private String name;
    private int age;
    private String gender;
    private String id;
    private String email;               // name@vaniercollege.qc.ca
    private Address address;            // user defined class in other user defined class
    private static int nextId = 1;      // one copy of id
    private final static String SCHOOL_NAME = "Vanier College";

    public Student() {
        this.name = null;
        this.age = 0;
        this.gender = null;
        this.email = null;
        this.id = null;
        this.email = null;
        this.address = null;
    }
    
    public Student(String name, String gender) {       // static method
        this.name = name;
        this.age = 0;
        this.gender = gender;
        this.id = String.format("%06d", nextId++);      // static var
        this.email = null;
        this.address = null;
    }
    
    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = String.format("%06d", nextId++);
        this.email = generateEmail();
        this.address = null;
    }
    
    public Student(String name, int age, String gender, Address address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = String.format("%06d", nextId++);
        this.email = generateEmail();
        this.address = address;
    }
    
    public Student(Student student) {
        this.name = student.name;
        this.age = student.age;
        this.gender = student.gender;
        this.id = student.id;
        this.id = student.email;
        // this.address = student2.address;             // shallow copy
        this.address = new Address(student.address);   // deep copy
    }
    
    /**
     * Generates an email for a student.
     * @return An email.
     */
    public String generateEmail() {     
        return String.format("%s@vaniercollege.qc.ca", name);
    }
    
    /**
     * Checks the name for any oddities.
     * @param name The name.
     * @return True if the name has no oddities, false if it does.
     */
    public static boolean isNameValid(String name) {        // static method
        // System.out.println(age);             age is non-static. gives error
        // System.out.println(SCHOOL_NAME);     SCHOOL_NAME is static. no error
        // generateEmail()                      method is non-static. gives error
        char c;    
        for (int i = 0; i < name.length(); i++) {
            c = name.charAt(i);
            if (!Character.isLetter(c) && c != ' ' && c != '-' && c != '/')
                return false;
        }
        return true;
    }
    
    public void checkCity() {
        if (this.address.getCityName().equalsIgnoreCase("montreal"))
            System.out.println("You live close to the college.");
        else if (this.address.getProvince().equalsIgnoreCase("Quebec"))
            System.out.println("You live relatively close to the college.");
        else
            System.out.println("You live far from the college.");
    }
    
    public boolean equals(Student student2) {
        return this.name.equals(student2.name) &&
                this.age == student2.age &&
                this.gender.equals(student2.gender) &&
                this.id.equals(student2.id) &&
                this.email.equals(student2.email) &&
                this.address.equals(student2.address);
    }

    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%-12s: %s\n", "Name", name);
        str += String.format("%-12s: %d\n", "Age", age);
        str += String.format("%-12s: %s\n", "Gender", gender);
        str += String.format("%-12s: %s\n", "ID", id);
        str += String.format("%-12s: %s\n", "Email", email);
        str += String.format("Student from: %s \n", SCHOOL_NAME);
        str += String.format("%s: \n", "Address");
        str += String.format("%-15s\n", address);
        
        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (isNameValid(name)) {
            this.name = name;
            email = String.format("%s@vaniercollege.qc.ca", name);
        }
        else
            System.out.println("Invalid name.");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = generateEmail();
        int atIdx = email.indexOf('@');
        name = email.substring(0, atIdx);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
