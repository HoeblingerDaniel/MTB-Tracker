package at.htlleonding;

import java.util.HashMap;
import java.util.Map;

public class FakeRaceSection implements RaceSection {
    private int mNumberOfAddCarsCalled;
    private int mNumberOfRemoveCarsCalled;
    private int mFields;
    private Map<Car, Integer> mCars = new HashMap<>();

    public FakeRaceSection(int fields) {
        mFields = fields;
    }

    public FakeRaceSection() {}

    public int numberOfAddCarsCalled() {
        return mNumberOfAddCarsCalled;
    }

    public int numberOfRemoveCarsCalled() {
        return mNumberOfRemoveCarsCalled;
    }

    @Override
    public void addCar(Car car) {
        mNumberOfAddCarsCalled++;
        mCars.put(car, 0);
    }

    @Override
    public void removeCar(Car car) {
        mNumberOfRemoveCarsCalled++;
        mCars.remove(car);
    }

    @Override
    public int move(Car car, int fields) {
        //mCars.merge(car, fields, Integer::sum); same as replaceb
        mCars.replace(car, mCars.get(car) + fields);
        return mCars.get(car) > mFields ? mCars.get(car) - mFields : 0;
    }
}
