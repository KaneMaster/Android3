package com.geekbrains.lessonproject.user.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geekbrains.lessonproject.R;

import java.util.List;

public class UserRecycleAdapter extends RecyclerView.Adapter<UserRecycleAdapter.UserViewHolser> {

    private List<user> users;

    public UserRecycleAdapter(List<user> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolser onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolser(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolser holder, int position) {


        holder.name.setText(users.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolser extends RecyclerView.ViewHolder{

        TextView name;
        ImageView avatar;

        public UserViewHolser(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_name);
            avatar = itemView.findViewById(R.id.image_avatar);
        }
    }
}
