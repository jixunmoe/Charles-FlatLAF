package uk.jixun.charles.theme;

import com.formdev.flatlaf.FlatLightLaf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static javax.swing.JOptionPane.showMessageDialog;

public class Main {
    public static void main(String[] args) {
        FlatLightLaf.setup();

        try {
            Class<?> MainWithClassLoader = Class.forName("com.xk72.charles.gui.MainWithClassLoader");
            Method nextMain = MainWithClassLoader.getMethod("main", String[].class);
            nextMain.invoke(null, new Object[]{args});
        } catch (IllegalArgumentException ex) {
            showMessageDialog(null, ex.getMessage());
        } catch (InvocationTargetException ex) {
            showMessageDialog(null, ex.getCause().toString() + "\n" + ex.getCause().getMessage());
        } catch (Exception ex) {
            showMessageDialog(null, ex + "\n" + ex.getMessage());
        }
    }
}
