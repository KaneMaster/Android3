package com.aseevei.githubuserstest.user.data;

import java.io.IOException;
import java.util.List;

import io.reactivex.Single;

public interface UserRepository {

    Single<List<User>> getUsers() throws IOException;

}