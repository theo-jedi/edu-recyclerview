package com.theost.recyclerapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.theost.recyclerapp.databinding.ItemUserBinding;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private final List<User> users;
    private final UsersCallback usersCallback;

    public UsersAdapter(List<User> users, UsersCallback usersCallback) {
        this.users = users;
        this.usersCallback = usersCallback;
    }

    public void cloneUser(User user) {
        int position = users.indexOf(user);
        notifyItemInserted(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserBinding binding = ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(users.get(position), usersCallback);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemUserBinding binding;

        public ViewHolder(ItemUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(User user, UsersCallback usersCallback) {
            Glide.with(binding.getRoot())
                    .load(user.getAvatar())
                    .placeholder(R.color.teal_200)
                    .error(R.color.purple_500)
                    .into(binding.userAvatar);

            binding.userName.setText(user.getName());
            binding.userEmail.setText(user.getEmail());

            binding.getRoot().setOnClickListener(view -> usersCallback.onClick(user));
        }

    }

}
