package com.trecyclerview.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trecyclerview.entity.HeaderInfo;
import com.trecyclerview.multitype.AbsItemView;

/**
 * @author：tqzhang on 18/7/13 16:47
 */
public abstract class AbsHeaderView extends AbsItemView<HeaderInfo, AbsHeaderView.ViewHolder> {

    private ArrowRefreshHeader mRefreshHeader;

    protected Context mContext;

    protected int mProgressStyle;

    public AbsHeaderView(Context context,int progressStyle) {
        this.mContext = context;
        this.mProgressStyle = progressStyle;
        mRefreshHeader = createRefreshHeader();
    }


    protected abstract ArrowRefreshHeader createRefreshHeader();

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ViewHolder(mRefreshHeader);
    }

    public ArrowRefreshHeader getRefreshHeaderView() {
        return mRefreshHeader;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull HeaderInfo item) {
    }

    static class ViewHolder extends RecyclerView.ViewHolder {


        ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

    @Override
    protected void onViewAttachedToWindow(@NonNull ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        RecyclerView.LayoutParams clp = (RecyclerView.LayoutParams) holder.itemView.getLayoutParams();
        if (clp instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) clp).setFullSpan(true);
        }

    }
}
