package com.aseevei.githubuserstest.user.data;

import com.aseevei.githubuserstest.user.data.api.GitHubService;
import com.aseevei.githubuserstest.user.data.responce.UserResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubUserRepository implements UserRepository {

    @Override
    public Single<List<User>> getUsers() {
            return getTempUsers().flatMap(users -> Observable.fromIterable(users)
            .map(userResponse -> new User(userResponse.getId(), userResponse.getName(),
                    userResponse.getName(),
                    userResponse.getAvatarUrl(),
                    userResponse.getWebLink())).toList());
    }



    private Single<List<UserResponse>> getTempUsers()  {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.github.com")
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        return service.getUsers();
    }


}