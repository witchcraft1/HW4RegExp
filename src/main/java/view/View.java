package view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    static Locale locale = new Locale("ua", "UA");
    public static final ResourceBundle resourceBundle =
            ResourceBundle.getBundle("messages");

    public void printMessage(String major_msg){
        System.out.println(major_msg);
    }

    public void printInterMessage(String message){
        printMessage(resourceBundle.getString(InputMessagesConstants.MESSAGE) +
                resourceBundle.getString(message));
    }
    public void printInterIscorrectMessage(String message){
        printMessage(resourceBundle.getString(message));
    }
}

