package com.matcontrol;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fedor on 21.03.2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public interface OnClickInterface {
        void onClick(TempModel item);
    }

    private List<TempModel> mDataset = new ArrayList<>();
    private static OnClickInterface mOnClickInterface;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public RelativeLayout mContainer;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.list_text);
            mContainer = (RelativeLayout) v.findViewById(R.id.item_container);

        }

        public void update(final TempModel model) {
            mTextView.setText(model.getName());
            mContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnClickInterface != null) {
                        mOnClickInterface.onClick(model);
                    }
                }
            });
        }
    }

    public void setOnClickInterface(OnClickInterface onClickInterface) {
        mOnClickInterface = onClickInterface;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.update(mDataset.get(position));

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void update(List<TempModel> list) {
        this.mDataset = list;
        notifyDataSetChanged();

    }
}
