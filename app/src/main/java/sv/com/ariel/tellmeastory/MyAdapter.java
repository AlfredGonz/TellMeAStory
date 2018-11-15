package sv.com.ariel.tellmeastory;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import sv.com.ariel.tellmeastory.Network.Model.StoriesItem;

/**
 * Created by Ariel on 09/09/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<StoriesItem> Storys;
    private int layout;
    private onItemClickListener listener;

    public MyAdapter(List<StoriesItem> Storys, int layout, onItemClickListener listener) {
        this.Storys = Storys;
        this.layout = layout;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //inlfamos el layout y le pasamos lso datos al constructor del view holder
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //llamamos al metodo bind del viewholder pasandole el objdeto y un listener
        holder.bind(Storys.get(position), listener);

    }

    @Override
    public int getItemCount() {
        return Storys.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        //Elementos UI a rellenar
        public TextView textViewStory;
        public ImageView imagen;


        public ViewHolder(View v){

            //recibe la vista completa para que la rendericemos, pasamos parametros a constructor padre
            // aqui tambien manejamos los datos de logioca para extraer datos y hacer referencias con los elementoss
            super(v);
            this.textViewStory =(TextView) v.findViewById(R.id.txtTitulo);
            imagen = v.findViewById(R.id.txthistoriaportada);

        }

        public void bind(final StoriesItem Story, final  onItemClickListener listener){
            //procesamos los datos para renderizar
            textViewStory.setText(Story.getName());




            try{
                Picasso.Builder builder = new Picasso.Builder(itemView.getContext());
                builder.downloader(new OkHttp3Downloader(itemView.getContext()));
                builder.build().load("http://ec2-54-244-63-119.us-west-2.compute.amazonaws.com/cuentame/public/images/"+Story.getUrl())
                        .placeholder((R.drawable.udb))
                        .error(R.drawable.ic_launcher_background)
                        .into(imagen);

            }catch (Exception e){

               /// Toast.makeText(this, "Error:" + e.getMessage() , Toast.LENGTH_SHORT).show();
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(Story, getAdapterPosition());
                }
            });

        }

    }
    ///declaramos las interfaces con los metodos a implementar
    public interface onItemClickListener{
        void onItemClick(StoriesItem Story, int position);
    }
}
