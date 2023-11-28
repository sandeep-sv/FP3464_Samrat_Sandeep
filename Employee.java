
import java.time.*;
//abstract employee class
public abstract class Employee {
    //employee fields
    private final String name;
    private int birth_year;
    private double monthly_income;
    private double occupation_rate;
    private Vehicle vehicle;
    private Contract contract;

    //constant values for the fields
    static final int GAIN_FACTOR_CLIENT = 500;
    static final int GAIN_FACTOR_TRAVEL = 100;
    static final int GAIN_FACTOR_ERROR = 10;
    static final int GAIN_FACTOR_PROJECTS = 200;

    // employee class constructors
    public Employee(String name,int birth_year){
        this.name=name;
        this.birth_year=birth_year;
        this.occupation_rate=100;
        this.vehicle=null;
        display();
    }
    public Employee(String name,int birth_year,Vehicle vehicle){
        this.name=name;
        this.birth_year=birth_year;
        this.occupation_rate=100;
        this.vehicle=vehicle;
        display();
    }
    public Employee(String name,int birth_year, double occupation_rate){
        this.name=name;
        this.birth_year=birth_year;
        if (occupation_rate>100){
            this.occupation_rate=100;
        } else if (occupation_rate < 10) {
            this.occupation_rate=10;
        }
        else {
            this.occupation_rate=occupation_rate;
        }
        this.vehicle=null;
        display();

    }
    public Employee(String name,int birth_year, double occupation_rate,Vehicle vehicle){
        this.name=name;
        this.birth_year=birth_year;
        if (occupation_rate>100){
            this.occupation_rate=100;
        } else if (occupation_rate < 10) {
            this.occupation_rate=10;
        }
        else {
            this.occupation_rate=occupation_rate;
        }
        this.vehicle=vehicle;
        display();

    }
     // To calculate age
    public int age(){
        int present_year = Year.now().getValue();
        return (present_year-birth_year);
    }
    // function to display employee info and vehicle info
    public void empinfo(){
        System.out.println("-------------------------");
        System.out.println("Name: "+getName()+", a "+getClass().getSimpleName());
        System.out.println("Age:"+age());
        System.out.println("Employee Has a "+getVehicle().getClass().getSimpleName());
        System.out.println("\t- make: "+getVehicle().getMake());
        System.out.println("\t- plate: "+getVehicle().getPlate());
        System.out.println("\t- color: "+getVehicle().getColor());
        System.out.println("\t- category: "+getVehicle().getCategory());
        if (getVehicle().getClass().getSimpleName().equals("Car")){
            Car c = (Car)getVehicle();
            System.out.println("\t- gear type: "+c.getGear());
            System.out.println("\t- type: "+c.getType());
        }
        else{
            Motorcycle m = (Motorcycle)getVehicle();
            if(m.getSidecar()){
                System.out.println("\t- with sidecar");
            }
            else{
                System.out.println("\t- without sidecar");
            }
        }
    }
    public void display(){
        System.out.println("We have a new employee:"+this.getName()+", a "+this.getClass().getSimpleName());
    }
    //getter and setter methods
    public double getMonthly_income() {
        return monthly_income;
    }

    public String getName() {
        return name;
    }



    public void setOccupation_rate(double occupation_rate) {
        if (occupation_rate>100){
            this.occupation_rate=100;
        } else if (occupation_rate < 10) {
            this.occupation_rate=10;
        }
        else {
            this.occupation_rate=occupation_rate;
        }
    }

