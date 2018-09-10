package sv.com.ariel.tellmeastory.Network.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sv.com.ariel.tellmeastory.Network.Config.ApiClient;
import sv.com.ariel.tellmeastory.Network.Config.ApiProvider;
import sv.com.ariel.tellmeastory.Network.Model.StoryMain;

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

        client.getShakiApi().enqueue(new Callback<StoryMain>() {
            @Override
            public void onResponse(Call<StoryMain> call, Response<StoryMain> response) {

                if(response.isSuccessful())
                {
                    listener.onResponseReady(response.body());

                }
                else{
                    listener.onResponseReady(null);

                }
            }

            @Override
            public void onFailure(Call<StoryMain> call, Throwable t) {
                listener.onResponseReady(null);
            }
        });

    }
    public interface onResponseReadyListener{
        void onResponseReady (StoryMain storyMain);
    }
}
