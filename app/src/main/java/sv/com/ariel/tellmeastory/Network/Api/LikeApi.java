package sv.com.ariel.tellmeastory.Network.Api;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import sv.com.ariel.tellmeastory.Network.Config.ApiClient;
import sv.com.ariel.tellmeastory.Network.Config.ApiProvider;
import sv.com.ariel.tellmeastory.Network.Model.LikesItem;
import sv.com.ariel.tellmeastory.Network.Model.ResponseSingleLike;
import sv.com.ariel.tellmeastory.Network.Model.ResponseSingleUser;
import sv.com.ariel.tellmeastory.Network.Model.UserItem;

public class LikeApi {
    private ApiClient client;
    public LikeApi(){
        ApiProvider provider = new ApiProvider();
        client = provider.registerDasClient();
    }




    public void post(LikesItem like, final LikeApi.onResponseReadyListener listener){

        client.postLike(like.getIdUsuario(), like.getIdStory(),like.getComentario(),like.getState()).enqueue(new Callback<ResponseSingleLike>() {
            @Override
            public void onResponse(Call<ResponseSingleLike> call, Response<ResponseSingleLike> response) {

                if(response.isSuccessful()){
                    listener.onResponseReady(response.body());

                }
                else{
                    listener.onResponseReady(null);
                    Log.d("LIKE","Response fail: "+response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseSingleLike> call, Throwable t) {
                listener.onResponseReady(null);
                Log.d("LIKE","Request fail: "+t.getCause());
            }
        });

    }

    public interface onResponseReadyListener{
        void onResponseReady(ResponseSingleLike user);

    }
}
