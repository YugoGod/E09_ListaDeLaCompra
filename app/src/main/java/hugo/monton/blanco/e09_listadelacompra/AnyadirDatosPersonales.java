package hugo.monton.blanco.e09_listadelacompra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AnyadirDatosPersonales extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtTelefono;
    private Button btnCancelar;
    private Button btnGuardar;

    private FirebaseDatabase database;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyadir_datos_personales);
        inicializarVistas();



    }

    private void inicializarVistas() {
        txtNombre = findViewById(R.id.txtNombrePersonales);
        txtTelefono = findViewById(R.id.txtTelefonoPersonales);
        btnCancelar = findViewById(R.id.btnCancelarPersonales);
        btnGuardar = findViewById(R.id.btnGuardarPersonales);
    }
}