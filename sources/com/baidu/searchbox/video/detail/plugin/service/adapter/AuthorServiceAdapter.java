package com.baidu.searchbox.video.detail.plugin.service.adapter;

import com.baidu.searchbox.follow.view.AccountInfoAndFollowView;
import com.baidu.searchbox.video.detail.plugin.component.author.model.AuthorModel;
import com.baidu.searchbox.video.detail.plugin.service.author.IAuthorService;

public class AuthorServiceAdapter implements IAuthorService {
    public String getAuthorIcon() {
        return null;
    }

    public int getHeight() {
        return 0;
    }

    public AuthorModel getAuthorModel() {
        return null;
    }

    public AccountInfoAndFollowView getAuthorView() {
        return null;
    }

    public String getName() {
        return AuthorServiceAdapter.class.getName();
    }
}
