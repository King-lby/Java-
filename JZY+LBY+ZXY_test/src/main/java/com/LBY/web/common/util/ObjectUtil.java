package com.LBY.web.common.util;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;

public class ObjectUtil {

    public static Object convert(Class<?> targetType, String s) {
        PropertyEditor editor = PropertyEditorManager.findEditor(targetType);
        editor.setAsText(s);
        return editor.getValue();
    }
}
