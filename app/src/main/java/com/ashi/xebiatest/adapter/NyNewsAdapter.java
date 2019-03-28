package com.ashi.xebiatest.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ashi.xebiatest.BR;
import com.ashi.xebiatest.R;
import com.ashi.xebiatest.listener.NyNewsItemClickListner;
import com.ashi.xebiatest.models.NyResponse;
import com.ashi.xebiatest.models.ResultsItem;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class NyNewsAdapter extends RecyclerView.Adapter<NyNewsAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<ResultsItem> dataList;
    private NyNewsItemClickListner listner;
    public NyNewsAdapter(Context context, ArrayList<ResultsItem> data, NyNewsItemClickListner itemClickListner){
        this.mContext=context;
        this.dataList=data;
        this.listner=itemClickListner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ResultsItem item=dataList.get(position);
        holder.getBinding().setVariable(BR.dataItem, item);
        holder.getBinding().setVariable(BR.itemclicklistner,listner );
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }
    /**
     * This method will provide data the list here we are passing
     * notifydatasetchanged method
     *
     * @param results added fresh data to list .
     */
    public void addData(List<ResultsItem> results) {
        dataList.clear();
        if(results != null) {
            dataList.addAll(results);
        }
        notifyDataSetChanged();

    }
    /**
     * Method to get list of all data from this RecyclerView.
     * @return
     */
    public List<ResultsItem> getAllData() {
        return dataList;
    }
}
