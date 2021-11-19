package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobsSchedulerTest
{
    @Test
    public void itShouldReturnA_GivenA()
    {
        //arrange
        var sut = new JobsScheduler();
        sut.registerJob("A");
        //act
        sut.sort();
        //assert
        assertEquals("A", sut.getList());
    }
}
