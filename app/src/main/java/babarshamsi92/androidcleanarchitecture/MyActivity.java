package babarshamsi92.androidcleanarchitecture;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import adapter.MyAdapter;
import model.Model;

/**
 * Created by Lenovo on 10/30/2017.
 */

public class MyActivity extends BaseActivity {
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
        return new MyAdapter(list,R.layout.item_first);
    }

    @Override
    public void onItemClickListener(int position) {


        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
       // super.onItemClickListener(position);
    }

    private LinearLayoutManager getLinearLayoutManager(){
        return new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);


    }
}
