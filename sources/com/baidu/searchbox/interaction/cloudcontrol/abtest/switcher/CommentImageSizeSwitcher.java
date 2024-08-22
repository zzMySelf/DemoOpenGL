package com.baidu.searchbox.interaction.cloudcontrol.abtest.switcher;

import com.baidu.searchbox.interaction.cloudcontrol.abtest.InteractionAbTestSwitcher;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0006\u0010\u0007\u001a\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"KEY_SWITCH_COMMENT_IMAGE_SIZE", "", "commentImageSizeSwitcher", "Lcom/baidu/searchbox/interaction/cloudcontrol/abtest/InteractionAbTestSwitcher;", "", "getCommentImageSizeSwitcher", "()Lcom/baidu/searchbox/interaction/cloudcontrol/abtest/InteractionAbTestSwitcher;", "getCommentImageSizeSwitch", "lib-interaction-cloudcontrol_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentImageSIzeSwitcher.kt */
public final class CommentImageSizeSwitcher {
    private static final String KEY_SWITCH_COMMENT_IMAGE_SIZE = "feed_comment_image_aspect";
    private static final InteractionAbTestSwitcher<Integer> commentImageSizeSwitcher = new InteractionAbTestSwitcher<>(KEY_SWITCH_COMMENT_IMAGE_SIZE, 0);

    public static final InteractionAbTestSwitcher<Integer> getCommentImageSizeSwitcher() {
        return commentImageSizeSwitcher;
    }

    public static final int getCommentImageSizeSwitch() {
        return commentImageSizeSwitcher.getSwitcherValue().intValue();
    }
}
