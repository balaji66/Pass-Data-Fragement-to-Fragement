package com.balaji66.pass_data_fragement_to_fragement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView txtData1,txtData2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtData1=(TextView) findViewById(R.id.txtdata1);
        txtData2 = (TextView) findViewById(R.id.txtdata2);

        Bundle mGetData = getIntent().getExtras();
        txtData1.setText(mGetData.getCharSequence("FirstName"));
        txtData2.setText(mGetData.getCharSequence("LastName"));
    }
}
