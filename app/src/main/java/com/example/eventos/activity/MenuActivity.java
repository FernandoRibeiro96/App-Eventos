package com.example.eventos.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.eventos.R;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

public class MenuActivity extends AppCompatActivity {

    CircleMenu circleMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().hide();

        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(Color.parseColor("#98aa05"), R.drawable.ic_play, R.drawable.ic_close)
                .addSubMenu(Color.parseColor("#98aa05"), R.drawable.ic_event)
                .addSubMenu(Color.parseColor("#98aa05"), R.drawable.logo)
                .addSubMenu(Color.parseColor("#98aa05"), R.drawable.ic_power)
                .addSubMenu(Color.parseColor("#98aa05"), R.drawable.logo)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        switch (index){
                            case 0:
                                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                                break;
                            case 1:
                                Toast.makeText(MenuActivity.this, ""+index, Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                new MaterialStyledDialog.Builder(MenuActivity.this)
                                        .setTitle("Sair")
                                        .setIcon(R.drawable.ic_power)
                                        .setDescription("Deseja sair?")
                                        .setPositiveText("Sim")
                                        .setNegativeText("Não")
                                        .onNegative(new MaterialDialog.SingleButtonCallback() {
                                            @Override
                                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                                            @Override
                                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                                finish();
                                            }
                                        })
                                        .show();
                                break;
                            case 3:
                                Toast.makeText(MenuActivity.this, ""+index, Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }

                }).setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

            @Override
            public void onMenuOpened() {}

            @Override
            public void onMenuClosed() {}

        });
    }
}