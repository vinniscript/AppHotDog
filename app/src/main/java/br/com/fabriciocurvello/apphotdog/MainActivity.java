package br.com.fabriciocurvello.apphotdog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Atribuição de variáveis

    EditText etNome;
    RadioGroup rgProteina;
    CheckBox cbKetchup;
    CheckBox cbMostarda;
    CheckBox cbMaionese;
    Switch swMilho;
    Switch swErvilha;
    Switch swQueijoRalado;
    Button btPedido;
    TextView tvSaidaPedido;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tv_titulo), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupViews();

        setupListener();

    } // fim do onCreate



    private void setupViews() {
        etNome = findViewById(R.id.et_nome);
        rgProteina = findViewById(R.id.rg_proteina);
        cbKetchup = findViewById(R.id.cb_ketchup);
        cbMostarda = findViewById(R.id.cb_mostarda);
        cbMaionese = findViewById(R.id.cb_maionese);
        swMilho = findViewById(R.id.sw_milho);
        swErvilha = findViewById(R.id.sw_ervilha);
        swQueijoRalado = findViewById(R.id.sw_queijo_ralado);
        btPedido = findViewById(R.id.bt_pedido);
        tvSaidaPedido = findViewById(R.id.tv_saida_pedido);
    }

    private void setupListener() {
        btPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cliente = nomeCliente();
                String molhos = molhosSelecionados();

                String pedido = cliente + molhos;
                tvSaidaPedido.setText(pedido);

                Toast.makeText(MainActivity.this, "Pedido enviado, " + cliente, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private String nomeCliente() {

        String cliente = etNome.getText().toString(); // o toString() é para converter o texto em String, por incrível que pareça, o texto não vem como String.
        if (cliente.isEmpty()) {
            cliente = "Não informou nome";
        }
        return "cliente: " + cliente;
    }

    private String molhosSelecionados() {


        return "Molhos selecionados: " + molhos;
    }

}