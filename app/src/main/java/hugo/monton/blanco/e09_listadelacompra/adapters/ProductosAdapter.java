package hugo.monton.blanco.e09_listadelacompra.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

import hugo.monton.blanco.e09_listadelacompra.R;
import hugo.monton.blanco.e09_listadelacompra.modelos.Producto;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductoVH> {

    private List<Producto> objects;
    private int resource;
    private Context context;
    private DatabaseReference reference;

    public ProductosAdapter(List<Producto> objects, int resource, Context context, DatabaseReference reference) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;
        this.reference = reference;
    }

    @NonNull
    @Override
    public ProductosAdapter.ProductoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productoView = LayoutInflater.from(context).inflate(resource, null);

        productoView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        return new ProductoVH(productoView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductosAdapter.ProductoVH holder, int position) {
        Producto p = objects.get(position);

        holder.lblPrecio.setText(p.getPrecioMoneda());
        holder.lblCantidad.setText(p.getCantidadTexto());
        holder.lblNombre.setText(p.getNombre());

        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objects.remove(holder.getAdapterPosition());
                reference.setValue(objects);
            }
        });

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class ProductoVH extends RecyclerView.ViewHolder {

        private TextView lblNombre;
        private TextView lblCantidad;
        private TextView lblPrecio;
        private ImageButton btnEliminar;

        public ProductoVH(@NonNull View itemView) {
            super(itemView);

            lblNombre = itemView.findViewById(R.id.lblNombreCard);
            lblCantidad = itemView.findViewById(R.id.lblCantidadCard);
            lblPrecio = itemView.findViewById(R.id.lblPrecioCard);
            btnEliminar = itemView.findViewById(R.id.btnDeleteCard);

        }
    }
}
