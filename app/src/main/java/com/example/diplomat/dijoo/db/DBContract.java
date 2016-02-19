package com.example.diplomat.dijoo.db;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;


/**
 * Created by Diplomat on 2/16/2016.
 */
public class DBContract {
        public static final String DB_NAME = "com.example.diplomat.dijoo.db.tasks";
        public static final int DB_VERSION = 1;
        public static final String TABLE = "DIJOO";
        public static final String AUTHORITY = "com.example.diplomat.dijoo.db";
        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE);
        public static final int TASKS_LIST = 1;
        public static final int TASKS_ITEM = 2;
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/example.tasksDB/"+TABLE;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/example/tasksDB" + TABLE;


        public class Columns {
            public static final String TASK = "task";
            public static final String DIJOO_ID = BaseColumns._ID;
            public static final String DIJOO_TITLE       = "dijooTitle";
            public static final String DIJOO_CATEGORY   = "dijooCategory";
            public static final String DIJOO_UNITS      = "dijooUnits";


        }
    }