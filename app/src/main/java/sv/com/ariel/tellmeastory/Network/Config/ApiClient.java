package sv.com.ariel.tellmeastory.Network.Config;

import retrofit2.Call;
import retrofit2.http.GET;
import sv.com.ariel.tellmeastory.Network.Model.StoryMain;

/**
 * Created by DK-Ragnar on 27/8/2018.
 */

public interface ApiClient {

    @GET("1752558/raw")
    Call<StoryMain> getShakiApi();

}
