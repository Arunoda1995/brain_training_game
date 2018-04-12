package com.example.brain_training_game;


import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class main_menu_fragment extends Fragment {


    private Button about_button,exit_button,new_button,continue_button,preference_button;
    private AlertDialog mDialog;
    final CharSequence[] difficult_level={"Novice","Easy","Medium","Guru"};
    final CharSequence[] hints = {"ON","OFF"};
    int hint_selected = 1;

    public main_menu_fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.main_menu_fragment, container, false);

        createView(rootView);

        return rootView;
    }


    public void createView(final View rootView)
    {

        about_button =  rootView.findViewById(R.id.button_about);
        exit_button = rootView.findViewById(R.id.button_exit);
        new_button =  rootView.findViewById(R.id.button_new);
        continue_button = rootView.findViewById(R.id.button_continue);
        preference_button = rootView.findViewById(R.id.button_preferences);


        about_button.setOnClickListener(new View.OnClickListener() {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            @Override
            public void onClick(View v) {

                builder.setTitle(R.string.about_title);
                builder.setMessage(R.string.about);
                builder.setCancelable(false);
                builder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                mDialog = builder.show();
            }
        });


        preference_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

                builder.setTitle("HINTS");
                builder.setSingleChoiceItems(hints, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                     hint_selected = which;
                     dialog.dismiss();

                    }
                });

                builder.setCancelable(false);
                builder.show();

            }
        });


        exit_button.setOnClickListener(new View.OnClickListener() {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
            @Override
            public void onClick(View v) {


                builder1.setTitle(R.string.state_title);
                builder1.setMessage(R.string.state_text);
                builder1.setCancelable(false);
                builder1.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("Save Game","True");
                        editor.apply();

                        getActivity().finish();
                        System.exit(0);

                    }

                });

                builder1.setNegativeButton(R.string.cancel_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("Save Game","False");
                        editor.apply();

                        getActivity().finish();

                        System.exit(0);

                    }
                });

                mDialog = builder1.show();



            }



        });




        new_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

                builder.setTitle("Choose A Difficulty Level");
                builder.setSingleChoiceItems(difficult_level, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(getActivity(),GameActivity.class);
                        intent.putExtra("difficultyLevel",Integer.toString(which));
                        intent.putExtra("hints",Integer.toString(hint_selected));
                        getActivity().startActivity(intent);
                        dialog.dismiss();

                    }
                });

                builder.setCancelable(false);
                builder.show();

            }
        });

        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),GameActivity.class);
                intent.putExtra(GameActivity.KEY_RESTORE,true);
                getActivity().startActivity(intent);
            }
        });



        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String choice = sharedPreferences.getString("Save Game","");

        //Depending on the customer decision on Exit button, set the Continue button enable or disable

        if(!choice.equalsIgnoreCase(""))
        {
            if(choice.equals("True"))
            {
                continue_button.setEnabled(true);

            }
            else
            {

                continue_button.setEnabled(false);
            }

        }
        else
        {

            continue_button.setEnabled(false);

        }

    }


    public void onPause() {
        super.onPause();
        if (mDialog != null)
            mDialog.dismiss();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




}
