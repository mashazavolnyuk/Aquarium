package com.mashazavolnyuk.aquarium;

import android.content.Context;

import com.mashazavolnyuk.aquarium.set_fish.FishBlue;
import com.mashazavolnyuk.aquarium.set_fish.FishClown;
import com.mashazavolnyuk.aquarium.set_fish.FishDragon;
import com.mashazavolnyuk.aquarium.set_fish.FishYellow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dark Maleficent on 29.10.2016.
 */
public class FishStorage {

    private static FishStorage ourInstance = new FishStorage();
    private List<Fish> setFish = new ArrayList<>();

    public static FishStorage getInstance() {
        return ourInstance;
    }

    private FishStorage() {
    }

    public List<Fish> getSetFish(Context context) {
        setFish.clear();
        fillSetFish(context);
        return setFish;

    }

    private void fillSetFish(Context context) {
        setFish.add(new FishBlue(context));
        setFish.add(new FishClown(context));
        setFish.add(new FishDragon(context));
        setFish.add(new FishYellow(context));

    }
}
