package sv.com.ariel.tellmeastory.Network.Api;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sv.com.ariel.tellmeastory.Network.Config.ApiClient;
import sv.com.ariel.tellmeastory.Network.Config.ApiProvider;
import sv.com.ariel.tellmeastory.Network.Model.ResponseSingleStory;
import sv.com.ariel.tellmeastory.Network.Model.ResponseStory;
import sv.com.ariel.tellmeastory.Network.Model.StoriesItem;

/**
 * Created by Ariel on 09/09/2018.
 */

public class StoryApi {
    private ApiClient client;
    public StoryApi(){
        ApiProvider provider = new ApiProvider();
        client = provider.registerDasClient();
    }

    public void get(final StoryApi.onResponseReadyListener listener){

        client.getStories().enqueue(new Callback<ResponseStory>() {
            @Override
            public void onResponse(Call<ResponseStory> call, Response<ResponseStory> response) {

                if(response.isSuccessful()){
                    listener.onResponseReady(response.body());

                }
                else{
                    listener.onResponseReady(null);
                    Log.d("STORY","Response fail: "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseStory> call, Throwable t) {
                listener.onResponseReady(null);
                Log.d("STORY","Request fail: "+t.getCause());
            }
        });

    }
    public void post(StoriesItem story, final StoryApi.onResponseReadyListener listener){

        client.postStory(story.getName(), story.getState(),story.getUrl(),story.getIdUsuario(),story.getIdCategory()).enqueue(new Callback<ResponseSingleStory>() {
            @Override
            public void onResponse(Call<ResponseSingleStory> call, Response<ResponseSingleStory> response) {

                if(response.isSuccessful()){
                    listener.onResponseSingleReady(response.body());

                }
                else{
                    listener.onResponseReady(null);
                    Log.d("STORY","Response fail: "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseSingleStory> call, Throwable t) {
                listener.onResponseReady(null);
                Log.d("STORY","Request fail: "+t.getCause());
            }
        });

    }

    public interface onResponseReadyListener{
        void onResponseReady (ResponseStory storyMain);
        void onResponseSingleReady (ResponseSingleStory storyMain);

    }
}
