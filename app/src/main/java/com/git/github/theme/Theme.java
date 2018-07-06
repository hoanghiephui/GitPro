/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 8:52 AM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 8:52 AM
 *
 */

package com.git.github.theme;

import com.git.github.R;
import com.git.github.model.EnumCode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

public enum Theme implements EnumCode {
    LIGHT(0, "light", R.style.ThemeLight, R.string.color_theme_light),
    DARK(1, "dark", R.style.ThemeDark, R.string.color_theme_dark),
    BLACK(2, "black", R.style.ThemeBlack, R.string.color_theme_black);

    private final int marshallingId;
    private final String funnelName;
    @StyleRes
    private final int resourceId;
    @StringRes
    private final int nameId;

    public static Theme getFallback() {
        return LIGHT;
    }

    @Nullable
    public static Theme ofMarshallingId(int id) {
        for (Theme theme : values()) {
            if (theme.getMarshallingId() == id) {
                return theme;
            }
        }
        return null;
    }

    public int getMarshallingId() {
        return marshallingId;
    }

    @Override public int code() {
        return marshallingId;
    }

    @NonNull
    public String getFunnelName() {
        return funnelName;
    }

    @StyleRes public int getResourceId() {
        return resourceId;
    }

    @StringRes public int getNameId() {
        return nameId;
    }

    public boolean isDefault() {
        return this == getFallback();
    }

    public boolean isDark() {
        return this == DARK || this == BLACK;
    }

    Theme(int marshallingId, String funnelName, @StyleRes int resourceId, @StringRes int nameId) {
        this.marshallingId = marshallingId;
        this.funnelName = funnelName;
        this.resourceId = resourceId;
        this.nameId = nameId;
    }
}
