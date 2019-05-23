package com.mrhi2018.ex56recyclerview2;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter {

    ArrayList<Item> items;
    Context context;

    public MyAdapter(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //recycler_item.xml를 View객체로 만들어 주는 작업
        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView= inflater.inflate(R.layout.recycler_item, viewGroup, false);
        //뷰홀더 객체 생성
        VH holder= new VH(itemView);
        return holder;//홀더객체 리턴
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        //position번째 데이터
        Item item= items.get(position);

        VH holder= (VH)viewHolder;
        holder.tvName.setText( item.name );
        holder.tvMsg.setText( item.msg );
        holder.civ.setImageResource( item.icon );
        holder.iv.setImageResource( item.img );

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //inner class
    class VH extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvMsg;
        CircleImageView civ;
        ImageView iv;

        public VH(@NonNull View itemView) {
            super(itemView);

            tvName= itemView.findViewById(R.id.tv_name);
            tvMsg= itemView.findViewById(R.id.tv_msg);
            civ= itemView.findViewById(R.id.iv_icon);
            iv= itemView.findViewById(R.id.iv);
            
            //항목클릭리스너 추가
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context, ""+ getLayoutPosition(), Toast.LENGTH_SHORT).show();

                    //보낼 데이터
                    String name= items.get( getLayoutPosition() ).name;
                    int imgId= items.get( getLayoutPosition() ).img;

                    Intent intent= new Intent(context, DetailActivity.class);
                    //추가 데이터 전달 요청
                    intent.putExtra("Name", name);
                    intent.putExtra("Img", imgId);

                    //전환효과...
                    if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){

                        ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation((Activity) context, new Pair<View, String>(civ, "IMG"));
                        context.startActivity(intent, options.toBundle());

                    }else{
                        context.startActivity(intent);
                    }



                }
            });
        }
    }

}
