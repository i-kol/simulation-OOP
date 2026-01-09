package com.example.factories;

import com.example.view.dialog.Dialog;
import com.example.view.dialog.IntegerMinMaxDialog;

public class WorldMapFactory {
    Dialog<Integer> integerDialog = new IntegerMinMaxDialog(
            "Enter a number between 5 and 50",
            "Invalid number entered!",
            5,
            50);

    int row = integerDialog.input();
    int column = integerDialog.input();
}
