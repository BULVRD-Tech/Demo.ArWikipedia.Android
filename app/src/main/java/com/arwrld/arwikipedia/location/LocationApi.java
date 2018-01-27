package com.arwrld.arwikipedia.location;

import android.content.Context;

import java.util.List;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.config.LocationAccuracy;
import io.nlopez.smartlocation.location.config.LocationParams;
import io.nlopez.smartlocation.location.providers.LocationGooglePlayServicesWithFallbackProvider;

/**
 * Created by davidhodge on 1/26/18.
 */

public class LocationApi {

    public static void killAllUpdateListeners(Context mContext) {
        SmartLocation.with(mContext).location().stop();
    }

    public static void fetchNewLocation(Context mContext,
                                        OnLocationUpdatedListener onLocationUpdatedListener) {
        SmartLocation.with(mContext)
                .location(new LocationGooglePlayServicesWithFallbackProvider(mContext))
                .config(LocationParams.LAZY)
                .oneFix()
                .start(onLocationUpdatedListener);
    }

    public static void setUpLocationUpdates(Context mContext,
                                            OnLocationUpdatedListener onLocationUpdatedListener) {
        SmartLocation.with(mContext)
                .location(new LocationGooglePlayServicesWithFallbackProvider(mContext))
                .config(new LocationParams.Builder()
                        .setAccuracy(LocationAccuracy.HIGH)
                        .setDistance(3)
                        .setInterval(1000)
                        .build())
                .continuous()
                .start(onLocationUpdatedListener);
    }
}
