package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class SVGImageView extends ImageView {
    private static Method setLayerTypeMethod;
    private RenderOptions renderOptions = new RenderOptions();
    /* access modifiers changed from: private */
    public SVG svg = null;

    static {
        setLayerTypeMethod = null;
        Class<View> cls = View.class;
        try {
            setLayerTypeMethod = cls.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class});
        } catch (NoSuchMethodException e2) {
        }
    }

    public SVGImageView(Context context) {
        super(context);
    }

    public SVGImageView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        init(attrs, 0);
    }

    public SVGImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        if (!isInEditMode()) {
            TypedArray a2 = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.SVGImageView, defStyle, 0);
            try {
                String css = a2.getString(R.styleable.SVGImageView_css);
                if (css != null) {
                    this.renderOptions.css(css);
                }
                int resourceId = a2.getResourceId(R.styleable.SVGImageView_svg, -1);
                if (resourceId != -1) {
                    setImageResource(resourceId);
                    return;
                }
                String url = a2.getString(R.styleable.SVGImageView_svg);
                if (url != null) {
                    if (internalSetImageURI(Uri.parse(url))) {
                        a2.recycle();
                        return;
                    } else if (internalSetImageAsset(url)) {
                        a2.recycle();
                        return;
                    } else {
                        setFromString(url);
                    }
                }
                a2.recycle();
            } finally {
                a2.recycle();
            }
        }
    }

    public void setSVG(SVG svg2) {
        if (svg2 != null) {
            this.svg = svg2;
            doRender();
            return;
        }
        throw new IllegalArgumentException("Null value passed to setSVG()");
    }

    public void setSVG(SVG svg2, String css) {
        if (svg2 != null) {
            this.svg = svg2;
            this.renderOptions.css(css);
            doRender();
            return;
        }
        throw new IllegalArgumentException("Null value passed to setSVG()");
    }

    public void setCSS(String css) {
        this.renderOptions.css(css);
        doRender();
    }

    public void setImageResource(int resourceId) {
        new LoadResourceTask(getContext(), resourceId).execute(new Integer[0]);
    }

    public void setImageURI(Uri uri) {
        if (!internalSetImageURI(uri)) {
            Log.e("SVGImageView", "File not found: " + uri);
        }
    }

    public void setImageAsset(String filename) {
        if (!internalSetImageAsset(filename)) {
            Log.e("SVGImageView", "File not found: " + filename);
        }
    }

    private boolean internalSetImageURI(Uri uri) {
        try {
            InputStream is = getContext().getContentResolver().openInputStream(uri);
            new LoadURITask().execute(new InputStream[]{is});
            return true;
        } catch (FileNotFoundException e2) {
            return false;
        }
    }

    private boolean internalSetImageAsset(String filename) {
        try {
            InputStream is = getContext().getAssets().open(filename);
            new LoadURITask().execute(new InputStream[]{is});
            return true;
        } catch (IOException e2) {
            return false;
        }
    }

    private void setFromString(String url) {
        try {
            this.svg = SVG.getFromString(url);
            doRender();
        } catch (SVGParseException e2) {
            Log.e("SVGImageView", "Could not find SVG at: " + url);
        }
    }

    private class LoadResourceTask extends AsyncTask<Integer, Integer, SVG> {
        private Context context;
        private int resourceId;

        LoadResourceTask(Context context2, int resourceId2) {
            this.context = context2;
            this.resourceId = resourceId2;
        }

        /* access modifiers changed from: protected */
        public SVG doInBackground(Integer... params) {
            try {
                return SVG.getFromResource(this.context, this.resourceId);
            } catch (SVGParseException e2) {
                Log.e("SVGImageView", String.format("Error loading resource 0x%x: %s", new Object[]{Integer.valueOf(this.resourceId), e2.getMessage()}));
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(SVG svg) {
            SVG unused = SVGImageView.this.svg = svg;
            SVGImageView.this.doRender();
        }
    }

    private class LoadURITask extends AsyncTask<InputStream, Integer, SVG> {
        private LoadURITask() {
        }

        /* access modifiers changed from: protected */
        public SVG doInBackground(InputStream... is) {
            try {
                SVG fromInputStream = SVG.getFromInputStream(is[0]);
                try {
                    is[0].close();
                } catch (IOException e2) {
                }
                return fromInputStream;
            } catch (SVGParseException e3) {
                Log.e("SVGImageView", "Parse error loading URI: " + e3.getMessage());
                try {
                    is[0].close();
                    return null;
                } catch (IOException e4) {
                    return null;
                }
            } catch (Throwable th2) {
                try {
                    is[0].close();
                } catch (IOException e5) {
                }
                throw th2;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(SVG svg) {
            SVG unused = SVGImageView.this.svg = svg;
            SVGImageView.this.doRender();
        }
    }

    private void setSoftwareLayerType() {
        if (setLayerTypeMethod != null) {
            try {
                int LAYER_TYPE_SOFTWARE = View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()));
                setLayerTypeMethod.invoke(this, new Object[]{Integer.valueOf(LAYER_TYPE_SOFTWARE), null});
            } catch (Exception e2) {
                Log.w("SVGImageView", "Unexpected failure calling setLayerType", e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void doRender() {
        SVG svg2 = this.svg;
        if (svg2 != null) {
            Picture picture = svg2.renderToPicture(this.renderOptions);
            setSoftwareLayerType();
            setImageDrawable(new PictureDrawable(picture));
        }
    }
}
