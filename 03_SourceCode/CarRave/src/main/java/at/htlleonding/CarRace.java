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
        if (mSections[0].move(car, fields) > 0) {
            mSections[1].addCar(car);
            mSections[0].removeCar(car);
        }
    }
}
