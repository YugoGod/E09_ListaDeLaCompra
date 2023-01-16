package hugo.monton.blanco.e09_listadelacompra.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hugo.monton.blanco.e09_listadelacompra.modelos.Producto;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductoVH> {

    private List<Producto> objects;
    private int resource;
    private Context context;

    @NonNull
    @Override
    public ProductosAdapter.ProductoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductosAdapter.ProductoVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class ProductoVH extends RecyclerView.ViewHolder {
        public ProductoVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
