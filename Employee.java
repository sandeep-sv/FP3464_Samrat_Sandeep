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

