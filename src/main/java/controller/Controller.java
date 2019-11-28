package controller;

import model.Model;
import view.View;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import static view.InputMessagesConstants.*;

public class Controller {
    private Model model;
    private View view;
    private Scanner sc = new Scanner(System.in);
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void processUser(){
        inputStringThatFitsRegex(NAME ,Regex.PART_OF_NAME_REGEX);
        inputStringThatFitsRegex(SURNAME ,Regex.PART_OF_NAME_REGEX);
        inputStringThatFitsRegex(PATRONYMIC ,Regex.PART_OF_NAME_REGEX);
        inputStringThatFitsRegex(EMAIL ,Regex.EMAIL_REGEX);
        inputStringThatFitsRegex(NICKNAME, Regex.NICKNAME_REGEX);
        inputStringThatFitsRegex(DATE,Regex.DATE_REGEX);
        inputStringThatFitsRegex(COMMENT, Regex.COMMENT_REGEX);
        inputStringThatFitsRegex(HOME_PHONE_NUMBER, Regex.HOME_PHONE_NUMBER_REGEX);
        inputStringThatFitsRegex(PHONE_NUMBER, Regex.PHONE_NUMBER_REGEX);
       // inputStringThatFitsRegex()
    }

    private String inputStringThatFitsRegex(String message, String regex){
        Locale localeRegex = View.resourceBundle.getLocale();
        ResourceBundle rb = ResourceBundle.getBundle("regex", localeRegex);

        view.printInterMessage(message);
        String partOfName ;
        while(!(partOfName = inputStringWithScanner(sc)).matches(rb.getString(regex))){
            view.printInterIscorrectMessage(INCORRECT_DATA);
        };
        view.printInterIscorrectMessage(CORRECT_DATA);
        return partOfName;
    }

    private String inputStringWithScanner(Scanner sc){
        return sc.next();//.toLowerCase();
    }
}
