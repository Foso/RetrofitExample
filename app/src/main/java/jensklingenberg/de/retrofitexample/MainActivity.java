package jensklingenberg.de.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SampleRetrofitInterface api = SampleRetrofitInterface.retrofit.create(SampleRetrofitInterface.class);
        Call<List<Post>> call = api.getPostList();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>>call, Response<List<Post>> response) {
                Log.i("INFO", String.valueOf(response.body().size()));


            }

            @Override
            public void onFailure(Call<List<Post>>call, Throwable t) {
                // Log error here since request failed

            }
        });

        Call<Post> callPost = api.getSinglePostQuery(1);

        callPost.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post>call, Response<Post> response) {
                Log.i("INFO", String.valueOf(response.body().getTitle()));


            }

            @Override
            public void onFailure(Call<Post>call, Throwable t) {
                // Log error here since request failed

            }
        });

        Call<String> deletePost = api.deletePost(1);

        deletePost.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String>call, Response<String> response) {
                Log.i("INFO", String.valueOf(response));


            }

            @Override
            public void onFailure(Call<String>call, Throwable t) {
                // Log error here since request failed

            }
        });



    }
}
