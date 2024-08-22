package com.baidu.ttsplugin.google.gson;

import java.lang.reflect.Field;

public enum FieldNamingPolicy implements FieldNamingStrategy {
    IDENTITY {
        public String translateName(Field f2) {
            return f2.getName();
        }
    },
    UPPER_CAMEL_CASE {
        public String translateName(Field f2) {
            return FieldNamingPolicy.upperCaseFirstLetter(f2.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES {
        public String translateName(Field f2) {
            return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(f2.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES {
        public String translateName(Field f2) {
            return FieldNamingPolicy.separateCamelCase(f2.getName(), "_").toLowerCase();
        }
    },
    LOWER_CASE_WITH_DASHES {
        public String translateName(Field f2) {
            return FieldNamingPolicy.separateCamelCase(f2.getName(), "-").toLowerCase();
        }
    };

    /* access modifiers changed from: private */
    public static String separateCamelCase(String name, String separator) {
        StringBuilder translation = new StringBuilder();
        for (int i2 = 0; i2 < name.length(); i2++) {
            char character = name.charAt(i2);
            if (Character.isUpperCase(character) && translation.length() != 0) {
                translation.append(separator);
            }
            translation.append(character);
        }
        return translation.toString();
    }

    /* access modifiers changed from: private */
    public static String upperCaseFirstLetter(String name) {
        StringBuilder fieldNameBuilder = new StringBuilder();
        int index = 0;
        char firstCharacter = name.charAt(0);
        while (index < name.length() - 1 && !Character.isLetter(firstCharacter)) {
            fieldNameBuilder.append(firstCharacter);
            index++;
            firstCharacter = name.charAt(index);
        }
        if (index == name.length()) {
            return fieldNameBuilder.toString();
        }
        if (!Character.isUpperCase(firstCharacter)) {
            return fieldNameBuilder.append(modifyString(Character.toUpperCase(firstCharacter), name, index + 1)).toString();
        }
        return name;
    }

    private static String modifyString(char firstCharacter, String srcString, int indexOfSubstring) {
        if (srcString.length() <= 0 || indexOfSubstring >= srcString.length()) {
            return String.valueOf(firstCharacter);
        }
        return firstCharacter + srcString.substring(indexOfSubstring);
    }
}
