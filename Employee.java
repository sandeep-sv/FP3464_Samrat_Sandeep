import java.time.Year;

public class Employee {
    private final String name;
    private int birth_year;
    private double monthly_income;
    private double occupation_rate;

    public Employee(String name,int birth_year, double occupation_rate) {
        this.name = name;
        this.birth_year = birth_year;
        if (occupation_rate > 100) {
            this.occupation_rate = 100;
        } else if (occupation_rate < 10) {
            this.occupation_rate = 10;
        } else {
            this.occupation_rate = occupation_rate;
        }
        display();
    }
    public Employee(String name,int birth_year){
        this.name=name;
        this.birth_year=birth_year;
        this.occupation_rate=100;
        display();
    }

    public int age(){
        int present_year = Year.now().getValue();
        return (present_year-birth_year);
    }
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
    public void display(){
        System.out.println("We have a new employee:"+this.getName()+", a "+this.getClass().getSimpleName());
    }
}

class Manager extends Employee{
    private int num_of_travelled_days;
    private  int num_of_clients;

    public Manager(String name,int birth_year,int num_of_clients,int num_of_travelled_days,double occupation_rate){
        super(name,birth_year,occupation_rate);
        this.num_of_travelled_days=num_of_travelled_days;
        this.num_of_clients=num_of_clients;
    }
    public Manager(String name,int birth_year,int num_of_clients,int num_of_travelled_days){
        super(name,birth_year);
        this.num_of_travelled_days=num_of_travelled_days;
        this.num_of_clients=num_of_clients;
    }

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

}

class Tester extends Employee{
    private int num_of_bugs;
    public Tester(String name, int birth_year, int num_of_bugs,double occupation_rate) {
        super(name, birth_year,occupation_rate);
        this.num_of_bugs=num_of_bugs;
    }
    public void setNum_of_bugs(int num_of_bugs) {
        this.num_of_bugs = num_of_bugs;
    }

    public int getNum_of_bugs() {
        return num_of_bugs;
    }
}

class Programmer extends Employee{
    private int num_of_projects;
    public Programmer(String name, int birth_year, int num_of_projects,double occupation_rate) {
        super(name, birth_year,occupation_rate);
        this.num_of_projects=num_of_projects;
    }
    public Programmer(String name, int birth_year, int num_of_projects) {
        super(name, birth_year);
        this.num_of_projects=num_of_projects;
    }
    public void setNum_of_projects(int num_of_projects) {
        this.num_of_projects = num_of_projects;
    }
    public int getNum_of_projects() {
        return num_of_projects;
    }
}