package jhonatan.sabadi.desafioo.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;
import jhonatan.sabadi.desafioo.R;
import jhonatan.sabadi.desafioo.model.Fund;

public class DetailsFundActivity extends AppCompatActivity {

    private ImageView image_view_details;
    private TextView full_name_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_fund);

        loadComponents();
        loadFundFromIntent();

    }

    private void loadComponents() {
        image_view_details = findViewById(R.id.image_view_details);
        full_name_details = findViewById(R.id.full_name_details);
    }

    private void loadFundFromIntent() {
        if (getIntent().getSerializableExtra("fund") != null) {
            Fund fund = (Fund) getIntent().getSerializableExtra("fund");
            Log.d("fund", fund.toString());
            setDetailsToText(fund);
        }
    }

    private void setDetailsToText(Fund fund) {
        setImageLogo(fund);
        full_name_details.setText(fund.getFull_name());
    }

    private void setImageLogo(Fund fund) {
        String logoUrl = getString(R.string.base_url_logo) + fund.getFund_manager().getLogo();
        Glide.with(this)
                .load(logoUrl)
                .into(image_view_details);

    }

}
