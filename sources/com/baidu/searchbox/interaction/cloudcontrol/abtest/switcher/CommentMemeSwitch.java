package com.baidu.searchbox.interaction.cloudcontrol.abtest.switcher;

import com.baidu.searchbox.interaction.cloudcontrol.abtest.InteractionAbTestSwitcher;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0006\u0010\u0005\u001a\u00020\u0002\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"commentMeme", "Lcom/baidu/searchbox/interaction/cloudcontrol/abtest/InteractionAbTestSwitcher;", "", "getCommentMeme", "()Lcom/baidu/searchbox/interaction/cloudcontrol/abtest/InteractionAbTestSwitcher;", "getCommentMemeSwitch", "lib-interaction-cloudcontrol_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentMemeSwitcher.kt */
public final class CommentMemeSwitch {
    private static final InteractionAbTestSwitcher<Boolean> commentMeme = new InteractionAbTestSwitcher<>("feed_comment_meme_switch", false);

    public static final InteractionAbTestSwitcher<Boolean> getCommentMeme() {
        return commentMeme;
    }

    public static final boolean getCommentMemeSwitch() {
        return commentMeme.getSwitcherValue().booleanValue();
    }
}
