package com.baidu.searchbox.player.utils;

import android.animation.Animator;
import android.view.View;
import com.baidu.searchbox.player.slot.ControlSlotManifest;
import com.baidu.searchbox.player.slot.ISlot;
import com.baidu.searchbox.player.slot.ISlotView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "slot", "Lcom/baidu/searchbox/player/slot/ISlot;", "slotViewShadow", "Lcom/baidu/searchbox/player/slot/ISlotView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LayerUtil.kt */
final class LayerUtil$controlAnimation$1 extends Lambda implements Function2<ISlot, ISlotView, Unit> {
    final /* synthetic */ Function1<ISlotView, Unit> $endCallback;
    final /* synthetic */ boolean $isLightWakeup;
    final /* synthetic */ boolean $lockStateChange;
    final /* synthetic */ Function1<ISlotView, Unit> $startCallback;
    final /* synthetic */ int $visibility;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayerUtil$controlAnimation$1(int i2, boolean z, boolean z2, Function1<? super ISlotView, Unit> function1, Function1<? super ISlotView, Unit> function12) {
        super(2);
        this.$visibility = i2;
        this.$isLightWakeup = z;
        this.$lockStateChange = z2;
        this.$endCallback = function1;
        this.$startCallback = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((ISlot) p1, (ISlotView) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(ISlot slot, ISlotView slotViewShadow) {
        boolean z;
        boolean z2;
        boolean z3;
        Animator animator;
        Animator animator2;
        Animator animator3;
        Animator animator4;
        Animator animator5;
        Animator animator6;
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(slotViewShadow, "slotViewShadow");
        View slotView = slotViewShadow.getView();
        Animator animator7 = null;
        boolean z4 = true;
        if (slot instanceof ControlSlotManifest.TitleSlot) {
            z = true;
        } else {
            z = slot instanceof ControlSlotManifest.MenuSlot;
        }
        if (z) {
            z2 = true;
        } else {
            z2 = slot instanceof ControlSlotManifest.AuthorSlot;
        }
        if (z2) {
            if (this.$visibility == 0) {
                animator6 = LayerUtil.slideInFromTop(slotView);
            } else {
                animator6 = LayerUtil.slideOutToTop(slotView);
            }
            animator7 = animator6;
        } else if (slot instanceof ControlSlotManifest.LeftCenterSlot.Bottom) {
            if (!this.$isLightWakeup) {
                if (this.$visibility == 0) {
                    animator5 = LayerUtil.slideInFromLeft(slotView);
                } else {
                    animator5 = LayerUtil.slideOutToLeft(slotView);
                }
                animator7 = animator5;
            }
        } else if (slot instanceof ControlSlotManifest.LeftCenterSlot.Lock) {
            if (!this.$isLightWakeup && !this.$lockStateChange) {
                if (this.$visibility == 0) {
                    animator4 = LayerUtil.slideInFromLeft(slotView);
                } else {
                    animator4 = LayerUtil.slideOutToLeft(slotView);
                }
                animator7 = animator4;
            }
        } else if (!(slot instanceof ControlSlotManifest.RightCenterSlot)) {
            if (slot instanceof ControlSlotManifest.RightBottomSlot) {
                z3 = true;
            } else {
                z3 = slot instanceof ControlSlotManifest.InteractSlot;
            }
            if (z3) {
                if (!this.$isLightWakeup) {
                    if (this.$visibility == 0) {
                        animator2 = LayerUtil.slideInFromBottom(slotView);
                    } else {
                        animator2 = LayerUtil.slideOutToBottom(slotView);
                    }
                    animator7 = animator2;
                }
            } else if (slot instanceof ControlSlotManifest.SeekBarSlot) {
                if (!this.$isLightWakeup) {
                    if (this.$visibility == 0) {
                        animator = LayerUtil.slideInFromBottom(slotView);
                    } else {
                        animator = LayerUtil.slideOutToBottom(slotView);
                    }
                    animator7 = animator;
                }
            } else if (slot instanceof ControlSlotManifest.PlaySlot) {
                if (!this.$isLightWakeup) {
                    if (this.$visibility != 0) {
                        z4 = false;
                    }
                    animator7 = LayerUtil.alphaAnimator(slotView, z4);
                }
            } else if ((slot instanceof ControlSlotManifest.SeekCenterTopSlot) && !this.$isLightWakeup) {
                if (this.$visibility != 0) {
                    z4 = false;
                }
                animator7 = LayerUtil.alphaAnimator(slotView, z4);
            }
        } else if (!this.$isLightWakeup) {
            if (this.$visibility == 0) {
                animator3 = LayerUtil.slideInFromRight(slotView);
            } else {
                animator3 = LayerUtil.slideOutToRight(slotView);
            }
            animator7 = animator3;
        }
        if (animator7 != null) {
            Animator $this$invoke_u24lambda_u2d0 = animator7;
            $this$invoke_u24lambda_u2d0.addListener(new LayerUtil$controlAnimation$1$1$1(this.$startCallback, slotViewShadow, this.$endCallback));
            $this$invoke_u24lambda_u2d0.start();
            return;
        }
        Function1<ISlotView, Unit> function1 = this.$endCallback;
        if (function1 != null) {
            function1.invoke(slotViewShadow);
        }
    }
}
