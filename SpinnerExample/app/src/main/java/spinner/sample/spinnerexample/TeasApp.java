package spinner.sample.spinnerexample;

import android.app.Application;
import android.widget.Toast;

/**
 * Created by praveen on 18/8/16.
 */

public class TeasApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        String app = getString(R.string.app_name);

        Toast.makeText(this, "show"+app, Toast.LENGTH_LONG).show();
    }
}


