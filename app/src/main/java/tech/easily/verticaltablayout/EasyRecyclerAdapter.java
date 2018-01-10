package tech.easily.verticaltablayout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lemon on 07/01/2018.
 */

public class EasyRecyclerAdapter extends RecyclerView.Adapter<EasyRecyclerAdapter.EasyHolder> {

    private int index;

    public EasyRecyclerAdapter(int index) {
        this.index = index;
    }

    @Override
    public EasyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recycler_holder, null);
        return new EasyHolder(holderView);
    }

    @Override
    public void onBindViewHolder(EasyHolder holder, int position) {
        holder.setText(index, position);
    }

    @Override
    public int getItemCount() {
        return 40;
    }

    public static class EasyHolder extends RecyclerView.ViewHolder {

        private TextView tvContent;

        public EasyHolder(View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.tv_content);
        }

        public void setText(int index, int position) {
            tvContent.setText(String.format("==position is :%d ==, and item %d", index, position));
        }
    }
}
