package com.example.dialog;

import java.util.Scanner;

public abstract class AbstractDialog<T> implements Dialog<T> {
    private final String title;
    private final String error;
    private final Scanner scanner = new Scanner(System.in);

    protected AbstractDialog(String title, String error) {
        this.title = title;
        this.error = error;
    }

    private void showTitle() {
        System.out.println(title);
    }

    private void showError() {
        System.out.println(error);
    }

    public T input() {
        while (true) {
            showTitle();
            String input = scanner.nextLine();

            if (isTypeValid(input)) {
                T result = parseInput(input);
                if (isAllowed(result)) {
                    return result;
                }
            }
            showError();
        }
    }

    abstract protected boolean isTypeValid(String input);

    abstract protected T parseInput(String input);

    abstract protected boolean isAllowed(T result);
}
