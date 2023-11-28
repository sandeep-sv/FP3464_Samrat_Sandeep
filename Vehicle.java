// abstract class for vehicle 
public abstract class Vehicle {
    //vehicle fields
    private String make;
    private String plate;
    private String color;
    private VehicleType category;

    //constructor
    public Vehicle(String make,String plate,String color,VehicleType category){
        this.make=make;
        this.plate=plate;
        this.color=color;
        this.category=category;
    }
    //getter and setter methods
    public String getMake() {
        return make;
    }

    public String getPlate() {
        return plate;
    }

    public String getColor() {
        return color;
    }
    public VehicleType getCategory() {
        return category;
    }


}
//enum for vehicle type, cartype and gear type
enum VehicleType{
    Family,Sport,RACE,NOT_FOR_RACE
}
enum CarType{
    Sport,SUV,Hatchback,Minivan,Sedan
}
enum Gear{
    Automatic,Manual
}

// class car derived from vehicle
class Car extends Vehicle{
    // car class fields
    private Gear gear;
    private CarType type;
    //constructor
    public Car(String make, String plate, String color, VehicleType category,Gear gear,CarType type) {
        super(make, plate, color, category);
        this.gear=gear;
        this.type=type;
    }
    //setter and getter functions
    public Gear getGear() {
        return gear;
    }

    public CarType getType() {
        return type;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    public void setType(CarType type) {
        this.type = type;
    }
}
//motorcycle class derived from vehicle
class Motorcycle extends Vehicle{
    // motorcycle class fields
    private boolean sidecar;
    //constructor
    public Motorcycle(String make, String plate, String color, VehicleType category,boolean sidecar) {
        super(make, plate, color, category);
        this.sidecar=sidecar;
    }
    //setter and getter methods
    public void setSidecar(boolean sidecar) {
        this.sidecar = sidecar;
    }

    public boolean getSidecar(){
        return sidecar;
    }

}
