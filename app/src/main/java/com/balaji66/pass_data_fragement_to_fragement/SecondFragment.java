package com.balaji66.pass_data_fragement_to_fragement;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class SecondFragment extends Fragment implements FirstFragment.OnFragmentInteractionListener{

    private FirstFragment.OnFragmentInteractionListener mListener;

    TextView textView, textDesc;
    Button button2;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) view.findViewById(R.id.txtName);
        textDesc = (TextView) view.findViewById(R.id.txtDesc);
        button2=(Button) view.findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Main2Activity.class);
                Bundle mData = new Bundle();
                mData.putString("FirstName",textView.getText().toString());
                mData.putString("LastName",textDesc.getText().toString());
                intent.putExtras(mData);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onFragmentInteraction(String name, String desc) {
        textView.setText(name);
        textDesc.setText(desc);
    }
}
