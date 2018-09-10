package sv.com.ariel.tellmeastory;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import sv.com.ariel.tellmeastory.Network.Api.StoryApi;
import sv.com.ariel.tellmeastory.Network.Model.Story;
import sv.com.ariel.tellmeastory.Network.Model.StoryMain;

public class MainActivity extends AppCompatActivity {
    private List<Story> stories;
    private RecyclerView myReclyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

                    Intent intent = new Intent(MainActivity.this, StoryActivity.class);
                    startActivity(intent);
                }
            });
            //todos los tipos de layout manager con los que se puede jugar con el recycler view
            myLayoutManager = new LinearLayoutManager(this);
            //myLayoutManager = new GridLayoutManager(this,2);
            // myLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
            //solo en caso que sepamos que el tamaño del layout no va a cambiar ahrehgamos esto e incrementa el rendimiento, aunque de nada sirve con el StraggeredGridLayout porque cambia los tamaños
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

}
