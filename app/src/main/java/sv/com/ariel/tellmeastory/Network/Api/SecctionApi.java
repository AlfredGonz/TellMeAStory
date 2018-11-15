package sv.com.ariel.tellmeastory.Network.Api;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import sv.com.ariel.tellmeastory.Network.Config.ApiClient;
import sv.com.ariel.tellmeastory.Network.Config.ApiProvider;
import sv.com.ariel.tellmeastory.Network.Model.ResponseSingleSecction;
import sv.com.ariel.tellmeastory.Network.Model.ResponseSingleUser;
import sv.com.ariel.tellmeastory.Network.Model.SectionsItem;
import sv.com.ariel.tellmeastory.Network.Model.UserItem;

public class SecctionApi {
    private ApiClient client;
    public SecctionApi(){
        ApiProvider provider = new ApiProvider();
        client = provider.registerDasClient();
    }



    public void post(SectionsItem secction, final SecctionApi.onResponseReadyListener listener){

        client.postSecction(secction.getIdStory(),secction.getName(),secction.getDescription(),secction.getUrl()).enqueue(new Callback<ResponseSingleSecction>() {
            @Override
            public void onResponse(Call<ResponseSingleSecction> call, Response<ResponseSingleSecction> response) {

                if(response.isSuccessful()){
                    listener.onResponseReady(response.body());

                }
                else{
                    listener.onResponseReady(null);
                    Log.d("SECCTION","Response fail: "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseSingleSecction> call, Throwable t) {
                listener.onResponseReady(null);
                Log.d("SECCTION","Request fail: "+t.getCause());
            }
        });

    }

    public interface onResponseReadyListener{
        void onResponseReady(ResponseSingleSecction secction);

    }
}
