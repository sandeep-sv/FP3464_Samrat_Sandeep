public abstract class Vehicle {
    private String make;
    private String plate;
    private String color;
    private VehicleType category;

    public Vehicle(String make,String plate,String color,VehicleType category){
        this.make=make;
        this.plate=plate;
        this.color=color;
        this.category=category;
    }

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
enum VehicleType{
    Family,Sport,RACE,NOT_FOR_RACE
}
enum CarType{
    Sport,SUV,Hatchback,Minivan,Sedan
}
enum Gear{
    Automatic,Manual
}

class Car extends Vehicle{
    private Gear gear;
    private CarType type;

    public Car(String make, String plate, String color, VehicleType category,Gear gear,CarType type) {
        super(make, plate, color, category);
        this.gear=gear;
        this.type=type;
    }

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
class Motorcycle extends Vehicle{
    private boolean sidecar;

    public Motorcycle(String make, String plate, String color, VehicleType category,boolean sidecar) {
        super(make, plate, color, category);
        this.sidecar=sidecar;
    }

    public void setSidecar(boolean sidecar) {
        this.sidecar = sidecar;
    }

    public boolean getSidecar(){
        return sidecar;
    }

}
