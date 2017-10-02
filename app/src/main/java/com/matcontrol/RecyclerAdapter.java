package com.matcontrol;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fedor on 21.03.2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public interface OnClikInterface {
        void onClick();
    }

    private List<TempModel> mDataset = new ArrayList<>();
    private static OnClikInterface mOnClikInterface;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.list_text);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnClikInterface != null)
                        mOnClikInterface.onClick();
                }
            });
        }

        public void update(TempModel model) {
            mTextView.setText(model.getName());
        }
    }

    public void setOnClikInterface(OnClikInterface onClikInterface) {
        mOnClikInterface = onClikInterface;
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
