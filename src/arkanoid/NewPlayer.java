package arkanoid;

import atariCore.Helper;
import atariCore.Sound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPlayer extends JFrame {
    String namePlayer;
    JButton OK;
    JTextField textName;

    public NewPlayer()
    {
        initFrame();
    }
    private void initFrame() {

        setTitle("Enter Your Name");
        setSize(Helper.screenWidth , Helper.screenHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font =new Font("src/Resources/Fonts/3270Medium.ttf",Font.BOLD,100);

        OK = Helper.btnHelper("OK");

        textName = new JTextField(20);
        textName.setFont(font);
        textName.setHorizontalAlignment(JTextField.CENTER);
        textName.setForeground(Color.YELLOW);
        setLayout(new GridLayout(0,1));
        setResizable(false);
        setLocationRelativeTo(null);
        add(textName);
        add(OK);
        setVisible(true);

        OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textName.getText().length()>0 && textName.getText().length()<=20)
                {

                    arkHelper.running = true;
                    Sound.stop(Sounds.backgroundSplashSound);
                    Sound.loop(1000,Sounds.BackgroundGameSound);
                    new Arkanoid(textName.getText());
                    dispose();
                }

            }
        });
    }




}
