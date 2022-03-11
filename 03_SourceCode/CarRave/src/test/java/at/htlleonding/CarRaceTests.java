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

        assertThat(sections[0].numberofAddCarsCalled(), is(equalTo(1)));
    }

    @Test
    public void itShouldAddTwoCarsToFirstSection_GivenTwoCarsAddedToRace() {
        FakeRaceSection[] sections = {new FakeRaceSection(), new FakeRaceSection()};
        var sut = new CarRace(sections);
        sut.addCar(new FakeCar());
        sut.addCar(new FakeCar());

        assertThat(sections[0].numberofAddCarsCalled(), is(equalTo(2)));
    }
}
