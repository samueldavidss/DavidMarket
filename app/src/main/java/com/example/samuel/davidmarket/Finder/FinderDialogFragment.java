package com.example.samuel.davidmarket.Finder;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.samuel.davidmarket.Views.DescriptionActivity;
import com.example.samuel.davidmarket.Interface.FinderCallback;
import com.example.samuel.davidmarket.R;
import com.example.samuel.davidmarket.UserSearch;

/**
 * Created by Samuel on 12-Feb-18.
 */

public class FinderDialogFragment extends DialogFragment implements FinderCallback {

    private EditText userEdtV;
    private ImageButton serchBtn;

    public static FinderDialogFragment newInstance() {
        return new FinderDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment_finder, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         userEdtV = (EditText) view.findViewById(R.id.userEdTv);
       serchBtn = (ImageButton) view.findViewById(R.id.serchBtn);
       serchBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               setCancelable(false);
               userEdtV.setError(null);
               String serch = userEdtV.getText().toString();
                userEdtV.setVisibility(view.INVISIBLE);
                serchBtn.setVisibility(view.INVISIBLE);

               new UserSearch(FinderDialogFragment.this,getContext()).init(serch);
           }
       });
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
        );
    }


    private void restoreView(){
        userEdtV.setVisibility(View.VISIBLE);
        serchBtn.setVisibility(View.VISIBLE);
        setCancelable(true);
    }

    @Override
    public void error(String error) {
        restoreView();
        userEdtV.setError(error);
    }

    @Override
    public void success() {
        dismiss();
        Intent intent = new Intent(getContext(), DescriptionActivity.class);
    }

    @Override
    public void notfound() {
       restoreView();
        Toast.makeText(getContext(), "No existe el producto", Toast.LENGTH_SHORT).show();
    }
}
