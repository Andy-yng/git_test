/**
 * This class represents students which has a name and associated money
 *
 * @author Andy Yang
 * email: andy.yang.2@stonybrook.edu
 * id: 115104866
 * Recitation: R04
 **/
public class Student {
    private String name; //students' names
    private double money; //amount of money the student has

    /**
     *    @param name of the students
     *    @param money that the students have
     *
     **/

    public Student(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public Student(){

    }

    /**
     * getter method for student name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getter method for amount of money the student has
     *
     * @return money
     */

    public double getMoney() {
        return money;
    }

    /**
     * setter method for student name
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter method for money
     * @param money
     */

    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * structures a string
     * @return a string of the description of the student
     */

    public String toString() {
        return "Name: " + name + " " + "Money: $" + money;
    }

    /**
     * boolean method to check whether two
     * students are equal
     * @param student
     * @return boolean value that determines whether
     * two students are equivalent to each other
     */

    public boolean Equals(Student student) {
        if (student == null) {
            return false;
        } else {
            return (student.getName().equals(name) && student.getMoney() == money);
        }

    }

    /**
     * clone method that copies a student info onto a new one
     * @return a deep copy of a student
     */
    public Student clone() {
        Student newStudent = new Student(this.name, this.money);
        return newStudent;
    }
}
