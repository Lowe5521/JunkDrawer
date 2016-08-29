package com.jonkoester.junkdrawer;

import android.app.Activity;
import android.widget.TextView;

import java.lang.reflect.Field;

public class AnnotationsUtility {

    public static void modifyAnnotatedTextViews(Object someObject) {
        Field[] fields = someObject.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(CustomAnnotation.class)) {
                ((TextView) ((Activity) someObject).findViewById(field.getAnnotation(CustomAnnotation.class).value())).setText("Modified TextView");
            }
        }
    }
}
