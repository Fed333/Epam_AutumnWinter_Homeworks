package com.epam.studying.view;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.epam.studying.view.TextConstants.*;

public class View {
    private static final String INPUT_DATA_FORMAT = "%s %s: ";
    private static final String MESSAGES_BUNDLE_NAME = "messages";

    public static final ResourceBundle bundle = ResourceBundle.getBundle(
            MESSAGES_BUNDLE_NAME,
            new Locale("en", "EN")
    );

    /**
     * @param message expected to take already localized value*/
    public void printMessage(String message){
        System.out.println(message);
    }


    public String concatStrings(String... strings){
        StringBuilder sb = new StringBuilder();
        for (String string:strings) {
            sb.append(string);
        }
        return sb.toString();
    }

    public void printStringInput(String message){
        printMessage(askInput(message));
    }

    private String askInput(String message){
        return String.format(
                INPUT_DATA_FORMAT,
                bundle.getString(TextConstants.INPUT_STRING_DATA),
                bundle.getString(message)
                );
    }

    /**
     * @param string expected to take already localized value*/
    public void printWarningMessage(String string) {
        printMessage(concatStrings(
                bundle.getString(WRONG_INPUT_DATA),
                string
        ));
    }

    public String wrongNameWarning(String name){
        return String.format(bundle.getString(WRONG_INPUT_FIRST_NAME_FORMAT), name);
    }
    public String wrongNickNameWarning(String nickname){
        return String.format(bundle.getString(WRONG_INPUT_NICKNAME_FORMAT), nickname);
    }
}
