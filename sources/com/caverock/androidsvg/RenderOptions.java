package com.caverock.androidsvg;

import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.SVG;

public class RenderOptions {
    CSSParser.Ruleset css = null;
    PreserveAspectRatio preserveAspectRatio = null;
    String targetId = null;
    SVG.Box viewBox = null;
    String viewId = null;
    SVG.Box viewPort = null;

    public RenderOptions() {
    }

    public static RenderOptions create() {
        return new RenderOptions();
    }

    public RenderOptions(RenderOptions other) {
        if (other != null) {
            this.css = other.css;
            this.preserveAspectRatio = other.preserveAspectRatio;
            this.viewBox = other.viewBox;
            this.viewId = other.viewId;
            this.viewPort = other.viewPort;
        }
    }

    public RenderOptions css(String css2) {
        this.css = new CSSParser(CSSParser.Source.RenderOptions).parse(css2);
        return this;
    }

    public boolean hasCss() {
        CSSParser.Ruleset ruleset = this.css;
        return ruleset != null && ruleset.ruleCount() > 0;
    }

    public RenderOptions preserveAspectRatio(PreserveAspectRatio preserveAspectRatio2) {
        this.preserveAspectRatio = preserveAspectRatio2;
        return this;
    }

    public boolean hasPreserveAspectRatio() {
        return this.preserveAspectRatio != null;
    }

    public RenderOptions view(String viewId2) {
        this.viewId = viewId2;
        return this;
    }

    public boolean hasView() {
        return this.viewId != null;
    }

    public RenderOptions viewBox(float minX, float minY, float width, float height) {
        this.viewBox = new SVG.Box(minX, minY, width, height);
        return this;
    }

    public boolean hasViewBox() {
        return this.viewBox != null;
    }

    public RenderOptions viewPort(float minX, float minY, float width, float height) {
        this.viewPort = new SVG.Box(minX, minY, width, height);
        return this;
    }

    public boolean hasViewPort() {
        return this.viewPort != null;
    }

    public RenderOptions target(String targetId2) {
        this.targetId = targetId2;
        return this;
    }

    public boolean hasTarget() {
        return this.targetId != null;
    }
}
