package jhonatan.sabadi.desafioo.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.transition.MaterialContainerTransform;
import com.google.android.material.transition.MaterialContainerTransformSharedElementCallback;

import androidx.appcompat.app.AppCompatActivity;
import jhonatan.sabadi.desafioo.R;
import jhonatan.sabadi.desafioo.model.Fund;

public class DetailsFundActivity extends AppCompatActivity {

    private ImageView image_view_details;
    private ImageView strategy_video_thumbnail_details;
    private TextView full_name_details;
    private TextView inital_date_details;
    private TextView description_objective_details;
    private TextView suitability_profile_name_details;
    private TextView fund_type_details;
    private TextView description_seo_details;
    private TextView description_target_audience_details;
    private TextView strategy_video_title_details;
    private TextView clique_assistir_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_fund);

        loadComponents();
        loadFundFromIntent();

        loadToolbar();

    }

    private void loadToolbar() {
        MaterialToolbar toolbar = findViewById(R.id.anim_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void loadComponents() {
        image_view_details = findViewById(R.id.image_view_details);
        strategy_video_thumbnail_details = findViewById(R.id.strategy_video_thumbnail_details);
        full_name_details = findViewById(R.id.full_name_details);
        inital_date_details = findViewById(R.id.initial_date_details);
        description_objective_details = findViewById(R.id.descriptio_objective_details);
        suitability_profile_name_details = findViewById(R.id.suitability_profile_name_details);
        fund_type_details = findViewById(R.id.fund_type_details);
        description_seo_details = findViewById(R.id.description_seo_details);
        description_target_audience_details = findViewById(R.id.description_target_audience_details);
        strategy_video_title_details = findViewById(R.id.strategy_video_title_details);
        clique_assistir_details = findViewById(R.id.clique_assistir_details);
    }

    private void loadFundFromIntent() {
        if (getIntent().getSerializableExtra("fund") != null) {
            Fund fund = (Fund) getIntent().getSerializableExtra("fund");
            setDetailsToText(fund);
        }
    }

    private void setDetailsToText(Fund fund) {
        setImageLogo(fund);
        setYoutubeDetails(fund);
        full_name_details.setText(fund.getFull_name());
        inital_date_details.setText(fund.getInitial_date());
        description_objective_details.setText(fund.getDescription().getObjective());
        suitability_profile_name_details.setText(fund.getSpecification().getFund_suitability_profile().getName());
        fund_type_details.setText(fund.getSpecification().getFund_type());
        description_seo_details.setText(fund.getDescription_seo());
        description_target_audience_details.setText(fund.getDescription().getTarget_audience());
    }

    private void setImageLogo(Fund fund) {
        String logoUrl = getString(R.string.base_url_logo) + fund.getFund_manager().getLogo();
        Glide.with(this)
                .load(logoUrl)
                .into(image_view_details);
    }

    private void setYoutubeDetails(Fund fund) {
        if (fund.getStrategy_video() != null) {
            if (fund.getStrategy_video().getThumbnail() != null && fund.getStrategy_video().getTitle() != null) {

                strategy_video_title_details.setText(fund.getStrategy_video().getTitle());

                String thumbnailMq = "https://img.youtube.com/vi/" + fund.getStrategy_video().getYoutube_id() + "/mqdefault.jpg";
                Glide.with(this)
                        .load(thumbnailMq)
                        .into(strategy_video_thumbnail_details);

                startYoutubeVide(fund.getStrategy_video().getUrl());

            } else {
                hideYoutubeDetails();
            }
        } else {
            hideYoutubeDetails();
        }
    }

    private void hideYoutubeDetails() {
        clique_assistir_details.setVisibility(View.GONE);
        strategy_video_title_details.setVisibility(View.GONE);
        strategy_video_thumbnail_details.setVisibility(View.GONE);
    }

    private void startYoutubeVide(String videUrl) {
        strategy_video_thumbnail_details.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videUrl));
            startActivity(intent);
        });
    }

}
