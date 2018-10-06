package com.sparrow.eslam.footballfinal.home;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sparrow.eslam.footballfinal.R;
import com.sparrow.eslam.footballfinal.SecondActivity;
import com.sparrow.eslam.footballfinal.pojo.Competition;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaguesAdapter extends RecyclerView.Adapter<LeagueViewHolder> {
    private final List<Competition> competitionList;
    private Context context;

    LeaguesAdapter(List<Competition> competitionList) {
        this.competitionList = competitionList;
    }

    @NonNull
    @Override
    public LeagueViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item,viewGroup,false);
        return new LeagueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeagueViewHolder leagueViewHolder, int i) {
        Competition item = competitionList.get(i);

        leagueViewHolder.name.setText(item.getCaption());
        leagueViewHolder.numOfGames.setText("Number of games"+item.getNumberOfGames());
        leagueViewHolder.numOfTeams.setText("Number of Teams"+item.getNumberOfTeams()+"");
        leagueViewHolder.name.setOnClickListener(view->{
            onItemClicked(item.getId());
        });
    }

    private void onItemClicked(int id) {
        Intent intent = new Intent(context,SecondActivity.class);
        intent.putExtra("LeagueId",id);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return competitionList.size();
    }
}

class LeagueViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.leagueLogo)
    ImageView logo;
    @BindView(R.id.leagueName)
    TextView name;
    @BindView(R.id.numberOfTeams)
    TextView numOfTeams;
    @BindView(R.id.numberOfGames)
    TextView numOfGames;

    public LeagueViewHolder(@NonNull View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }
}