package org.robospock.dagger2unittests;

import android.content.Context;
import android.widget.Toast;

public class Toaster {

    Context context;

    public Toaster(Context context) {
        this.context = context;
    }

    public void makeToast(boolean burned) {
        Toast.makeText(context, burned ? "Burned" : "Juicy", Toast.LENGTH_SHORT).show();
    }
}
