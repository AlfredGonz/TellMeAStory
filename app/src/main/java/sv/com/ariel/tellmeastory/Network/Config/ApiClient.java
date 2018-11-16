package sv.com.ariel.tellmeastory.Network.Config;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import sv.com.ariel.tellmeastory.Network.Model.ResponseCategory;
import sv.com.ariel.tellmeastory.Network.Model.ResponseSingleLike;
import sv.com.ariel.tellmeastory.Network.Model.ResponseSingleSecction;
import sv.com.ariel.tellmeastory.Network.Model.ResponseSingleStory;
import sv.com.ariel.tellmeastory.Network.Model.ResponseSingleUser;
import sv.com.ariel.tellmeastory.Network.Model.ResponseStory;

/**
 * Created by DK-Ragnar on 27/8/2018.
 */

public interface ApiClient {

    @GET("/cuentame/public/api/stories")
    Call<ResponseStory> getStories();



    @FormUrlEncoded
    @POST("/cuentame/public/api/stories")
    Call<ResponseSingleStory> postStory(@Field("name")String name,
                                         @Field("state")int  state,
                                         @Field("url") String url,
                                         @Field("id_usuario")String idUsuario,
                                         @Field("id_category")int idCategoria);



    @FormUrlEncoded
    @POST("/cuentame/public/api/usuarios")
    Call<ResponseSingleUser> postUser(@Field("first_name")String name,
                                      @Field("last_name")String  state,
                                      @Field("email") String email,
                                      @Field("file")String photo,
                                      @Field("Id")String id);
    @GET("/cuentame/public/api/categories")
    Call<ResponseCategory> getCategories();

    @FormUrlEncoded
    @POST("/cuentame/public/api/stories")
    Call<ResponseSingleSecction> postSecction(@Field("id_story")int idStory,
                                              @Field("name") String name,
                                              @Field("description") String description,
                                              @Field("url")String url);
    @FormUrlEncoded
    @POST("/cuentame/public/api/usuario_stories")
    Call<ResponseSingleLike> postLike(@Field("id_usuario")String idUsuario,
                                      @Field("id_story") int idStory,
                                      @Field("comentario ") String comentario,
                                      @Field("state")int state);




}
