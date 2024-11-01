package com.alisavran.javatwitterclone.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alisavran.javatwitterclone.Model.Post;
import com.alisavran.javatwitterclone.databinding.RecyclerRowBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostAdapter  extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    private ArrayList<Post> postArrayList;

    public PostAdapter(ArrayList<Post> postArrayList) {
        this.postArrayList = postArrayList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PostHolder(recyclerRowBinding);
    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        Post post = postArrayList.get(position);
        holder.recyclerRowBinding.recyclerViewUserEmailText.setText(post.email);
        holder.recyclerRowBinding.recyclerViewCommentText.setText(post.comment);

        if (post.downloadUrl != null && !post.downloadUrl.isEmpty()) {
            holder.recyclerRowBinding.recyclerViewImageView.setVisibility(View.VISIBLE);
            Picasso.get().load(post.downloadUrl).into(holder.recyclerRowBinding.recyclerViewImageView);
        } else {
            holder.recyclerRowBinding.recyclerViewImageView.setVisibility(View.GONE);
        }
    }

    class PostHolder extends RecyclerView.ViewHolder{

        RecyclerRowBinding recyclerRowBinding;

            public PostHolder(RecyclerRowBinding recyclerRowBinding) {
                super(recyclerRowBinding.getRoot());
                this.recyclerRowBinding = recyclerRowBinding;
            }
        }
}
