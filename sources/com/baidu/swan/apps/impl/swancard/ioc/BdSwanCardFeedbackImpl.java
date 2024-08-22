package com.baidu.swan.apps.impl.swancard.ioc;

import com.baidu.swan.apps.impl.feedback.SwanAppFeedbackHelper;
import com.baidu.swan.card.card.SwanCardManager;
import com.baidu.swan.card.ioc.interfaces.feedback.ISwanCardFeedback;

public class BdSwanCardFeedbackImpl implements ISwanCardFeedback {
    public void handleFeedback(String cardId) {
        SwanAppFeedbackHelper.handleFeedback(SwanCardManager.get().getCard(cardId), "");
    }
}
