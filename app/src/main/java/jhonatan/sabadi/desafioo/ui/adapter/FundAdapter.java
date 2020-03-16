package jhonatan.sabadi.desafioo.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jhonatan.sabadi.desafioo.R;
import jhonatan.sabadi.desafioo.interfaces.OnRecyclerClickListener;
import jhonatan.sabadi.desafioo.model.Fund;

public class FundAdapter extends RecyclerView.Adapter<FundAdapter.FundViewHolder> {

    private List<Fund> funds = new ArrayList<>();
    private OnRecyclerClickListener onRecyclerClickListener;

    public FundAdapter(List<Fund> funds, OnRecyclerClickListener onRecyclerClickListener) {
        this.funds = funds;
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
        holder.itemView.setOnClickListener(view ->
                onRecyclerClickListener.setOnRecyclerClick(view, position)
        );
    }

    @Override
    public int getItemCount() {
        return funds.size();
    }

    class FundViewHolder extends RecyclerView.ViewHolder {

        public FundViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    }

}
