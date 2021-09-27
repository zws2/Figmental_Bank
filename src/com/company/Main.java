package com.company;

//Collaborators: Zach Snyder, James Benton, Eileen Lowers
public class Main {
    public static void main(String[] args) {

        int option = 0;
        Display display = new Display();
//        UserAccess userAccess = new UserAccess();

        Display.printHeader();
        Display.printMainMenu();
        display.getInput();

    }

}
