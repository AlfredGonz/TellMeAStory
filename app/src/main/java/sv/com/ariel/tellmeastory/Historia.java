package sv.com.ariel.tellmeastory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import sv.com.ariel.tellmeastory.Network.Model.SectionItem;
import sv.com.ariel.tellmeastory.Network.Model.Story;

import static sv.com.ariel.tellmeastory.StoryInstance.HistoriaGlobal;

public class Historia extends AppCompatActivity {


    TextView title;
    TextView content;

    Button atras;
    Button delante;
   int totalPage=0;
   int currentPage=0;
   ImageView imageView;
    List<SectionItem> lista;
    SpeakRequest speakRequest;
    String textToSpeak="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);


        title= findViewById(R.id.txtSectionTitulo);
        content =findViewById(R.id.txtContenido);
        imageView=findViewById(R.id.imgPortada);

        atras = findViewById(R.id.btnAtras);
        delante=findViewById(R.id.btnDelante);
       // Bundle b = getIntent().getExtras();
        //Story story = b.getParcelable("Historia");
        Story story = HistoriaGlobal;

         lista = story.getSection();
        if(lista!= null)
        {
            if( lista.size()>0)
            {
                totalPage = lista.size()-1;
                setContent(lista.get(currentPage));

            }



        }


        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speakRequest.stopSpeak();
                currentPage--;
                if(currentPage <= 0)
                {
                    currentPage = totalPage;

                }
                setContent(lista.get(currentPage));



            }
        });
        delante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speakRequest.stopSpeak();
                currentPage++;
                if(currentPage>=totalPage)
                {
                    currentPage = 0;

                }
                setContent(lista.get(currentPage));


            }
        });

        if(speakRequest == null) {
            speakRequest = new SpeakRequest(this);
        }


    }

    private void setContent(SectionItem sectionItem)
    {

        try{
            Picasso.Builder builder = new Picasso.Builder(this);
            builder.downloader(new OkHttp3Downloader(this));
            builder.build().load(sectionItem.getUrl())
                    .placeholder((R.drawable.udb))
                    .error(R.drawable.ic_launcher_background)
                    .into(imageView);

        }catch (Exception e){

            Toast.makeText(this, "Error:" + e.getMessage() , Toast.LENGTH_SHORT).show();
        }


        title.setText("~"+sectionItem.getName()+"~");
        content.setText(sectionItem.getDescription());
        textToSpeak = sectionItem.getDescription();
    }

    @Override
    protected void onPause() {
        speakRequest.onDestroy();
        super.onPause();
    }

    public void hablar(View view) {
        if(speakRequest.isSpeaking()){
            speakRequest.stopSpeak();
        }
        speakRequest.speak(textToSpeak);

    }

    public void sonido(View view) {



    }
}
