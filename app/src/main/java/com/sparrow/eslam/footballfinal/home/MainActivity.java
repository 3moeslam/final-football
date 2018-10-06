package com.sparrow.eslam.footballfinal.home;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.sparrow.eslam.footballfinal.App;
import com.sparrow.eslam.footballfinal.R;
import com.sparrow.eslam.footballfinal.network.FootballApi;
import com.sparrow.eslam.footballfinal.pojo.Competition;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.leaguesRecycler)
    RecyclerView recyclerView;

    private ProgressDialog dialog;
    private HomeViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        showLoadingDialog();

        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        viewModel.competations
                .observe(this, this::bindRecyclerView);
    }

    private void showLoadingDialog() {
        dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);
        dialog.setCancelable(false);
    }

    private void bindRecyclerView(List<Competition> list){
        LeaguesAdapter adapter = new LeaguesAdapter(list);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }else{
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        }
        recyclerView.setAdapter(adapter);
        dialog.dismiss();
    }
}
