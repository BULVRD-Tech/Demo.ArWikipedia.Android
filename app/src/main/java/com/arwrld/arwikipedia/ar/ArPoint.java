package com.arwrld.arwikipedia.ar;

import android.graphics.Bitmap;

import com.arwrld.arwikipedia.models.Geosearch;

/**
 * Created by davidhodge on 1/26/18.
 */

public class ArPoint {
    private Geosearch status;
    private Bitmap bitmap;

    public ArPoint(Geosearch parseObject, Bitmap bitmap) {
        this.status = parseObject;
        this.bitmap = bitmap;
    }

    public Geosearch getStatus() {
        return status;
    }

    public void setStatus(Geosearch parseObject) {
        this.status = parseObject;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
