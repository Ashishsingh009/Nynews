package com.ashi.xebiatest.view;

import com.ashi.xebiatest.models.NyResponse;
import com.ashi.xebiatest.models.ResultsItem;
import com.google.gson.Gson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import javax.inject.Inject;

import static org.junit.Assert.*;

public class NyNewsActivityTest {
    private NyResponse newsResponse;
    List<ResultsItem> mDataItems;

    @Inject
    Gson mGson;
    @Before
    public void setUp() throws Exception {
        newsResponse= new NyResponse();
        newsResponse= TestUtils.loadJson("mock/nyMockListGgn.json",mGson);
        mDataItems=newsResponse.getResults();
    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void onRefresh() {
//        assertTrue(mDataItems.contains(""));
    }
    @Test
    public void onItemCount() {
        assertTrue(newsResponse.getResults().size()>0);
    }

    @Test
    public void onItemClick() {
    }
}