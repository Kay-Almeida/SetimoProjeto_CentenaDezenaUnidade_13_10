package kailaine.mobile.setimoprojeto_centenadezenaunidade_13_10;
/*
 *@author:<Kailaine Almeida de Souza RA: 1110482313026>
 */
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNumero;
    private TextView tvCentena, tvDezena, tvUnidade, tvErro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNumero = findViewById(R.id.etNumero);
        tvCentena = findViewById(R.id.tvCentena);
        tvDezena = findViewById(R.id.tvDezena);
        tvUnidade = findViewById(R.id.tvUnidade);
        tvErro = findViewById(R.id.tvErro);

        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc() {
        String input = etNumero.getText().toString();

        tvErro.setText("");

        if (input.isEmpty()) {
            tvErro.setText("Por favor, insira um número.");
            return;
        }

        int numero = Integer.parseInt(input);

        if (numero < 100 || numero > 999) {
            tvErro.setText("Número inválido! Insira um número entre 100 e 999.");
            return;
        }

        int centena = numero / 100;
        int dezena = (numero / 10) % 10;
        int unidade = numero % 10;

        tvCentena.setText("CENTENA = " + centena);
        tvDezena.setText("DEZENA = " + dezena);
        tvUnidade.setText("UNIDADE = " + unidade);

        etNumero.setText("");
    }
}
