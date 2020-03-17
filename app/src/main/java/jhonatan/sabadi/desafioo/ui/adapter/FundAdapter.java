package jhonatan.sabadi.desafioo.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import jhonatan.sabadi.desafioo.R;
import jhonatan.sabadi.desafioo.interfaces.OnRecyclerClickListener;
import jhonatan.sabadi.desafioo.model.Fund;

public class FundAdapter extends PagedListAdapter<Fund, FundAdapter.FundViewHolder> {
    private OnRecyclerClickListener onRecyclerClickListener;
    private static DiffUtil.ItemCallback DIFF_UTIL = new DiffUtil.ItemCallback<Fund>() {
        @Override
        public boolean areItemsTheSame(@NonNull Fund oldItem, @NonNull Fund newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Fund oldItem, @NonNull Fund newItem) {
            return oldItem.getId() == newItem.getId();
        }
    };

    public FundAdapter(OnRecyclerClickListener onRecyclerClickListener) {
        super(DIFF_UTIL);
        this.onRecyclerClickListener = onRecyclerClickListener;
    }

    @NonNull
    @Override
    public FundViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view_fund, parent, false);
        FundViewHolder fundViewHolder = new FundViewHolder(view);
        return fundViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FundViewHolder holder, int position) {
        Fund fund = getItem(position);
        holder.bind(fund);
    }


    public Fund getFundAtPosition(int position) {
        return getItem(position);
    }

    class FundViewHolder extends RecyclerView.ViewHolder {

        private TextView full_name;

        public FundViewHolder(@NonNull View itemView) {
            super(itemView);
            full_name = itemView.findViewById(R.id.full_name_fund);
        }

        public void bind(Fund fund) {
            setOnRecyclerClick();
            full_name.setText(fund.getFull_name());
        }

        private void setOnRecyclerClick() {
            itemView.setOnClickListener(view ->
                    onRecyclerClickListener.setOnRecyclerClick(view, getAdapterPosition())
            );
        }
    }
}
