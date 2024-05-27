package com.example.pocketpal;
import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExpenseFileUtils {

    public static List<Expense> getExpensesFromFile(Context context) {
        List<Expense> expenses = new ArrayList<>();
        try {
            File file = new File(context.getFilesDir(), "expenses.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            expenses = (List<Expense>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    public static void saveExpensesToFile(Context context, List<Expense> expenses) {
        try {
            File file = new File(context.getFilesDir(), "expenses.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(expenses);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}