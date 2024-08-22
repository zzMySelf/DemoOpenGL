package com.baidu.searchbox.ioc;

import com.baidu.searchbox.ad.comment.CommentAdPolicy;
import com.baidu.searchbox.ad.comment.IAdCommentBridge;
import com.baidu.searchbox.comment.ad.ICommentAdPolicyManager;

public class AdCommentBridgeImpl implements IAdCommentBridge {
    public void writeAdPolicy(CommentAdPolicy policy) {
        ICommentAdPolicyManager policyManager = ICommentAdPolicyManager.Impl.get();
        policyManager.setAdMinFirstFloor(policy.mAdMinFirstFloor);
        policyManager.setDoubleListAdMinFirstFloor(policy.mDoubleListAdMinFirstFloor);
    }
}
