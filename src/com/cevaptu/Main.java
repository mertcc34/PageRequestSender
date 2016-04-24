package com.cevaptu;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main implements ActionListener,KeyListener {


    JFrame f = new JFrame();
    JTextField text = new JTextField();
    JTextField text2 = new JTextField();
    JLabel l = new JLabel();
    JButton button1 = new JButton("SEND REQUESTS");
    JButton button2 = new JButton("Exit");
    boolean bool = true;

    public Main(){

        f.setVisible(true);
        f.setSize(700,700);
        f.setResizable(false);

        text.setVisible(true);
        text.setBackground(Color.BLACK);
        text.setForeground(Color.green);
        text2.setBackground(Color.BLACK);
        text2.setForeground(Color.green);
        button1.setBackground(Color.orange);
        button2.setBackground(Color.orange);
        button1.setForeground(Color.red);
        button2.setForeground(Color.red);

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(4,1));

        Font f1 = new Font("SansSerif", Font.BOLD, 25);
        text.setFont(f1);
        text2.setFont(f1);
        l.setBackground(Color.BLACK);
        l.setForeground(Color.GREEN);
        l.setFont(f1);

        button1.addActionListener(this);
        button2.addActionListener(this);
        //f.add(l);
        f.add(text);
        f.add(button1);
        text2.setEditable(false);
        f.add(text2);
        f.add(button2);


    }






    public static void main(String[] args) {
        Main m =new Main();



    }



    public void act(String s) {

        int i = 0;
        while(i<113 && bool) {
            
            try {
                String str =s;


                URL url = new URL(str);
                URLConnection mc = url.openConnection();

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                mc.getInputStream()));
               // String inputLine;

                //  while ((inputLine = in.readLine()) != null) {
                //   System.out.println(inputLine);
                //   }
                in.close();
                System.out.println("Request number : " + (i+1));

                text2.setText("Request number : " + (i+1));




            } catch (Exception e) {
                System.out.println(e.getMessage());
                text2.setText(e.getMessage());

            }
            i++;
        }
    }





    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(button1)) {
            bool=true;
            act(text.getText());
        }

        if(e.getSource().equals(button2)) {
            bool=false;
            f.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource().equals(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,1))){
            bool=false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}