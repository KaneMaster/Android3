package com.aseevei.githubuserstest.user.data.responce;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("login") private String name;
    @SerializedName("id") private long id;
    @SerializedName("avatar_url") private String avatarUrl;
    @SerializedName("url") private String webLink;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getWebLink() {
        return webLink;
    }

    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }
}
