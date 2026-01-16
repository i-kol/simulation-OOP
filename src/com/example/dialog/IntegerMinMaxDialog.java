package com.example.dialog;

public class IntegerMinMaxDialog extends AbstractDialog<Integer> {
    private final int min;
    private final int max;

    public IntegerMinMaxDialog(String title, String error, int min, int max) {
        super(title, error);
        this.min = min;
        this.max = max;
    }

    @Override
    protected boolean isTypeValid(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    protected Integer parseInput(String input) {
        return Integer.parseInt(input);
    }

    @Override
    protected boolean isAllowed(Integer result) {
        return result >= min && result <= max;
    }
}
