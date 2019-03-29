package com.ashi.xebiatest.utils;

import com.google.gson.Gson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.*;

public class TestUtilsTest {

    @Inject
    Gson mGson;

    @Before
    public void setUp() throws Exception {
        TestUtils.loadJson("mock/nyMockListDubai.json",mGson);
        TestUtils.loadggnJson("mock/nyMockListGgn.json",mGson);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void loadJson() {

    }

    @Test
    public void loadTrackLeadsJson() {
    }
}