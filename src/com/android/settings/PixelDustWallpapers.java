package com.android.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.android.internal.logging.nano.MetricsProto.MetricsEvent;

import com.android.settings.R;
import com.android.settings.dashboard.SummaryLoader;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settingslib.search.Indexable;

public class PixelDustWallpapers extends SettingsPreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startWallpapers();
        finish();
    }

    private void startWallpapers(){
        Intent wallpapersExtrasIntent = new Intent();
        wallpapersExtrasIntent.setClassName(
                "com.pixeldust.wallpapers", "com.pixeldust.wallpapers.MainActivity");
        startActivity(wallpapersExtrasIntent);
    }

    @Override
    public int getMetricsCategory() {
        return MetricsEvent.PIXELDUST;
    }

    private static class SummaryProvider implements SummaryLoader.SummaryProvider {

        public SummaryProvider(Context context, SummaryLoader summaryLoader) {
        }

        @Override
        public void setListening(boolean listening) {
            if (listening) {
            }
        }
    }

    public static final SummaryLoader.SummaryProviderFactory SUMMARY_PROVIDER_FACTORY
            = new SummaryLoader.SummaryProviderFactory() {
        @Override
        public SummaryLoader.SummaryProvider createSummaryProvider(Activity activity,
                                                                   SummaryLoader summaryLoader) {
            return new SummaryProvider(activity, summaryLoader);
        }
    };
}
