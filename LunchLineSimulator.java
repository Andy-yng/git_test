/**
 * This class simulates the lunch line
 *
 * @author Andy Yang
 * email: andy.yang.2@stonybrook.edu
 * id: 115104866
 * Recitation: R04
 **/
import java.util.Scanner;
public class LunchLineSimulator {
    static StudentLine realityA = new StudentLine();
    static StudentLine realityB = new StudentLine();
    static StudentLine current = realityA;
    public static void main(String[] args) throws EmptyLineException,
            throwDeanException {


        System.out.println("Welcome to the Middle School where you are the master of the lunch line," +
                " and you may subject your angsty kids to whatever form of culinary torture best fits your mood. " +
                "You are in Reality A");
        System.out.println("Menu:");
        System.out.println("A) Add a student to the line at the end");
        System.out.println("C) Have a new student cut a friend");
        System.out.println("T) Have two students trade places");
        System.out.println("B) Have the bully remove a student");
        System.out.println("U) Update a student's money amount");
        System.out.println("S) Serve a student");
        System.out.println("P) Print the current reality's lunch line");
        System.out.println("O) Switch to the other reality");
        System.out.println("E) Check if the realities are equal");
        System.out.println("D) Duplicate this reality into the other reality");
        System.out.println("G) Quit middle school and move on to real life.");
        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
        }
        boolean playGame = false;
        while (!playGame) {
            Scanner stdin = new Scanner(System.in);
            System.out.println("Please select an option: ");
            String option = stdin.nextLine();

            if (option.equals("A") || option.equals("a")) {
                add();
                Student student = new Student("josh", 1.3);
            } else if (option.equals("C") || option.equals("c")) {
                skipLine();
            } else if (option.equals("T") || option.equals("t")) {
                tradePlace();
            } else if (option.equals("B") || option.equals("B")) {
                removeStudent();
            } else if (option.equals("U") || option.equals("u")) {
                System.out.println("C");
            } else if (option.equals("S") || option.equals("s")) {
                serve();
            } else if (option.equals("P") || option.equals("p")) {
                System.out.println("C");
            } else if (option.equals("O") || option.equals("o")) {
                swapReality();
            } else if (option.equals("E") || option.equals("e")) {
                System.out.println("C");
            } else if (option.equals("D") || option.equals("d")) {
                System.out.println("C");
            } else if (option.equals("Q") || option.equals("q")) {
                System.out.println("You are now leaving the Middle School Lunch Line Simulator. +" +
                        " We congratulate you on your decision to " +
                        "do something more productive with your time.");
                playGame = true;
            } else {
                System.out.print("Pick an option within the menu");
            }
        }

    }

    /**
     * adds students to the line
     * @throws throwDeanException
     */
    public static void add() throws throwDeanException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of student: ");
        String name = sc.nextLine();
        Scanner st = new Scanner(System.in);
        System.out.println("Enter amount of money: ");
        double money = st.nextDouble();
        if (current.numStudents() == current.getCAPACITY()) {
            throw new throwDeanException();
        }
        Student newStudent = new Student(name, money);
        current.addStudent(current.numStudents(), newStudent);
        System.out.println(name + " has been added to line.");
    }

    /**
     * the method allows a student to cut in front of his friend
     * @throws throwDeanException
     */

    public static void skipLine() throws throwDeanException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of student: ");
        String name = sc.nextLine();
        Scanner stdin = new Scanner(System.in);
        System.out.println("Enter amount of money: ");
        double money = stdin.nextDouble();
        Student newStudent = new Student(name, money);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the position in line: ");
        int index = scanner.nextInt();
        index -= 1;
        if (index + 1 > current.numStudents()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (!(current.numStudents() == current.getCAPACITY())) {
            System.out.println(name + " cut " + current.getStudent(index).getName() +
                    " in line and is now in position " + (index + 1) + "and " + name + " has $" + money);
        }
        current.addStudent(index, newStudent);
    }

    /**
     * the method swaps the position between two students
     * @throws IllegalArgumentException
     */
    public static void tradePlace() throws IllegalArgumentException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the position of the first student: ");
        int index1 = sc.nextInt();
        index1-= 1;
        System.out.println("Enter the position of the second student: ");
        int index2= sc.nextInt();
        index2 -= 1;
        if (index1 < 0 || index1 >= current.numStudents() ||
                index2 < 0 || index2 >= current.numStudents()) {
            throw new IllegalArgumentException("Index out of bounds.");
        }
        current.swapStudents(index1, index2);
        System.out.println("The two students have swapped");
    }

    /**
     * the following method allows a bully to bully a student off the line
     * @throws EmptyLineException
     */
    public static void removeStudent() throws EmptyLineException {
        Scanner sc = new Scanner(System.in);
        System.out.println("What position of student to bully: ");
        int index = sc.nextInt();
        index -= 1;
        if (index >= 0 && index < current.numStudents()) {
            Student removedStudent = current.removeStudent(index);
            System.out.println(removedStudent.getName() + " has been removed");
        } else {
            System.out.println("Invalid index. No student found at index " + (index + 1));
        }
    }

    /**
     * serves a student and removes him/her from the lunch line
     * @throws NullPointerException
     * @throws EmptyLineException
     */

    public static void serve() throws NullPointerException, EmptyLineException {
        Student served = new Student();
        if (served == null){
            throw new NullPointerException("No one to serve");
        } else {
            System.out.println(served.getName() + " has been served");
            current.removeStudent(0);
        }
    }
    public static void swapReality(){
        if (current == realityA){
            current = realityB;
            System.out.print("Reality has been swapped");
        }
        if (current == realityB){
            current = realityB;
            System.out.print("Reality has been swapped");
        }
    }


}