package com.example.helloworld;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class SettingViewModel extends ViewModel {
    public static final String superSecretSettingsId = "4bb18199-3d3b-428b-83ec-c69771747301";

    public LiveData<Setting> getSetting(Context context) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        return db.settingsDao().findBySettingsId(SettingViewModel.superSecretSettingsId);
    }

    public void insertSettings(Context context, Setting settings) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        settings.setId(superSecretSettingsId);
        db.getTransactionExecutor().execute(() -> {
            db.settingsDao().insertSettings(settings);
        });
    }
}
