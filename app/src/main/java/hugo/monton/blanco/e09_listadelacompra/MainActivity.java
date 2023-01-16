package hugo.monton.blanco.e09_listadelacompra;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import hugo.monton.blanco.e09_listadelacompra.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        setSupportActionBar(binding.toolbar);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

        if (item.getItemId() == R.id.btnLogout){
            FirebaseAuth.getInstance().signOut(); // Va a eliminar la relaccion con la IDAPP o la del USERID, por lo que la próxima vez que entre e la aplicación, no entre directamente.

            // Después del Logout tenemos que volver a la página inicial del 'lOGIN'.
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        return true;
    }
}