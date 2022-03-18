package at.htlleonding;

public class CarRace {
    private RaceSection[] mSections;

    public CarRace(RaceSection[] sections) {
        mSections = sections;
    }

    public void addCar(Car car) {
        mSections[0].addCar(car);
    }

    public void moveCar(Car car, int fields) {
        mSections[0].removeCar(car);
        mSections[1].addCar(car);
    }
}