    public double getOccupation_rate() {
        return occupation_rate;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public abstract void getEmployeeInfo();

    // to assign contract to the employee
    public void signContract(Contract contract){

        this.contract=contract;
        this.monthly_income=contract.getMonthlyIncome();
    }

    public Contract getContract() {
        return contract;
    }
    // abstract method for contractinfo that will be implemented in below classes
    public abstract void contractInfo();


}
// manager class derived from employee
class Manager extends Employee{
    //manager fields
    private int num_of_travelled_days;
    private  int num_of_clients;
    // constructors
    public Manager(String name,int birth_year,int num_of_clients,int num_of_travelled_days){
        super(name,birth_year);
        this.num_of_travelled_days=num_of_travelled_days;
        this.num_of_clients=num_of_clients;
    }
    public Manager(String name,int birth_year,int num_of_clients,int num_of_travelled_days,Vehicle vehicle){
        super(name,birth_year,vehicle);
        this.num_of_travelled_days=num_of_travelled_days;
        this.num_of_clients=num_of_clients;
    }
    public Manager(String name,int birth_year,int num_of_clients,int num_of_travelled_days,double occupation_rate){
        super(name,birth_year,occupation_rate);
        this.num_of_travelled_days=num_of_travelled_days;
        this.num_of_clients=num_of_clients;
    }
    public Manager(String name,int birth_year,int num_of_clients,int num_of_travelled_days,double occupation_rate,Vehicle vehicle){
        super(name,birth_year,occupation_rate,vehicle);
        this.num_of_travelled_days=num_of_travelled_days;
        this.num_of_clients=num_of_clients;
    }

    //setter and getter methods
    public void setNum_of_clients(int num_of_clients) {
        this.num_of_clients = num_of_clients;
    }

    public void setNum_of_travelled_days(int num_of_travelled_days) {
        this.num_of_travelled_days = num_of_travelled_days;
    }

    public int getNum_of_clients() {
        return this.num_of_clients;
    }

    public int getNum_of_travelled_days() {
        return this.num_of_travelled_days;
    }
    // methods to calculate annual income 
    public double annualIncome(){
        return (((GAIN_FACTOR_TRAVEL*getNum_of_travelled_days())+(GAIN_FACTOR_CLIENT*getNum_of_clients()))+(getOccupation_rate()/100)
                *getMonthly_income()*12);
    }
    public void getEmployeeInfo(){
        empinfo();
        System.out.println(getName()+" has an Occupation rate: "+getOccupation_rate()+"% He/She travelled "
                +getNum_of_travelled_days()+" days and has brought "+getNum_of_clients()+" new clients.");
        System.out.println("His/Her Estimated annual income is: "+annualIncome());
    }

    @Override
    public void contractInfo() {
        if(getContract().getClass().getSimpleName().equals("Permanent")){
            Permanent p = (Permanent)getContract();
            String cs;
            if (p.get_civil_status()){
                cs="married";
            }
            else{
                cs="not married";
            }
            System.out.println(getName()+" is a "+getClass().getSimpleName()+". he/she is "+cs+" and he/she has "
                    +p.getNo_of_children()+" children");
            System.out.println("He/She has worked for "+p.getDays_worked()+" days and upon contract his/her monthly salary is "
                    +p.getMonthly_salary());
        }
        else{
            Temporary t = (Temporary) getContract();
            System.out.println(getName()+" is a "+getClass().getSimpleName()+". he/she is a "
                    +t.getClass().getSimpleName()+" employee with "+t.getHourly_wage()
                    +" hourly salary and he has worked for "+t.getHours_worked()+" hours");
        }

    }
}
// class tester derived from employee
class Tester extends Employee{
    // tester fields
    private int num_of_bugs;

    //constructors
    public Tester(String name, int birth_year,int num_of_bugs,Vehicle vehicle){
        super(name, birth_year,vehicle);
        this.num_of_bugs=num_of_bugs;
    }
    public Tester(String name, int birth_year, int num_of_bugs,double occupation_rate) {
        super(name, birth_year,occupation_rate);
        this.num_of_bugs=num_of_bugs;
    }
    public Tester(String name, int birth_year,int num_of_bugs,double occupation_rate,Vehicle vehicle) {
        super(name, birth_year,occupation_rate,vehicle);
        this.num_of_bugs=num_of_bugs;
    }

