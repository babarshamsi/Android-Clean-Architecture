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
import model.Model;
import presenter.RecyclerItemListener;

/**
 * Created by Lenovo on 10/30/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.AdapterHolder> {

    RecyclerItemListener recyclerItemListener;
    private int itemLayout;
    private ArrayList<Object> list;

    public MyAdapter(ArrayList<Object> list, int itemLayout){

        this.list = list;
        this.itemLayout = itemLayout;

    }

    public void setItemClickListener(RecyclerItemListener recyclerItemListener){

        this.recyclerItemListener = recyclerItemListener;

    }

    @Override
    public AdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout,parent,false);


        return new AdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterHolder holder, int position) {

        Model model = (Model) list.get(position);

        Random random = new Random();
        holder.tv_name.setTextColor(Color.rgb(random.nextInt(255),random.nextInt(255),random.nextInt(255)));

        holder.tv_name.setText(model.getName());
      //  holder.iv_image.setImageResource(model.getPicture());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Bind(R.id.tv_name)TextView tv_name;
     //   @Bind(R.id.iv_image)ImageView iv_image;

        public AdapterHolder(View itemView) {
            super(itemView);


            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {

            if (recyclerItemListener!= null)
                    recyclerItemListener.onItemClickListener(getAdapterPosition());
               // recyclerItemListener.onItemClickListener(getAdapterPosition());
          //  recyclerItemListener.onItemClickListener(tv_name.getText().toString());

        }
    }
}
