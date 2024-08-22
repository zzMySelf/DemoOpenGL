package com.baidu.searchbox.player.property;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.model.StringArrayBundle;
import com.baidu.searchbox.player.utils.BdVideoLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a5\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\u0010\f\u001a\f\u0010\r\u001a\u00020\u000b*\u00020\u0006H\u0007\u001a\f\u0010\u000e\u001a\u00020\u000b*\u00020\u0006H\u0007\u001a3\u0010\u000f\u001a\u0002H\u0005\"\u000e\b\u0000\u0010\u0005\u0018\u0001*\u0006\u0012\u0002\b\u00030\b*\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0011H\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u0016\u0010\u0013\u001a\u00020\u000b*\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u001a\u0018\u0010\u0016\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u0017\u001a\u00020\u0006H\u0000\u001a\u0014\u0010\u0018\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0000\u001a\u001c\u0010\u001b\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u001c\u0010\u001d\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u001c\u0010\u001f\u001a\u00020\u0004*\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a$\u0010\"\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006#"}, d2 = {"SCOPE_GLOBAL", "", "SCOPE_SINGLE", "changePropertyValue", "", "T", "Lcom/baidu/searchbox/player/BDVideoPlayer;", "property", "Lcom/baidu/searchbox/player/property/Property;", "value", "isNotify", "", "(Lcom/baidu/searchbox/player/BDVideoPlayer;Lcom/baidu/searchbox/player/property/Property;Ljava/lang/Object;Z)V", "getLockState", "getMuteState", "getProperty", "initializer", "Lkotlin/Function0;", "(Lcom/baidu/searchbox/player/BDVideoPlayer;Lkotlin/jvm/functions/Function0;)Lcom/baidu/searchbox/player/property/Property;", "isMatch", "Lcom/baidu/searchbox/player/property/Scope;", "target", "notifyChanged", "player", "processPropertyChanged", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "setLockState", "isLock", "setMuteState", "isMute", "setSpeedState", "speed", "", "syncFrom", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerProperties.kt */
public final class PlayerPropertyKit {
    private static final String SCOPE_GLOBAL = "scope_global";
    private static final String SCOPE_SINGLE = "scope_single";

    public static final /* synthetic */ <T extends Property<?>> T getProperty(BDVideoPlayer $this$getProperty, Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter($this$getProperty, "<this>");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        StringArrayBundle this_$iv = $this$getProperty.getProperties().getExtraProperty();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<Property> cls = Property.class;
        Class cls2 = cls;
        String key$iv = cls.getName();
        Intrinsics.checkNotNullExpressionValue(key$iv, "T::class.java.name");
        T this_$iv2 = this_$iv.getExtra(key$iv);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        Object obj = this_$iv2;
        Property property = this_$iv2;
        if (property != null) {
            return property;
        }
        Property property2 = initializer.invoke();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<Property> cls3 = Property.class;
        Class cls4 = cls3;
        $this$getProperty.getProperties().getExtraProperty().put(cls3.getName(), property2);
        return property2;
    }

    @StableApi
    public static final boolean getLockState(BDVideoPlayer $this$getLockState) {
        Intrinsics.checkNotNullParameter($this$getLockState, "<this>");
        return ((Boolean) $this$getLockState.getProperties().getLock().getState()).booleanValue();
    }

    @StableApi
    public static final void setLockState(BDVideoPlayer $this$setLockState, boolean isLock, boolean isNotify) {
        Intrinsics.checkNotNullParameter($this$setLockState, "<this>");
        changePropertyValue($this$setLockState, $this$setLockState.getProperties().getLock(), Boolean.valueOf(isLock), isNotify);
    }

    @StableApi
    public static final boolean getMuteState(BDVideoPlayer $this$getMuteState) {
        Intrinsics.checkNotNullParameter($this$getMuteState, "<this>");
        return ((Boolean) $this$getMuteState.getProperties().getMute().getState()).booleanValue();
    }

    @StableApi
    public static final void setMuteState(BDVideoPlayer $this$setMuteState, boolean isMute, boolean isNotify) {
        Intrinsics.checkNotNullParameter($this$setMuteState, "<this>");
        BdVideoLog.i($this$setMuteState.wrapMessage("setMuteMode(" + isMute + "), isNotify = " + isNotify + ", scope = " + $this$setMuteState.getProperties().getMute().getScope()));
        changePropertyValue($this$setMuteState, $this$setMuteState.getProperties().getMute(), Boolean.valueOf(isMute), isNotify);
    }

    @StableApi
    public static final void setSpeedState(BDVideoPlayer $this$setSpeedState, float speed, boolean isNotify) {
        Intrinsics.checkNotNullParameter($this$setSpeedState, "<this>");
        changePropertyValue($this$setSpeedState, $this$setSpeedState.getProperties().getSpeed(), Float.valueOf(speed), isNotify);
    }

    public static final <T> void changePropertyValue(BDVideoPlayer $this$changePropertyValue, Property<T> property, T value, boolean isNotify) {
        Function0 notifyDelegate;
        Intrinsics.checkNotNullParameter($this$changePropertyValue, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        if (!Intrinsics.areEqual((Object) property.getState(), (Object) value)) {
            if (isNotify) {
                notifyDelegate = new PlayerPropertyKit$changePropertyValue$notifyDelegate$1(property, $this$changePropertyValue);
            } else {
                notifyDelegate = null;
                Function0 function0 = null;
            }
            property.setState(value, notifyDelegate);
        }
    }

    public static final <T> void syncFrom(Property<T> $this$syncFrom, Property<T> property) {
        Intrinsics.checkNotNullParameter($this$syncFrom, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        if (Intrinsics.areEqual((Object) $this$syncFrom.getClass().getName(), (Object) property.getClass().getName())) {
            Property.setState$default($this$syncFrom, property.getState(), (Function0) null, 2, (Object) null);
            $this$syncFrom.setScope(property.getScope());
        }
    }

    public static final void notifyChanged(Property<?> $this$notifyChanged, BDVideoPlayer player) {
        Intrinsics.checkNotNullParameter($this$notifyChanged, "<this>");
        Intrinsics.checkNotNullParameter(player, "player");
        if (!Intrinsics.areEqual((Object) $this$notifyChanged.getScope(), (Object) SingleScope.INSTANCE)) {
            PropertyManager.INSTANCE.notifyPropertyChanged($this$notifyChanged, Integer.valueOf(player.hashCode()));
        }
    }

    public static final void processPropertyChanged(BDVideoPlayer $this$processPropertyChanged, VideoEvent event) {
        Intrinsics.checkNotNullParameter($this$processPropertyChanged, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getType() == 1 && !Intrinsics.areEqual(event.getSender(), (Object) Integer.valueOf($this$processPropertyChanged.hashCode()))) {
            String propertyName = event.getStringExtra(1);
            Object extra = event.getExtra(3);
            if (!(extra instanceof Scope)) {
                extra = null;
            }
            Scope scope = (Scope) extra;
            if (Intrinsics.areEqual((Object) propertyName, (Object) MuteProperty.class.getName())) {
                if (isMatch(scope, $this$processPropertyChanged.getProperties().getMute().getScope())) {
                    $this$processPropertyChanged.setMuteMode(event.getBooleanExtra(2), false);
                }
            } else if (Intrinsics.areEqual((Object) propertyName, (Object) SpeedProperty.class.getName()) && isMatch(scope, $this$processPropertyChanged.getProperties().getSpeed().getScope())) {
                $this$processPropertyChanged.setSpeed(event.getFloatExtra(2), false);
            }
        }
    }

    public static final boolean isMatch(Scope $this$isMatch, Scope target) {
        if ($this$isMatch == null) {
            return false;
        }
        return Intrinsics.areEqual((Object) $this$isMatch.getName(), (Object) target != null ? target.getName() : null);
    }
}
