package com.arwrld.arwikipedia.ar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.location.Location;
import android.opengl.Matrix;
import android.view.MotionEvent;
import android.view.View;

import com.arwrld.arwikipedia.MainActivity;
import com.arwrld.arwikipedia.location.LocationHelper;
import com.arwrld.arwikipedia.models.Geosearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidhodge on 1/26/18.
 */

public class ArOverlayView extends View {

    Context context;
    private float[] rotatedProjectionMatrix = new float[16];
    private Location currentLocation;
    private List<ArPoint> arPoints;

    private float[][] pointsXY;
    private Paint paint;
    final int radius = 30;
    private MainActivity mainActivity;

    public ArOverlayView(Context context, MainActivity mainActivity) {
        super(context);
        this.mainActivity = mainActivity;

        this.context = context;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        paint.setTextSize(60);

        //Demo points
        arPoints = new ArrayList<ArPoint>() {{
//            add(new ArPoint("Test", 0.0, 0.0, 0));
//            add(new ArPoint("Test", 0.0, 0.0, 0));
        }};
    }

    public void setDataPoints(ArrayList<ArPoint> arPoints) {
        this.arPoints = arPoints;
        pointsXY = new float[arPoints.size()][2];
        this.invalidate();
    }

    public void updateRotatedProjectionMatrix(float[] rotatedProjectionMatrix) {
        this.rotatedProjectionMatrix = rotatedProjectionMatrix;
        this.invalidate();
    }

    public void updateCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
        this.invalidate();
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        if (currentLocation == null) {
            return;
        }

        for (int i = 0; i < arPoints.size(); i++) {
            Geosearch parseObject = arPoints.get(i).getStatus();
            drawAttr(canvas, parseObject, i);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        float x = event.getX();
        float y = event.getY();

        if (pointsXY != null) {
            for (int i = 0; i < pointsXY.length; i++) {
                float xPoint = pointsXY[i][0];
                float yPoint = pointsXY[i][1];
                if (x > xPoint - 100 && x < xPoint + 100) {
                    if (y > yPoint - 100 && y < yPoint + 100) {
                        mainActivity.processTouchEvent(
                                arPoints.get(i).getStatus().getPageid());
                        break;
                    }
                }
            }
        }
        return false;
    }

    private void drawAttr(Canvas canvas, Geosearch status, int i) {

        Location location = new Location("ArLocation");
        location.setLatitude(status.getLat());
        location.setLongitude(status.getLon());
        location.setAltitude(0);

        float[] currentLocationInECEF = LocationHelper.WSG84toECEF(currentLocation);
        float[] pointInECEF = LocationHelper.WSG84toECEF(location);
        float[] pointInENU = LocationHelper.ECEFtoENU(currentLocation, currentLocationInECEF, pointInECEF);

        float[] cameraCoordinateVector = new float[4];
        Matrix.multiplyMV(cameraCoordinateVector, 0, rotatedProjectionMatrix, 0, pointInENU, 0);

        if (cameraCoordinateVector[2] < 0) {
            final float x = (0.5f + cameraCoordinateVector[0] / cameraCoordinateVector[3]) * canvas.getWidth();
            final float y = (0.5f - cameraCoordinateVector[1] / cameraCoordinateVector[3]) * canvas.getHeight();

            pointsXY[i][0] = x;
            pointsXY[i][1] = y;

            if (arPoints.get(i).getBitmap() != null) {
                canvas.drawBitmap(arPoints.get(i).getBitmap(), x, y, null);
            }
        }
    }
}