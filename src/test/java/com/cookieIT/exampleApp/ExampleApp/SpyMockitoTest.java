package com.cookieIT.exampleApp.ExampleApp;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SpyMockitoTest {

    @Spy
    private final List<Integer> testList  =Lists.newArrayList(1,2,3, null, 5);

    @Test
    public void test1(){
        when(testList.get(0)).thenReturn(8);

        Assert.assertTrue(testList.get(0) == 8);
        Assert.assertFalse(testList.get(0) == 1);
    }

    @Test
    public void test2(){
        Assert.assertTrue(testList.get(0) == 1);
    }

}
