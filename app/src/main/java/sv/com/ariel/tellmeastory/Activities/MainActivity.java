package sv.com.ariel.tellmeastory.Activities;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

import sv.com.ariel.tellmeastory.Historia;
import sv.com.ariel.tellmeastory.MyAdapter;
import sv.com.ariel.tellmeastory.Network.Api.LikeApi;
import sv.com.ariel.tellmeastory.Network.Api.StoryApi;

import sv.com.ariel.tellmeastory.Network.Model.LikesItem;
import sv.com.ariel.tellmeastory.Network.Model.ResponseSingleLike;
import sv.com.ariel.tellmeastory.Network.Model.ResponseSingleStory;
import sv.com.ariel.tellmeastory.Network.Model.ResponseStory;
import sv.com.ariel.tellmeastory.Network.Model.StoriesItem;
import sv.com.ariel.tellmeastory.R;

import static sv.com.ariel.tellmeastory.StoryInstance.HistoriaGlobal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener/*, SearchView.OnQueryTextListener*/ {

    private Toolbar toolbar;

    private List<StoriesItem> stories;
    private RecyclerView myReclyclerView;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    ProgressDialog progressDialog;
    private SearchView searchView;


    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Botones menu inferior

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

         swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Esto se ejecuta cada vez que se realiza el gesto
                getAllStories();


            }
        });



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
                public void onItemClick(StoriesItem story, int position) {
                   /// Toast.makeText(MainActivity.this,story + " - "+ position,Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainActivity.this, Historia.class);
                   // intent.putExtra("Historia", story); //Your id
                    HistoriaGlobal = story;
                    startActivity(intent);
                }

                @Override
                public void onLikeClick(StoriesItem Story, int position) {
                    LikesItem liketmp = new LikesItem();
                    liketmp.setIdStory(Story.getId());
                    liketmp.setIdUsuario("1");
                    liketmp.setState(1);

                    like(liketmp);
                   // Toast.makeText(MainActivity.this, "Like", Toast.LENGTH_SHORT).show();
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

    private void like(LikesItem like)
    {


        LikeApi likeApi = new LikeApi();
        likeApi.post(like, new LikeApi.onResponseReadyListener() {
            @Override
            public void onResponseReady(ResponseSingleLike user) {
                if(user!= null)
                {
                    getAllStories();
                }

            }
        });
    }

    private void getAllStories(){
        progressDialog.show();
        StoryApi storyApi = new StoryApi();
        storyApi.get(new StoryApi.onResponseReadyListener() {
            @Override
            public void onResponseReady(ResponseStory storyMain) {
                if(storyMain!=null)
                {
                    stories= storyMain.getData();
                    swipeRefreshLayout.setRefreshing(false);

                    fillRecycler();


                }
                else{
                    Toast.makeText(MainActivity.this, "Error en la conexión", Toast.LENGTH_SHORT).show();
                }
                progressDialog.hide();
            }

            @Override
            public void onResponseSingleReady(ResponseSingleStory storyMain) {
                ///No usar
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
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem item = menu.findItem(R.id.buscar);
        SearchView searchView =(SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
        return true;
    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        try {
            ArrayList<StoriesItem>listaFiltrada =  filter(stories,s);
            myAdapter.setFilter(stories);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    private ArrayList<StoriesItem> filter(List<StoriesItem> historias, String texto)
    {
        ArrayList<StoriesItem>listaFiltrada= new ArrayList<>();

        try{
            texto=texto.toLowerCase();
            for (StoriesItem story: historias){
                String historia = story.getName().toLowerCase();

                if(historia.contains(texto)){
                    listaFiltrada.add(story);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listaFiltrada;
    }
*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);





        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                // mAdapter.getFilter().filter(query);
              myAdapter.getFilter().filter(query);
            //    Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();






                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                /// mAdapter.getFilter().filter(query);

                myAdapter.getFilter().filter(query);

             //   Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();


                return false;
            }
        });

        return true;
    }

}
