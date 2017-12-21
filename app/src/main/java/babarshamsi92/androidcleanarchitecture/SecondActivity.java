package babarshamsi92.androidcleanarchitecture;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import adapter.MyAdapter;
import adapter.SecondAdapter;

/**
 * Created by Lenovo on 11/2/2017.
 */

public class SecondActivity extends BaseActivity {
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return getLinearLayoutManager();
    }

    @Override
    protected RecyclerView.Adapter getAdapter(ArrayList<Object> list) {
        return new SecondAdapter(R.layout.item_second,list);
    }



    private LinearLayoutManager getLinearLayoutManager(){
        return new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);



    }


}
