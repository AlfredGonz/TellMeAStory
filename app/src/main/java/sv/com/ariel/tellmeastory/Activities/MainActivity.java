package sv.com.ariel.tellmeastory.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

import sv.com.ariel.tellmeastory.MyAdapter;
import sv.com.ariel.tellmeastory.Network.Api.StoryApi;
import sv.com.ariel.tellmeastory.Network.Model.Story;
import sv.com.ariel.tellmeastory.Network.Model.StoryMain;

import sv.com.ariel.tellmeastory.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private List<Story> stories;
    private RecyclerView myReclyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton home = (ImageButton)findViewById(R.id.inicio);
        home.setOnClickListener(this);

        ImageButton biblio = (ImageButton)findViewById(R.id.biblioteca) ;
        biblio.setOnClickListener(this);

        ImageButton agregar = (ImageButton)findViewById(R.id.agregar) ;
        agregar.setOnClickListener(this);

        ImageButton noti = (ImageButton)findViewById(R.id.actualizaciones) ;
        noti.setOnClickListener(this);

        ImageButton usuario = (ImageButton)findViewById(R.id.usuario) ;
        usuario.setOnClickListener(this);

        progressDialog  = new ProgressDialog(this);
        progressDialog.setMessage("Cargando historias...");
        progressDialog.setCancelable(false);
        this.getAllStories();

    }


    private void fillRecycler(){
        try{

            myReclyclerView = (RecyclerView) findViewById(R.id.storyRecycler);
            myAdapter = new MyAdapter(stories, R.layout.item,new MyAdapter.onItemClickListener(){
                @Override
                public void onItemClick(Story story, int position) {
                    Toast.makeText(MainActivity.this,story + " - "+ position,Toast.LENGTH_LONG).show();

                   // Intent intent = new Intent(MainActivity.this, StoryActivity.class);
                   // startActivity(intent);
                }
            });
            //todos los tipos de layout manager con los que se puede jugar con el recycler view
            myLayoutManager = new LinearLayoutManager(this);
            //myLayoutManager = new GridLayoutManager(this,2);
            // myLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
            //solo en caso que sepamos que el tamaño del layout no va a cambiar agregamos esto e incrementa
            // el rendimiento, aunque de nada sirve con el StraggeredGridLayout porque cambia los tamaños
            myReclyclerView.setHasFixedSize(true);
            //animacion por defecto
            myReclyclerView.setItemAnimator(new DefaultItemAnimator());

            myReclyclerView.setLayoutManager(myLayoutManager);
            myReclyclerView.setAdapter(myAdapter);
        }catch(Exception e)
        {
            System.out.println("Error :" + e.getMessage());
        }
    }

    private void getAllStories(){
        progressDialog.show();
        StoryApi storyApi = new StoryApi();
        storyApi.get(new StoryApi.onResponseReadyListener() {
            @Override
            public void onResponseReady(StoryMain storyMain) {
                if(storyMain!=null)
                {
                    stories= storyMain.getData();
                    fillRecycler();
                }
                progressDialog.hide();
            }
        });
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.inicio:
                Intent intent =  new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.biblioteca:
                intent =  new Intent(MainActivity.this, Biblioteca.class);
                startActivity(intent);
                break;

            case R.id.agregar:
                intent =  new Intent(MainActivity.this, AgregarHistoria.class);
                startActivity(intent);
                break;

            case R.id.actualizaciones:
                intent =  new Intent(MainActivity.this, Notificaciones.class);
                startActivity(intent);
                break;

            case R.id.usuario:
                intent =  new Intent(MainActivity.this, Usuario.class);
                startActivity(intent);
                break;

            default:
                break;
        }

    }
}
