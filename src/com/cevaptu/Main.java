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
    JTextField number = new JTextField();
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
       //text.setBackground(Color.BLACK);
       // text.setForeground(Color.green);
        //text2.setBackground(Color.BLACK);
       // text2.setForeground(Color.green);
        button1.setBackground(Color.BLACK);
        button2.setBackground(Color.BLACK);
        button1.setForeground(Color.green);
        button2.setForeground(Color.green);

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(5,1));

        Font f1 = new Font("SansSerif", Font.BOLD, 25);
        text.setFont(f1);
        text2.setFont(f1);
        l.setBackground(Color.BLACK);
        l.setForeground(Color.GREEN);
        l.setFont(f1);

        button1.addActionListener(this);
        button2.addActionListener(this);
        //f.add(l);
        f.add(number);
        f.add(text);
        f.add(button1);
        text2.setEditable(false);
        f.add(text2);
        f.add(button2);


    }






    public static void main(String[] args) {
        new Main();



    }



    public void act(String s) {

        String temp="";

        int i = 0;
        int stop = Integer.parseInt(number.getText());
        while(i<stop && bool) {
            String str =s;


            try {

                URL url = new URL(str);
                URLConnection mc = url.openConnection();

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                mc.getInputStream()));

                in.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
                text2.setText(e.getMessage());
                temp = e.getMessage();
            }
            if(temp.equals("")) {
                text2.setText("Request number : " + (i + 1));
                System.out.println(text2.getText());
            }
            i++;
        }
        if(temp.equals("")) {
            text2.setText(i + " Requests sent to the URL");
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