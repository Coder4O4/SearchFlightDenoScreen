package com.social.apdn.nasne.happytrip;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.social.apdn.nasne.happytrip.databinding.ActivityMainBinding;
import com.social.apdn.nasne.happytrip.databinding.AddPassengerAndClassBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private String classOfSeat = "Economy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        getWindow().setStatusBarColor(getColor(R.color.white));
        getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));

        binding.addWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(getApplicationContext() , binding.addWay);
                popupMenu.getMenuInflater().inflate(R.menu.choose_way , popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId())
                        {
                            case R.id.oneWayMenu :
                                binding.setWay.setText("One Way");
                                break;

                            case R.id.roundTripMenu :
                                binding.setWay.setText("Round Trip");
                                break;

                            case R.id.cancelMenu :
                                popupMenu.dismiss();
                                break;

                            default:
                                break;

                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });



        binding.addPersonsClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProcessToAddCAAC();
            }
        });



        binding.calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                settingDateProcedure();
            }
        });

        binding.clearForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.setWay.setText("");
                binding.setPersonsClass.setText("");
                binding.from.setText("");
                binding.to.setText("");
                binding.enterDate.setText("");
                binding.returnFli.setText("");
            }
        });


        binding.searchFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processToSearchFlightError();
            }
        });


    }

    private void processToSearchFlightError()
    {
        String way = binding.setWay.getText().toString().trim();
        String clAPer = binding.setPersonsClass.getText().toString().trim();
        String from = binding.from.getText().toString().trim();
        String to = binding.to.getText().toString().trim();
        String cal = binding.enterDate.getText().toString().trim();
        String returnE = binding.returnFli.getText().toString().trim();

        if (!way.isEmpty())
        {

            if (!clAPer.isEmpty())
            {

                if (!from.isEmpty())
                {

                    if (!to.isEmpty())
                    {

                        if (!cal.isEmpty())
                        {

                            if (!returnE.isEmpty())
                            {
                               processToShowFlight();
                            }
                            else
                            {
                                Toast.makeText(this, "Something is Wrong", Toast.LENGTH_SHORT).show();

                            }
                        }
                        else
                        {
                            Toast.makeText(this, "Something is Wrong", Toast.LENGTH_SHORT).show();

                        }
                    }
                    else
                    {
                        Toast.makeText(this, "Something is Wrong", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(this, "Something is Wrong", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(this, "Something is Wrong", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Something is Wrong", Toast.LENGTH_SHORT).show();

        }

        if (!way.isEmpty())
        {
            binding.errorWay.setBackgroundResource(R.drawable.grey_bac_15);
        }
        else
        {
            binding.errorWay.setBackgroundResource(R.drawable.error_entry1);
        }


        if (!clAPer.isEmpty())
        {
            binding.errorPCA.setBackgroundResource(R.drawable.grey_bac_15);
        }
        else
        {
            binding.errorPCA.setBackgroundResource(R.drawable.error_entry1);
        }


        if (from.isEmpty())
        {
            binding.from.setBackgroundResource(R.drawable.error_entry2);
        }

        if (to.isEmpty())
        {
            binding.to.setBackgroundResource(R.drawable.error_entry2);
        }

        if (!cal.isEmpty())
        {
            binding.calEmp.setBackgroundResource(R.drawable.grey_bac_15);
        }
        else
        {
            binding.calEmp.setBackgroundResource(R.drawable.error_entry1);
        }


        if (!returnE.isEmpty())
        {
            binding.returnFli.setBackgroundResource(R.drawable.grey_bac_15);
        }
        else
        {
            binding.returnFli.setBackgroundResource(R.drawable.error_entry1);
        }


    }

    private void processToShowFlight()
    {
        Toast.makeText(this, "Working", Toast.LENGTH_SHORT).show();
    }

    private void settingDateProcedure()
    {

    }

    private void ProcessToAddCAAC()
    {
        AddPassengerAndClassBinding dialogBinding = AddPassengerAndClassBinding.inflate(getLayoutInflater());
        AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setView(dialogBinding.getRoot())
                .setCancelable(true)
                .create();

        dialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
        dialog.getWindow().setGravity(Gravity.CENTER);

        /////////////////////////////////////// ADULTS /////////////////////////////

        dialogBinding.addADia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int getAdult = Integer.parseInt(dialogBinding.nubOfAdultDia.getText().toString().trim()) +1;

                dialogBinding.nubOfAdultDia.setText(Integer.toString(getAdult));

            }
        });

        dialogBinding.subtractADia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int getAdult = Integer.parseInt(dialogBinding.nubOfAdultDia.getText().toString().trim());

                if (getAdult<=0)
                {
                    dialogBinding.nubOfAdultDia.setText("0");
                }
                else
                {
                    int subtract = getAdult-1;
                    dialogBinding.nubOfAdultDia.setText(Integer.toString(subtract));

                }
            }
        });




        /////////////////////////////////////// CHILD /////////////////////////////
        dialogBinding.addCDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int getChild = Integer.parseInt(dialogBinding.nubOfChiDia.getText().toString().trim());

                dialogBinding.nubOfChiDia.setText(Integer.toString(getChild+1));

            }
        });

        dialogBinding.subtractCDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int getChild = Integer.parseInt(dialogBinding.nubOfChiDia.getText().toString().trim());

                if (getChild<=0)
                {
                    dialogBinding.nubOfChiDia.setText("0");
                }
                else
                {
                    int subtract = getChild-1;
                    dialogBinding.nubOfChiDia.setText(Integer.toString(subtract));

                }
            }
        });



        /////////////////////////////////////// INFANTS /////////////////////////////
        dialogBinding.addIDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int getInfants = Integer.parseInt(dialogBinding.nubOfInfDia.getText().toString().trim());

                dialogBinding.nubOfInfDia.setText(Integer.toString(getInfants+1));

            }
        });

        dialogBinding.subtractIDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int getInfants = Integer.parseInt(dialogBinding.nubOfInfDia.getText().toString().trim());

                if (getInfants<=0)
                {
                    dialogBinding.nubOfInfDia.setText("0");
                }
                else
                {
                    int subtract = getInfants-1;
                    dialogBinding.nubOfInfDia.setText(Integer.toString(subtract));

                }
            }
        });


        /////////////////////////////////////////////////// CLASS  ////////////////////////////////
        /////////////////////////////////////////////////// CLASS  ////////////////////////////////
        /////////////////////////////////////////////////// CLASS  ////////////////////////////////
        /////////////////////////////////////////////////// CLASS  ////////////////////////////////

        dialogBinding.economy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classOfSeat = "Economy";
                dialogBinding.economy.setTextColor(getColor(R.color.blue));
                dialogBinding.businessClass.setTextColor(getColor(R.color.grey));
                dialogBinding.firstClass.setTextColor(getColor(R.color.grey));
                dialogBinding.premiumEconomy.setTextColor(getColor(R.color.grey));

                dialogBinding.economy.setBackgroundResource(R.drawable.select_class);
                dialogBinding.businessClass.setBackgroundResource(R.drawable.bac_gray_ro);
                dialogBinding.firstClass.setBackgroundResource(R.drawable.bac_gray_ro);
                dialogBinding.premiumEconomy.setBackgroundResource(R.drawable.bac_gray_ro);
            }
        });



        dialogBinding.businessClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classOfSeat = "Business Class";
                dialogBinding.economy.setTextColor(getColor(R.color.grey));
                dialogBinding.businessClass.setTextColor(getColor(R.color.blue));
                dialogBinding.firstClass.setTextColor(getColor(R.color.grey));
                dialogBinding.premiumEconomy.setTextColor(getColor(R.color.grey));

                dialogBinding.economy.setBackgroundResource(R.drawable.bac_gray_ro);
                dialogBinding.businessClass.setBackgroundResource(R.drawable.select_class);
                dialogBinding.firstClass.setBackgroundResource(R.drawable.bac_gray_ro);
                dialogBinding.premiumEconomy.setBackgroundResource(R.drawable.bac_gray_ro);
            }
        });

        dialogBinding.firstClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classOfSeat = "First Class";
                dialogBinding.economy.setTextColor(getColor(R.color.grey));
                dialogBinding.businessClass.setTextColor(getColor(R.color.grey));
                dialogBinding.firstClass.setTextColor(getColor(R.color.blue));
                dialogBinding.premiumEconomy.setTextColor(getColor(R.color.grey));

                dialogBinding.economy.setBackgroundResource(R.drawable.bac_gray_ro);
                dialogBinding.businessClass.setBackgroundResource(R.drawable.bac_gray_ro);
                dialogBinding.firstClass.setBackgroundResource(R.drawable.select_class);
                dialogBinding.premiumEconomy.setBackgroundResource(R.drawable.bac_gray_ro);
            }
        });

        dialogBinding.premiumEconomy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classOfSeat = "Premium Economy";
                dialogBinding.economy.setTextColor(getColor(R.color.grey));
                dialogBinding.businessClass.setTextColor(getColor(R.color.grey));
                dialogBinding.firstClass.setTextColor(getColor(R.color.grey));
                dialogBinding.premiumEconomy.setTextColor(getColor(R.color.blue));

                dialogBinding.economy.setBackgroundResource(R.drawable.bac_gray_ro);
                dialogBinding.businessClass.setBackgroundResource(R.drawable.bac_gray_ro);
                dialogBinding.firstClass.setBackgroundResource(R.drawable.bac_gray_ro);
                dialogBinding.premiumEconomy.setBackgroundResource(R.drawable.select_class);
            }
        });


        dialogBinding.selectAtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int getAdult = Integer.parseInt(dialogBinding.nubOfAdultDia.getText().toString().trim());
                int getChild = Integer.parseInt(dialogBinding.nubOfChiDia.getText().toString().trim());
                int getInfants = Integer.parseInt(dialogBinding.nubOfInfDia.getText().toString().trim());

                if (getAdult==0 && getChild==0 && getInfants==0)
                {
                    dialog.dismiss();
                }
                else
                {
                    String selectedClass = getAdult+" Adults ,"+ getChild+" Child ,"+ getInfants+" Infant ,"+classOfSeat;

                    binding.setPersonsClass.setText(selectedClass);
                    dialog.dismiss();
                }


            }
        });


        dialog.show();
    }
}