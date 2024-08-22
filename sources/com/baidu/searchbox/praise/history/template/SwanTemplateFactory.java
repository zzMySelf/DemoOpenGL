package com.baidu.searchbox.praise.history.template;

import com.baidu.searchbox.userassetsaggr.container.template.TemplateEnum;

public class SwanTemplateFactory implements IPraiseTemplateFactory {
    public IPraiseTemplate createTemplate(PraiseTemplateEnum templateEnum) {
        if (templateEnum == null) {
            return null;
        }
        switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$praise$history$template$PraiseTemplateEnum[templateEnum.ordinal()]) {
            case 1:
                return new TextTemplate(this, (AnonymousClass1) null);
            case 2:
                return new ImageTemplate(this, (AnonymousClass1) null);
            case 3:
                return new AtlasTemplate(this, (AnonymousClass1) null);
            case 4:
                return new VideoTemplate(this, (AnonymousClass1) null);
            default:
                return null;
        }
    }

    /* renamed from: com.baidu.searchbox.praise.history.template.SwanTemplateFactory$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$praise$history$template$PraiseTemplateEnum;

        static {
            int[] iArr = new int[PraiseTemplateEnum.values().length];
            $SwitchMap$com$baidu$searchbox$praise$history$template$PraiseTemplateEnum = iArr;
            try {
                iArr[PraiseTemplateEnum.SWAN_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$praise$history$template$PraiseTemplateEnum[PraiseTemplateEnum.SWAN_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$praise$history$template$PraiseTemplateEnum[PraiseTemplateEnum.SWAN_ATLAS.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$praise$history$template$PraiseTemplateEnum[PraiseTemplateEnum.SWAN_VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private class TextTemplate extends BasePraiseTemplate {
        private TextTemplate() {
        }

        /* synthetic */ TextTemplate(SwanTemplateFactory x0, AnonymousClass1 x1) {
            this();
        }

        /* access modifiers changed from: protected */
        public TemplateEnum getTemplateType() {
            return TemplateEnum.SWAN_TEXT;
        }
    }

    private class ImageTemplate extends BasePraiseTemplate {
        private ImageTemplate() {
        }

        /* synthetic */ ImageTemplate(SwanTemplateFactory x0, AnonymousClass1 x1) {
            this();
        }

        /* access modifiers changed from: protected */
        public TemplateEnum getTemplateType() {
            return TemplateEnum.SWAN_IMAGE;
        }
    }

    private class AtlasTemplate extends BasePraiseTemplate {
        private AtlasTemplate() {
        }

        /* synthetic */ AtlasTemplate(SwanTemplateFactory x0, AnonymousClass1 x1) {
            this();
        }

        /* access modifiers changed from: protected */
        public TemplateEnum getTemplateType() {
            return TemplateEnum.SWAN_ATLAS;
        }
    }

    private class VideoTemplate extends BasePraiseTemplate {
        private VideoTemplate() {
        }

        /* synthetic */ VideoTemplate(SwanTemplateFactory x0, AnonymousClass1 x1) {
            this();
        }

        /* access modifiers changed from: protected */
        public TemplateEnum getTemplateType() {
            return TemplateEnum.VIDEO_CLASSIFY;
        }
    }
}
