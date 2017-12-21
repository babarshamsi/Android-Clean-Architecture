package adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import babarshamsi92.androidcleanarchitecture.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import model.ModelSecond;
import presenter.RecyclerItemListener;

/**
 * Created by Lenovo on 11/2/2017.
 */

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.ViewHolder> {

    int itemLayout;
    ArrayList<Object> list;
    RecyclerItemListener recyclerItemListener;


    public SecondAdapter(int itemLayout, ArrayList<Object> list){

        this.itemLayout = itemLayout;
        this.list = list;

    }

    public void setItemClickListener(RecyclerItemListener recyclerItemListener){
        this.recyclerItemListener = recyclerItemListener;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ModelSecond modelSecond = (ModelSecond) list.get(position);

        Random random = new Random();
        holder.name.setTextColor(Color.rgb(random.nextInt(),random.nextInt(),random.nextInt()));
        holder.message.setTextColor(Color.rgb(random.nextInt(),random.nextInt(),random.nextInt()));

        holder.name.setText(modelSecond.getName());
        holder.message.setText(modelSecond.getMessage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Bind(R.id.tv_name) TextView name;
        @Bind(R.id.tv_message) TextView message;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);





        }

        @Override
        public void onClick(View view) {

            if (recyclerItemListener!= null){

                recyclerItemListener.onItemClickListener(getAdapterPosition());
            }
        }


    }
}
