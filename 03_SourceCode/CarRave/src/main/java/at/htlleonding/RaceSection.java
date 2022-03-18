package at.htlleonding;

public interface RaceSection {
    void addCar(Car car);
    void removeCar(Car car);
    int move(Car car, int fields);
}
