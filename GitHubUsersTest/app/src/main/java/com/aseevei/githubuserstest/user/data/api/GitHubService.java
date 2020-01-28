package com.aseevei.githubuserstest.user.data.api;

import com.aseevei.githubuserstest.user.data.responce.UserResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;


public interface GitHubService {
    @GET("users")
    Single<List<UserResponse>> getUsers();
}
