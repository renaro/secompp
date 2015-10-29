package com.renarosantos.secompp.model;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by renarosantos on 28/10/15.
 */

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase{

    public static final String NAME = "Secompp";
    public static final int VERSION = 1;

}