package com.example.jean.retrofitexample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.jean.retrofitexample.R;
import com.example.jean.retrofitexample.model.History;
import com.example.jean.retrofitexample.model.Player;
import com.example.jean.retrofitexample.presenter.HistoryPresenter;
import com.example.jean.retrofitexample.presenter.PlayerPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PlayerView {
    private RecyclerView mRvPlayer;
    private RV_Adapter_History rv_adapter_history;
    private List<History> mPlayer = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PlayerPresenter playerPresenter = new PlayerPresenter(this);
        HistoryPresenter historyPresenter = new HistoryPresenter(this);

        // Maybe it's best to call it on onResume()
        playerPresenter.getCountries();
        historyPresenter.getCountries();

        mRvPlayer = (RecyclerView) findViewById(R.id.rvmain);

        mRvPlayer.setLayoutManager(new LinearLayoutManager(this));
        rv_adapter_history = new RV_Adapter_History(this);
        mRvPlayer.setAdapter(rv_adapter_history);
    }

    @Override
    public void countriesReady(List<Player> books) {

        // See your Logcat :)
        for (Player book : books) {
            Log.i("RETROFIT", book.getId() + "\n"
                    + " - Alpha2:  " + book.getTeam() + " \n"
                    + " - Alpha3: " + book.getNama());
        }
    }

    @Override
    public void historyReady(List<History> history) {
        mPlayer.addAll(history);
        rv_adapter_history.setdata(mPlayer);
        rv_adapter_history.notifyDataSetChanged();
        for (History book : history) {
            Log.i("RETROFIT", book.getId() + "\n"
                    + " - Alpha4:  " + book.getTeam() + " \n"
                    + " - Alpha5: " + book.getNama());
        }

    }
}
