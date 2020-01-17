package com.geekbrains.lessonproject.user.list;

import java.util.Objects;

public class user {

    long id;
    String Name;
    String avatarURL;
    String webLink;

    public user(long id, String name, String avatarURL, String webLink) {
        this.id = id;
        Name = name;
        this.avatarURL = avatarURL;
        this.webLink = webLink;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getWebLink() {
        return webLink;
    }

    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        user user = (user) o;
        return id == user.id &&
                Objects.equals(Name, user.Name) &&
                Objects.equals(avatarURL, user.avatarURL) &&
                Objects.equals(webLink, user.webLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Name, avatarURL, webLink);
    }
}
