package ug.global.customizednavdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {
private ArrayList<ProfileObject>profileObjectArrayList;
    private LayoutInflater layoutInflater;

    public RecyclerviewAdapter(ArrayList<ProfileObject> profileObjectArrayList, Context context) {
        this.profileObjectArrayList = profileObjectArrayList;
        layoutInflater=LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.recyclerview_row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.university.setText(profileObjectArrayList.get(position).getUniversity());
        holder.level.setText(profileObjectArrayList.get(position).getCourse());
        holder.name.setText(profileObjectArrayList.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return profileObjectArrayList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, university,level;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            level=itemView.findViewById(R.id.level);
            university=itemView.findViewById(R.id.university);

        }
    }
}
