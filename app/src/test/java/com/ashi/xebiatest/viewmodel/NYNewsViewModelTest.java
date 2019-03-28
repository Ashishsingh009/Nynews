package com.ashi.xebiatest.viewmodel;

import com.ashi.xebiatest.adapter.NyNewsAdapter;
import com.ashi.xebiatest.listener.NyNewsItemClickListner;
import com.ashi.xebiatest.listener.NyNewsListInterface;
import com.ashi.xebiatest.models.NyResponse;
import com.ashi.xebiatest.models.ResultsItem;
import com.ashi.xebiatest.utils.TestUtils;
import com.ashi.xebiatest.view.NyNewsActivity;
import com.google.gson.Gson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import javax.inject.Inject;

import static org.junit.Assert.*;

public class NYNewsViewModelTest {

    private NyResponse newsResponse;


    @Inject
    Gson mGson;
    @Before
    public void setUp() throws Exception {
        newsResponse= new NyResponse();
        newsResponse= TestUtils.loadJson("mock/nyMockListDubai.json",mGson);
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
        NyNewsActivity activity=new NyNewsActivity();
       // assertTrue(activity.mDataItems.get(0).getTitle()=="Why You Procrastinate (It Has Nothing to Do With Self-Control)");


    }
    @Test
    public void Error() throws Exception{
//        assertTrue(newsResponse.getStatus().equals("success"));
    }

    @Test
    public void onCleared() {
    }
}