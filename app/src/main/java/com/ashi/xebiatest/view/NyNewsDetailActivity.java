package com.ashi.xebiatest.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.ashi.xebiatest.R;
import com.ashi.xebiatest.databinding.ActivityNyNewsDetailsBinding;
import com.ashi.xebiatest.models.ResultsItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class NyNewsDetailActivity  extends AppCompatActivity {

    private ActivityNyNewsDetailsBinding binding;

    /**
     * This method is to open the CustomerDetailsActivity. This method is call from different activity.
     *
     * @param mActivity
     * @return:CustomerDetailsActivity:screen.
     */
    public static void startActivity(Activity mActivity, ResultsItem customerListModel) {
        Intent intent = new Intent(mActivity, NyNewsDetailActivity.class);
        intent.putExtra("CustomerDetails", customerListModel);
        mActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_ny_news_details);

    }
}
