package com.mashazavolnyuk.aquarium;

import com.vk.sdk.VKSdk;

/**
 * Created by Dark Maleficent on 12.10.2016.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
    }
}
