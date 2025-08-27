import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class StudentManagement {
    private Student[] Studentarr; //create a array for student class
    private int count;

    //constructor
    public StudentManagement(int storesize) {
        this.Studentarr = new Student[storesize]; //set a size of array
        count=0;
    }
    //add method
    public void addStudent(Student student){
        if(count<Studentarr.length){
            Studentarr[count++] = student; //add a student to array Studentarr[1]={1,"Manikandan",100,100,100,100,100}
            System.out.println("Student details added successfully....");
        }else{
            System.out.println("Students array fulled");
        }
    }
    //display method
    public void display(){
        if(count!=0){
            for(int i=0;i<count;i++){
                Studentarr[i].display();
            }
        }else{
            System.out.println("Data not found");
        }
    }
    //Search method
    public void searchStudent(int id){
        boolean idfound=false;
        if(count<Studentarr.length){
            for(int i=0;i<count;i++){
                if(Studentarr[i].getId() == id){
                    idfound=true;
                    System.out.println("Student id : "+id);
                    System.out.println("Student Name : "+Studentarr[i].getName());
                    System.out.println("Tamil Mark : "+Studentarr[i].gettamilmark());
                    System.out.println("English Mark : "+Studentarr[i].getenglishmark());
                    System.out.println("Maths Mark : "+Studentarr[i].getmathsmark());
                    System.out.println("Science Mark : "+Studentarr[i].getsciencemark());
                    System.out.println("Social Mark : "+Studentarr[i].getsocialmark());
                    System.out.println("------------------------------------------------");
                    System.out.println("Total Mark : "+Studentarr[i].gettotal());
                    System.out.println("Student Fail : "+Studentarr[i].getfail());
                    System.out.println("Average : "+Studentarr[i].getaverage());
                    System.out.println("-------------------------------------------------");
                }
            }
            if(!idfound){
                System.out.println("Invalid id");
            }
        }else{
            System.out.println("No data found");
        }
    }
    //update method
    public void update(int id, String name,int tamil,int english,int maths,int sciece,int social){
        boolean idfound= false;
        if(count<Studentarr.length){
            for(int i=0;i<count;i++){
                if(Studentarr[i].getId() == id){
                    Studentarr[i].setName(name);
                    Studentarr[i].settamilmark(tamil);
                    Studentarr[i].setenglishmark(english);
                    Studentarr[i].setmathsmark(maths);
                    Studentarr[i].setsciencemark(sciece);
                    Studentarr[i].setsocialmark(social);
                    Studentarr[i].settotal();
                }
            }
            if(!idfound){
                System.out.println("Invalid id");
            }
        }else{
            System.out.println("Invalid id");
        }
    }
    //Delete method
    public void delete(int id){
        boolean idfound= false;
        if(count<Studentarr.length){
            for(int i=0;i<count;i++){
                if(Studentarr[i].getId()==id){
                    idfound=true;
                    for(int j=i;j<count-1;j--){
                        Studentarr[j]=Studentarr[j+1]; //skip the current data
                    }
                    count--;
                    return;
                }
            }
            if(!idfound){
                System.out.println("Invalid id");
            }
        }else{
            System.out.println("No data found");
        }
    }
    //write a file
    public void file(){
        if(count!=0){
            for (int i = 0; i < count; i++) {
                try {
                    Files.write(Path.of("Student.txt"), 
                    Studentarr[i].toString().getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
                    System.out.println("Data written to file successfully...");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }


    //main function
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Welcome to Student Management System");
        System.out.println("How many students you upload");
        int size=scanner.nextInt();
        StudentManagement obj1 = new StudentManagement(size); //ceare a object
        while(true){
            System.out.println("??????????????????????????????????????????????????????????????????????");
            System.out.println("Press 1 to add student \nPress 2 to Display student\nPress 3 to Edit Student\nPress 4 to Delete Student\nPress 5 to Search Student\nPress 6 to Download student file\npress 7 to exit");
            int choice=scanner.nextInt(); //get a choice to user
            System.out.println("??????????????????????????????????????????????????????????????????????");
            scanner.nextLine();
            switch (choice) {
               case 1 ->{ //switch expression
                System.out.println("Enter Student id");
                int id= scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Student name");
                String name=scanner.nextLine();
                if(!name.matches("[a-zA-Z ]+")){ //check valid name
                    System.out.println("Invalid name");
                    break;
                }
                System.out.println("Enter Tamil mark");
                int tamil =scanner.nextInt();
                if(!mark(tamil)){ //validate method calling
                    System.out.println("Enter a valid Tamil Mark");
                    break;
                }
                System.out.println("Enter English mark");
                int english =scanner.nextInt();
                if(!mark(english)){
                    System.out.println("Enter a valid English Mark");
                    break;
                }
                System.out.println("Enter Maths mark");
                int maths =scanner.nextInt();
                if(!mark(maths)){
                    System.out.println("Enter a valid Maths Mark");
                    break;
                }
                System.out.println("Enter Science mark");
                int sciece =scanner.nextInt();
                if(!mark(sciece)){
                    System.out.println("Enter a valid Science Mark");
                    break;
                }
                System.out.println("Enter Social mark");
                int social =scanner.nextInt();
                if(!mark(social)){
                    System.out.println("Enter a valid Social Mark");
                    break;
                }
                Student obj=new Student(id, name, tamil, english, maths, sciece, social); //create a object for student class
                obj1.addStudent(obj); //call a add method
               }
               case 2 ->{obj1.display();} //display 
               case 3 ->{
               System.out.println("Enter Student id");
                int id= scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Student name");
                String name=scanner.nextLine();
                if(!name.matches("[a-zA-Z ]+")){ //check valid name
                    System.out.println("Invalid name");
                    break;
                }
                System.out.println("Enter Tamil mark");
                int tamil =scanner.nextInt();
                if(!mark(tamil)){ //validate method calling
                    System.out.println("Enter a valid Tamil Mark");
                    break;
                }
                System.out.println("Enter English mark");
                int english =scanner.nextInt();
                if(!mark(english)){
                    System.out.println("Enter a valid English Mark");
                    break;
                }
                System.out.println("Enter Maths mark");
                int maths =scanner.nextInt();
                if(!mark(maths)){
                    System.out.println("Enter a valid Maths Mark");
                    break;
                }
                System.out.println("Enter Science mark");
                int sciece =scanner.nextInt();
                if(!mark(sciece)){
                    System.out.println("Enter a valid Science Mark");
                    break;
                }
                System.out.println("Enter Social mark");
                int social =scanner.nextInt();
                if(!mark(social)){
                    System.out.println("Enter a valid Social Mark");
                    break;
                }
                obj1.update(id,name, tamil, english, maths, sciece, social); //call update method
               }
               case 4->{
                System.out.println("Enter student id for delete data");
                int id= scanner.nextInt();
                obj1.delete(id); //call delete method
                }
                case 5->{
                System.out.println("Enter student id for delete data");
                int id= scanner.nextInt();
                obj1.searchStudent(id); //call search method
                }
                case 6->{obj1.file();}
                case 7->{return;} //exit the loop
                default ->{System.out.println("Invalid choice try again");}
            }
        }
    }
    //validation method
    private static boolean  mark(int mark){
        if(mark>0 & mark<=100){
            return true;
        }
        return false;
    }
     
}
