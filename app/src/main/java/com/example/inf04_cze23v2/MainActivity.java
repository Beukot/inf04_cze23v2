package com.example.inf04_cze23v2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private String[] textes = {"Dzień dobry", "Good morning", "Buenos dias"};
    private SeekBar fontSizeSlider;
    private Button changeTextButton;
    private TextView textToChange;
    private TextView fontSizeText;
    private int fontSize;
    private int selectedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fontSize = 14;
        selectedText = 0;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SeekBar fontSizeSlider = findViewById(R.id.seekBar);
        Button changeTextButton = findViewById(R.id.button);
        TextView textToChange = findViewById(R.id.textToChange);
        TextView fontSizeText = findViewById(R.id.fontSizeText);


        textToChange.setTextSize(fontSize);
        textToChange.setText(textes[selectedText]);

        if (fontSizeSlider != null) {
            fontSizeSlider.setProgress(fontSize);
            fontSizeSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    fontSize = i;
                    fontSizeText.setText("Rozmiar: " + fontSize);
                    textToChange.setTextSize(fontSize);

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        }

        if (changeTextButton != null) {
            changeTextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedText++;
                    if (selectedText == 3) {
                        selectedText = 0;
                    }
                    textToChange.setText(textes[selectedText]);
                }
            });
        }
    }
}