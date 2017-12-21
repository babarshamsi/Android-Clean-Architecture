package babarshamsi92.androidcleanarchitecture;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.MyAdapter;
import adapter.SecondAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import model.Model;
import presenter.ItemPresenter;
import presenter.RecyclerItemListener;
import util.ItemOffsetDecoration;
import view.ModelMvpView;

/**
 * Created by Lenovo on 10/29/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements ModelMvpView, RecyclerItemListener {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    @Bind(R.id.progress_bar)ProgressBar
    progressBar;
    ItemPresenter itemPresenter;

    RecyclerView.Adapter adapter;
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        ButterKnife.bind(this);

        itemPresenter = new ItemPresenter();
        itemPresenter.attachedView(this);
        context = this;

        setUpRecyclerView();

    }



    @Override
    public void showProgress() {
        recyclerView.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        recyclerView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setItems(ArrayList<Object> list) {

        adapter = getAdapter(list);
        recyclerView.setAdapter(adapter);

        if (adapter instanceof MyAdapter)
            ((MyAdapter) adapter).setItemClickListener(this);

        else if(adapter instanceof SecondAdapter)
            ((SecondAdapter)adapter).setItemClickListener(this);

    }

    @Override
    public void onItemClickListener(int position) {

        itemPresenter.onItemSelected(position);

    }

    @Override
    public void onItemClickListener(String item) {
        itemPresenter.onItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        itemPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        itemPresenter.detachView();

    }

    private void setUpRecyclerView() {

        if (getLayoutManager()!= null)
            recyclerView.setLayoutManager(getLayoutManager());

        recyclerView.addItemDecoration(new ItemOffsetDecoration(recyclerView.getContext(), R.dimen.item_decoration));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    protected abstract int getLayout();
    protected abstract RecyclerView.LayoutManager getLayoutManager();
    protected abstract RecyclerView.Adapter getAdapter(ArrayList<Object> list);








}
