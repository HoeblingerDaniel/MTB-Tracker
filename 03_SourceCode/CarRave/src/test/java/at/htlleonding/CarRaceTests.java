package at.htlleonding;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class CarRaceTests {
    @Test
    public void itShouldCallAddCarToFirstSection_GivenCarAddedToRace() {
        FakeRaceSection[] sections = {new FakeRaceSection(), new FakeRaceSection()};
        var sut = new CarRace(sections);
        sut.addCar(new FakeCar());

        assertThat(sections[0].numberOfAddCarsCalled(), is(equalTo(1)));
    }

    @Test
    public void itShouldAddTwoCarsToFirstSection_GivenTwoCarsAddedToRace() {
        FakeRaceSection[] sections = {new FakeRaceSection(), new FakeRaceSection()};
        var sut = new CarRace(sections);
        sut.addCar(new FakeCar());
        sut.addCar(new FakeCar());

        assertThat(sections[0].numberOfAddCarsCalled(), is(equalTo(2)));
    }

    @Test
    public void itShouldAddCarToSecondRaceSection_AndRemoveItFromFirstSection_GivenCarMoved() {
        FakeRaceSection[] sections = {new FakeRaceSection(), new FakeRaceSection()};
        CarRace race = new CarRace(sections);
        Car car = new FakeCar();

        race.addCar(car);
        race.moveCar(car, 60);

        assertEquals(1, sections[1].numberOfAddCarsCalled());
        assertEquals(1, sections[0].numberOfRemoveCarsCalled());
    }

    @Test
    public void itShouldNotMoveCarBetweenSections_GivenCarMovedTooLittle() {
        FakeRaceSection[] sections = {new FakeRaceSection(), new FakeRaceSection()};
        CarRace race = new CarRace(sections);
        Car car = new FakeCar();

        race.addCar(car);
        race.moveCar(car, 10);

        assertEquals(1, sections[0].numberOfAddCarsCalled());
        assertEquals(0, sections[1].numberOfAddCarsCalled());
        assertEquals(0, sections[0].numberOfRemoveCarsCalled());
    }
}
