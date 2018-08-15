package com.acrs.userapp.util;

import android.Manifest;

public interface Permission {
    String[] camera=new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
    };

}
