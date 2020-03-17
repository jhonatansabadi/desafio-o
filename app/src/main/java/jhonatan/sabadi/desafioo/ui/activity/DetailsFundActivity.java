package jhonatan.sabadi.desafioo.ui.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import jhonatan.sabadi.desafioo.R;
import jhonatan.sabadi.desafioo.model.Fund;

public class DetailsFundActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_fund);

        loadFundFromIntent();

    }

    private void loadFundFromIntent() {
        if (getIntent().getSerializableExtra("fund") != null) {
            Fund fund = (Fund) getIntent().getSerializableExtra("fund");
            Log.d("fund", fund.toString());
            setDetailsToText(fund);
        }
    }

    private void setDetailsToText(Fund fund) {

    }

}
