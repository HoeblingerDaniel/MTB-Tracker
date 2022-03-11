package at.htlleonding;

public class FakeRaceSection implements RaceSection {
    private int mNumberOfAddCarsCalled;

    public int numberofAddCarsCalled() {
        return mNumberOfAddCarsCalled;
    }

    @Override
    public void addCar(Car car) {
        mNumberOfAddCarsCalled++;
    }
}
