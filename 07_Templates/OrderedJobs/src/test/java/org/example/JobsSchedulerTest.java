package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobsSchedulerTest
{
    @Test
    public void itShouldReturnA_GivenA() {
        //arrange
        var sut = new JobsScheduler();
        sut.registerJob("A");
        //act
        sut.sort();
        //assert
        assertEquals("A", sut.getList());
    }

    @Test
    public void itShouldReturnAB_GivenAB() {
        var sut = new JobsScheduler();
        sut.registerJob("A");
        sut.registerJob("B");

        sut.sort();

        assertEquals("AB", sut.getList());
    }

    @Test
    public void itShouldReturnABC_GivenABC() {
        var sut = new JobsScheduler();
        sut.registerJob("A");
        sut.registerJob("B");
        sut.registerJob("C");

        sut.sort();

        assertEquals("ABC", sut.getList());
    }

    @Test
    public void itShouldReturnAB_GivenBDependsOnA() {
        var sut = new JobsScheduler();
        sut.registerJob("B", "A");

        sut.sort();

        assertEquals("AB", sut.getList());
    }

    @Test
    public void itShouldReturnABC_GivenCDependsOnB_And_BDependsOnA() {
        var sut = new JobsScheduler();
        sut.registerJob("B", "A");
        sut.registerJob("C", "B");

        sut.sort();

        assertEquals("ABC", sut.getList());
    }

    @Test
    public void itShouldReturnAB_GivenABB() {
        var sut = new JobsScheduler();
        sut.registerJob("A");
        sut.registerJob("B");
        sut.registerJob("B");

        sut.sort();

        assertEquals("AB", sut.getList());
    }

    @Test
    public void itShouldReturnABC_GivenBDependsOnA_And_CDependsOnB() {
        var sut = new JobsScheduler();
        sut.registerJob("C", "B");
        sut.registerJob("B", "A");

        sut.sort();

        assertEquals("ABC", sut.getList());
    }

    @Test
    public void itShouldReturnBA_GivenBA() {
        var sut = new JobsScheduler();
        sut.registerJob("B");
        sut.registerJob("A");

        sut.sort();

        assertEquals("BA", sut.getList());
    }
}
