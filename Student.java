public class Student{
    private int id;
    private String name;
    private int TamilMark,EnglishMark,MathsMark,ScienceMark,SocialMark,TotalMark;
    private float Averagemark;
    private boolean failsubject;
    //constructor
    public Student(int id,String name,int tamil,int english,int maths,int sciece,int social) {
        this.id=id;
        this.name=name;
        this.TamilMark=tamil;
        this.EnglishMark=english;
        this.MathsMark=maths;
        this.ScienceMark=sciece;
        this.SocialMark=social;
        this.TotalMark = tamil+english+maths+sciece+social; 
        this.failsubject=checkFailSubject(tamil,english,maths,sciece,social); //total
        this.Averagemark = (float)(tamil + english + maths + sciece + social) / 5; //average
    }
    //fail calculation
    private boolean checkFailSubject(int tamil, int english, int maths, int science, int social) {
        // Example  if any subject < 35, it's a fail
        return tamil < 35 || english < 35 || maths < 35 || science < 35 || social < 35;
    }

    //Encapsulation for get data
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int gettamilmark(){
        return TamilMark;
    }
    public int getenglishmark(){
        return EnglishMark;
    }
    public int getmathsmark(){
        return MathsMark;
    }
    public int getsciencemark(){
        return ScienceMark;
    }
    public int getsocialmark(){
        return SocialMark;
    }
    public int gettotal(){
        return TotalMark;
    }
    public float  getaverage(){
        return  Averagemark;
    }
    public boolean getfail(){
        return failsubject;
    }

    //Encapsulation for set data
    public void setName(String name){
        this.name=name;
    }
    public void settamilmark(int mark){
         this.TamilMark = mark;
    }
    public void setenglishmark(int mark){
        this.EnglishMark=mark;
    }
    public void setmathsmark(int mark){
        this.MathsMark = mark;
    }
    public void setsciencemark(int mark){
        this.ScienceMark=mark;
    }
    public void setsocialmark(int mark){
        this.SocialMark = mark;
    }
    public void settotal(){
        this.TotalMark = TamilMark+EnglishMark+MathsMark+ScienceMark+SocialMark;
        this.Averagemark= (float)(TamilMark+EnglishMark+MathsMark+ScienceMark+SocialMark) / 5;
    }
    public void setfail(){
        this.failsubject=checkFailSubject(TamilMark,EnglishMark,MathsMark,ScienceMark,SocialMark);
    }

    //display method
    public void display(){
        boolean fail=false;
        System.out.println("Student Id : "+id );
        System.out.println("Student Name : "+name);
        System.out.println("Tamil Mark : "+TamilMark);
        System.out.println("English Mark : "+EnglishMark);
        System.out.println("Maths Mark : "+MathsMark);
        System.out.println("Science Mark : "+ScienceMark);
        System.out.println("Social Mark : "+SocialMark);
        System.out.println("-------------------------------------------");
        System.out.println("Total Mark : "+ TotalMark); //total
        if(!(TamilMark >=35)){ //incase mark will be bellow 35
            fail=true; 
            System.out.println("Tamil Fail");
        }
        if(!(EnglishMark >=35)){
            fail=true;
            System.out.println("English Fail");
        }
        if(!(MathsMark >=35)){
            fail=true;
            System.out.println("Maths Fail");
        }
        if(!(ScienceMark >=35)){
            fail=true;
            System.out.println("Science Fail");
        }
        if(!(MathsMark >=35)){
            fail=true;
            System.out.println("Social Fail");
        }
        if(!fail){ // fail=false
            System.out.println("All Pass");
        }
        System.out.println("Average : "+Averagemark);
        System.out.println("-------------------------------------------");
    }
    //over ride a string method
    @Override
    public String toString(){
        String PassorFail = "";
        if(failsubject){
            PassorFail ="Fail";
        }else{
            PassorFail = "Pass";
        }
        return "Student id : "+id +"\nStudent Name : "+name+"\nTamil Mark : "+TamilMark+"\nEnglish Mark : "+EnglishMark+"\nMaths Mark : "+MathsMark
        +"\nScience Mark : "+ScienceMark+"\nSocial Mark : "+SocialMark+"\ntotal : "+TotalMark +"\nAverage : "+Averagemark +"\nResult : "+PassorFail
        +"\n*********************************************************";
    }
    
}