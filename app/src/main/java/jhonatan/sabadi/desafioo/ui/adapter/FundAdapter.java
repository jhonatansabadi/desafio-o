package jhonatan.sabadi.desafioo.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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

        private TextView simple_name;
        private TextView description_seo_fund;
        private TextView initial_date_fund;
        private TextView fund_suitability_profile;
        private TextView fund_type;
        private ImageView logo;

        public FundViewHolder(@NonNull View itemView) {
            super(itemView);
            simple_name = itemView.findViewById(R.id.simplel_name_fund);
            description_seo_fund = itemView.findViewById(R.id.description_seo_fund);
            initial_date_fund = itemView.findViewById(R.id.initial_date_fund);
            fund_suitability_profile = itemView.findViewById(R.id.fund_suitability_profile_name);
            fund_type = itemView.findViewById(R.id.fund_type);

            logo = itemView.findViewById(R.id.logo_small_fund);
        }

        public void bind(Fund fund) {
            setOnRecyclerClick();
            simple_name.setText(fund.getSimple_name());
            description_seo_fund.setText(fund.getDescription_seo());
            initial_date_fund.setText(fund.getInitial_date());
            fund_suitability_profile.setText(fund.getSpecification().getFund_suitability_profile().getName());
            fund_type.setText(fund.getSpecification().getFund_type());

            String logoUrl = itemView.getContext().getString(R.string.base_url_logo) + fund.getFund_manager().getLogo();
            Glide.with(itemView.getContext())
                    .load(logoUrl)
                    .into(logo);
        }

        private void setOnRecyclerClick() {
            itemView.setOnClickListener(view ->
                    onRecyclerClickListener.setOnRecyclerClick(view, getAdapterPosition())
            );
        }
    }
}
