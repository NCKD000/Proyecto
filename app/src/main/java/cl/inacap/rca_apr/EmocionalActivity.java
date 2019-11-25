package cl.inacap.rca_apr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class EmocionalActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCambiar;
    ImageView emocional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emocional);
        btnCambiar = findViewById(R.id.btnCambiar);
        emocional = findViewById(R.id.emocional);

        btnCambiar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        emocional.setImageResource(R.drawable.r2);
    }

}
