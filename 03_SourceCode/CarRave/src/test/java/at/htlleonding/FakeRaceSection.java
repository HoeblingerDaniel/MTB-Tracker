package at.htlleonding;

public class FakeRaceSection implements RaceSection {
    private int mNumberOfAddCarsCalled;
    private int mNumberOfRemoveCarsCalled;

    public int numberOfAddCarsCalled() {
        return mNumberOfAddCarsCalled;
    }

    public int numberOfRemoveCarsCalled() {
        return mNumberOfRemoveCarsCalled;
    }

    @Override
    public void addCar(Car car) {
        mNumberOfAddCarsCalled++;
    }

    @Override
    public void removeCar(Car car) {
        mNumberOfRemoveCarsCalled++;
    }
}
