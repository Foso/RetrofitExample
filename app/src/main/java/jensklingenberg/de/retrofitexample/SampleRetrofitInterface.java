package jensklingenberg.de.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jens on 24.08.16.
 */
public interface SampleRetrofitInterface {

        @GET("/posts")
        Call<List<Post>> getPostList();

        @GET("/posts/{id}")
        Call<Post> getSinglePost(@Path("id") int postId);

        @GET("/posts/")
        Call<Post> getSinglePostQuery(@Query("userId") int userId);

        @PUT("/posts/{id}")
        Call<Post> putSinglePost(@Path("id") int postId);

        @DELETE("/posts/{id}")
        Call<String> deletePost(@Path("id") int postId);

        @POST("users/new")
        Call<Post> createPost(@Body Post post);



    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com")
            .build();

}
