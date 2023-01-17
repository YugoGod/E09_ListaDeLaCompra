package hugo.monton.blanco.e09_listadelacompra;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hugo.monton.blanco.e09_listadelacompra.adapters.ProductosAdapter;
import hugo.monton.blanco.e09_listadelacompra.databinding.ActivityMainBinding;
import hugo.monton.blanco.e09_listadelacompra.modelos.Producto;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<Producto> productosList;
    private ProductosAdapter adapter;
    private RecyclerView.LayoutManager lm;

    private FirebaseDatabase database;
    private DatabaseReference reference;


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        // String uid = user.getUid();
        setSupportActionBar(binding.toolbar);

        database = FirebaseDatabase.getInstance("https://e09-listadelacompra-default-rtdb.europe-west1.firebasedatabase.app/");
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        reference = database.getReference(uid).child("lista");


        productosList = new ArrayList<>();
        adapter = new ProductosAdapter(productosList, R.layout.producto_view_holder, this, reference);
        lm = new LinearLayoutManager(this);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                productosList.clear();
                if (snapshot.exists()) {
                    GenericTypeIndicator<ArrayList<Producto>> gti = new GenericTypeIndicator<ArrayList<Producto>>() {};
                    productosList.addAll(snapshot.getValue(gti));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        binding.contentMain.contenedor.setAdapter(adapter);
        binding.contentMain.contenedor.setLayoutManager(lm);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createProducto().show();
            }
        });
    }

    private AlertDialog createProducto() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Nuevo producto");
        builder.setCancelable(false);

        View productoView = getLayoutInflater().inflate(R.layout.producto_alert, null);

        EditText txtNombre = productoView.findViewById(R.id.txtNombreAlert);
        EditText txtCantidad = productoView.findViewById(R.id.txtCantidadAlert);
        EditText txtPrecio = productoView.findViewById(R.id.txtPrecioAlert);

        builder.setView(productoView);

        builder.setNegativeButton("Cancelar", null);
        builder.setPositiveButton("Crear", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String nombre = txtNombre.getText().toString();
                String cantidad = txtCantidad.getText().toString();
                String precio = txtPrecio.getText().toString();

                if (!nombre.isEmpty() && !cantidad.isEmpty() && !precio.isEmpty()) {
                    productosList.add(new Producto(nombre, Integer.parseInt(cantidad), Float.parseFloat(precio)));
                    // adapter.notifyItemInserted(productosList.size()-1);
                    reference.setValue(productosList); // Esto accionará el 'eventListener' de la referencia.
                }

            }
        });

        return builder.create();
    }


    /**
     * Especifica que Menú se va a cargar en la actividad
     * @param menu -> Es el huevo donde aparece el menú, y no lo controlamos nosotros, siempre lo controla Android.
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu); // Originalmente aparece con un 'return', pero se lo quitamos para poder añadir cosas debajo.

        getMenuInflater().inflate(R.menu.logout_menu, menu); // Aquí es donde especificamos que menú se va a poner.
        return true;
    }

    /**
     * Discriminar las diferentes acciones en base al elemento del menú seleccionado. Especie del 'setOnClickListener' de todo el menu´y envia la acción del botón seleccionado.
     * @param item -> El botón seleccionado.
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.btnLogout:
                FirebaseAuth.getInstance().signOut(); // Va a eliminar la relaccion con la IDAPP o la del USERID, por lo que la próxima vez que entre e la aplicación, no entre directamente.

                // Después del Logout tenemos que volver a la página inicial del 'lOGIN'.
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
            case R.id.btnDatosPersonales:
                startActivity(new Intent(this, AnyadirDatosPersonales.class));
                finish();
                break;
        }

        return true;
    }
}