public abstract class Contract {

    public abstract double getMonthlyIncome();
}
class Permanent extends Contract{
    private int days_worked;
    private double monthly_salary;
    private int no_of_children;
    private boolean civil_status;
    private double monthly_premium;
    public Permanent(int no_of_children,boolean civil_status,double monthly_salary,double monthly_premium,int days_worked){
        this.days_worked=days_worked;
        this.monthly_salary=monthly_salary;
        this.no_of_children=no_of_children;
        this.civil_status=civil_status;
        this.monthly_premium=monthly_premium;
    }

    public void setDays_worked(int days_worked) {
        this.days_worked = days_worked;
    }

    public void setCivil_status(boolean civil_status) {
        this.civil_status = civil_status;
    }

    public void setMonthly_premium(double monthly_premium) {
        this.monthly_premium = monthly_premium;
    }

    public void setMonthly_salary(double monthly_salary) {
        this.monthly_salary = monthly_salary;
    }

    public void setNo_of_children(int no_of_children) {
        this.no_of_children = no_of_children;
    }

    public double getMonthly_premium() {
        return monthly_premium;
    }

    public double getMonthly_salary() {
        return monthly_salary;
    }

    public int getDays_worked() {
        return days_worked;
    }

    public int getNo_of_children() {
        return no_of_children;
    }
    public boolean get_civil_status(){
        return civil_status;
    }

    @Override
    public double getMonthlyIncome() {
        if (get_civil_status()){
            return (getMonthly_salary()+(getNo_of_children()*getMonthly_premium()))*((double) getDays_worked() /20);
        }
        else{
            return (getMonthly_salary())*((double) getDays_worked() /20);
        }
    }
}
class Temporary extends Contract{
    private int hours_worked;
    private double hourly_wage;

    public Temporary(double hourly_wage,int hours_worked){
        this.hours_worked=hours_worked;
        this.hourly_wage=hourly_wage;
    }

    public void setHourly_wage(double hourly_wage) {
        this.hourly_wage = hourly_wage;
    }

    public void setHours_worked(int hours_worked) {
        this.hours_worked = hours_worked;
    }

    public double getHourly_wage() {
        return hourly_wage;
    }

    public int getHours_worked() {
        return hours_worked;
    }

    @Override
    public double getMonthlyIncome() {
        return getHourly_wage()*getHours_worked();
    }


}
