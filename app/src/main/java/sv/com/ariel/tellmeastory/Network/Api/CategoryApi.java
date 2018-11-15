package sv.com.ariel.tellmeastory.Network.Api;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sv.com.ariel.tellmeastory.Network.Config.ApiClient;
import sv.com.ariel.tellmeastory.Network.Config.ApiProvider;
import sv.com.ariel.tellmeastory.Network.Model.ResponseCategory;
import sv.com.ariel.tellmeastory.Network.Model.ResponseSingleStory;
import sv.com.ariel.tellmeastory.Network.Model.ResponseStory;
import sv.com.ariel.tellmeastory.Network.Model.StoriesItem;

public class CategoryApi {

    private ApiClient client;
    public CategoryApi(){
        ApiProvider provider = new ApiProvider();
        client = provider.registerDasClient();
    }

    public void get(final CategoryApi.onResponseReadyListener listener){

        client.getCategories().enqueue(new Callback<ResponseCategory>() {
            @Override
            public void onResponse(Call<ResponseCategory> call, Response<ResponseCategory> response) {

                if(response.isSuccessful()){
                    listener.onResponseReady(response.body());

                }
                else{
                    listener.onResponseReady(null);
                    Log.d("CATEGORY","Response fail: "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseCategory> call, Throwable t) {
                listener.onResponseReady(null);
                Log.d("CATEGORY","Request fail: "+t.getCause());
            }
        });
    }
    public interface onResponseReadyListener{
        void onResponseReady (ResponseCategory categoryMain);

    }

}
