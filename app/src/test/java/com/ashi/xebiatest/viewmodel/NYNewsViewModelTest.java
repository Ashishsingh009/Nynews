package com.ashi.xebiatest.viewmodel;

import com.ashi.xebiatest.models.NyResponse;
import com.ashi.xebiatest.models.ResultsItem;
import com.google.gson.Gson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import javax.inject.Inject;

import static org.junit.Assert.*;

public class NYNewsViewModelTest {

    private NyResponse newsResponse;
    private List<ResultsItem> resultsItem;


    @Inject
    Gson mGson;
    @Before
    public void setUp() throws Exception {
        newsResponse= new NyResponse();
        newsResponse= TestUtils.loadJson("mock/nyMockListDubai.json",mGson);
        resultsItem=newsResponse.getResults();
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void loading () throws Exception{
        assertTrue(newsResponse.getResults().size() == 20);
    }
    @Test
    public void getNewsFromServer() {

    }

    @Test
    public void getApplication() {
        resultsItem.get(0).setAdxKeywords("Test mock data");
        assertFalse(resultsItem.get(0).getAdxKeywords().equalsIgnoreCase("Test mock data"));


    }
    @Test
    public void Error() throws Exception{
        assertFalse(newsResponse.getStatus().equals("fail"));
    }

    @Test
    public void onCleared() {
        assertTrue(newsResponse.getCopyright().equals("Copyright (c) 2019 The New York Times Company.  All Rights Reserved."));
    }
}