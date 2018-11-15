package sv.com.ariel.tellmeastory.Network.Api;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import sv.com.ariel.tellmeastory.Network.Config.ApiClient;
import sv.com.ariel.tellmeastory.Network.Config.ApiProvider;
import sv.com.ariel.tellmeastory.Network.Model.ResponseSingleStory;
import sv.com.ariel.tellmeastory.Network.Model.ResponseSingleUser;
import sv.com.ariel.tellmeastory.Network.Model.ResponseStory;
import sv.com.ariel.tellmeastory.Network.Model.StoriesItem;
import sv.com.ariel.tellmeastory.Network.Model.UserItem;

public class UserApi {
    private ApiClient client;
    public UserApi(){
        ApiProvider provider = new ApiProvider();
        client = provider.registerDasClient();
    }



    public void post(UserItem user, final UserApi.onResponseReadyListener listener){

        client.postUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getFile(), user.getId()).enqueue(new Callback<ResponseSingleUser>() {
            @Override
            public void onResponse(Call<ResponseSingleUser> call, Response<ResponseSingleUser> response) {

                if(response.isSuccessful()){
                    listener.onResponseReady(response.body());

                }
                else{
                    listener.onResponseReady(null);
                    Log.d("USER","Response fail: "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseSingleUser> call, Throwable t) {
                listener.onResponseReady(null);
                Log.d("USER","Request fail: "+t.getCause());
            }
        });

    }

    public interface onResponseReadyListener{
        void onResponseReady (ResponseSingleUser user);

    }
}
