package com.ashi.xebiatest.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ashi.xebiatest.R;
import com.ashi.xebiatest.databinding.ActivityNyNewsDetailsBinding;
import com.ashi.xebiatest.models.ResultsItem;
import com.ashi.xebiatest.viewmodel.NyNewsdetailViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

public class NyNewsDetailActivity  extends AppCompatActivity {

    private ActivityNyNewsDetailsBinding binding;
    private ResultsItem newsdetails;
    private NyNewsdetailViewModel viewModel;

    /**
     * This method is to open the CustomerDetailsActivity. This method is call from different activity.
     *
     * @param mActivity
     * @return:CustomerDetailsActivity:screen.
     */
    public static void startActivity(Activity mActivity, ResultsItem customerListModel) {
        Intent intent = new Intent(mActivity, NyNewsDetailActivity.class);
        intent.putExtra("NewsDetails", customerListModel);
        mActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_ny_news_details);
        getToolbar();
        iniView();
    }

    /**
     * Set toolbar for CustomerDetailsActivity screen.
     */
    private void getToolbar() {
        setSupportActionBar((Toolbar) binding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.news_list_details));
        (binding.toolbar).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void iniView(){
        if ((ResultsItem) getIntent().getExtras().getSerializable("NewsDetails") != null) {
            newsdetails = (ResultsItem) getIntent().getExtras().getSerializable("NewsDetails");
            if(newsdetails!=null){
                binding.setDataItems(newsdetails);
            }
        }
    }
}