    //setter and getter functions
    public void setNum_of_bugs(int num_of_bugs) {
        this.num_of_bugs = num_of_bugs;
    }

    public int getNum_of_bugs() {
        return num_of_bugs;
    }

    public double annualIncome(){
        return (((GAIN_FACTOR_ERROR*num_of_bugs))+(getOccupation_rate()/100)*getMonthly_income()*12);

    }
    public void getEmployeeInfo(){
        empinfo();
        System.out.println(getName()+" has an Occupation rate: "+getOccupation_rate()+" and corrected "
                +getNum_of_bugs()+" bugs");
        System.out.println("His/Her Estimated annual income is: "+annualIncome());
    }
    public void contractInfo() {
        if(getContract().getClass().getSimpleName().equals("Permanent")){
            Permanent p = (Permanent)getContract();
            String cs;
            if (p.get_civil_status()){
                cs="married";
            }
            else{
                cs="not married";
            }
            System.out.println(getName()+" is a "+getClass().getSimpleName()+". he/she is "+cs+" and he/she has "
                    +p.getNo_of_children()+" children");
            System.out.println("He/She has worked for "+p.getDays_worked()+" days and upon contract his/her monthly salary is "
                    +p.getMonthly_salary());
        }
        else{
            Temporary t = (Temporary) getContract();
            System.out.println(getName()+" is a "+getClass().getSimpleName()+". he/she is a "
                    +t.getClass().getSimpleName()+" employee with "+t.getHourly_wage()
                    +" hourly salary and he has worked for "+t.getHours_worked()+" hours");
        }

    }
}
//class programmer derived from employee
class Programmer extends Employee{
    //programmer fields
    private int num_of_projects;
    //constructors
    public Programmer(String name, int birth_year,int num_of_projects){
        super(name, birth_year);
        this.num_of_projects=num_of_projects;
    }
    public Programmer(String name, int birth_year,int num_of_projects,Vehicle vehicle){
        super(name, birth_year,vehicle);
        this.num_of_projects=num_of_projects;
    }
    public Programmer(String name, int birth_year, int num_of_projects,double occupation_rate) {
        super(name, birth_year,occupation_rate);
        this.num_of_projects=num_of_projects;
    }
    public Programmer(String name, int birth_year, int num_of_projects,double occupation_rate,Vehicle vehicle) {
        super(name, birth_year,occupation_rate,vehicle);
        this.num_of_projects=num_of_projects;
    }

    //setter and getter methods
    public void setNum_of_projects(int num_of_projects) {
        this.num_of_projects = num_of_projects;
    }

    public int getNum_of_projects() {
        return num_of_projects;
    }
    public double annualIncome(){
        return (((GAIN_FACTOR_PROJECTS*num_of_projects))+(getOccupation_rate()/100)*getMonthly_income()*12);

    }
    public void getEmployeeInfo(){
        empinfo();
        System.out.println(getName()+" has an Occupation rate: "+getOccupation_rate()
                +" and completed "+getNum_of_projects()+" projects");
        System.out.println("His/Her Estimated annual income is: "+annualIncome());
    }
    public void contractInfo() {
        if(getContract().getClass().getSimpleName().equals("Permanent")){
            Permanent p = (Permanent)getContract();
            String cs;
            if (p.get_civil_status()){
                cs="married";
            }
            else{
                cs="not married";
            }
            System.out.println(getName()+" is a "+getClass().getSimpleName()+". he/she is "+cs+" and he/she has "
                    +p.getNo_of_children()+" children");
            System.out.println("He/She has worked for "+p.getDays_worked()+" days and upon contract his/her monthly salary is "
                    +p.getMonthly_salary());
        }
        else{
            Temporary t = (Temporary) getContract();
            System.out.println(getName()+" is a "+getClass().getSimpleName()+". he/she is a "
                    +t.getClass().getSimpleName()+" employee with "+t.getHourly_wage()
                    +" hourly salary and he has worked for "+t.getHours_worked()+" hours");
        }

    }
}
