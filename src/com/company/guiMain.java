package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiMain {

    private static JFrame frame;
    private static JPanel panel;
    private static JLabel nameLabel,natLabel,dateLabel,sexLabel;
    private static JRadioButton maleRadio,femaleRadio;
    private static JButton submitBtn,resetBtn;
    private static JTextField nameField,natField,dateField,sexField;
    private static String gender_msg;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGui();
            }
        });

    }
    public static void createAndShowGui(){

        frame = new JFrame();
        frame.setTitle("Fill Form Application");
        frame.setSize(700, 700);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500, 500));

        panel = new JPanel();
        //why??
        panel.setLayout(null);
        frame.add(panel);

        nameLabel = new JLabel();
        nameLabel.setForeground(Color.MAGENTA);
        nameLabel.setFont(new Font("Times",Font.BOLD,15));
        nameLabel.setText("Name : ");
        nameLabel.setBounds(10,0,200,30);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(220,10,200,30);
        nameField.setToolTipText("enter name");
        panel.add(nameField);

        natLabel = new JLabel();
        natLabel.setForeground(Color.MAGENTA);
        natLabel.setText("Nationality :");
        natLabel.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        natLabel.setBounds(10,50,200,40);
        panel.add(natLabel);

        natField = new JTextField();
        natField.setBounds(220,60,200,30);
        natField.setToolTipText("enter nationality");
        panel.add(natField);

        dateLabel = new JLabel();
        dateLabel.setText("DOB");
        dateLabel.setForeground(Color.MAGENTA);
        dateLabel.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        dateLabel.setBounds(10,100,200,40);
        panel.add(dateLabel);

        dateField = new JTextField();
        dateField.setBounds(220,110,200,30);
        dateField.setToolTipText("enter DOB");
        panel.add(dateField);

        sexLabel = new JLabel("Gender");
        sexLabel.setForeground(Color.MAGENTA);
        sexLabel.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        sexLabel.setBounds(10,150,200,30);
        panel.add(sexLabel);

        maleRadio = new JRadioButton("Male",false);
        maleRadio.setBounds(220,150,100,30);
        panel.add(maleRadio);

        femaleRadio = new JRadioButton("Female",false);
        femaleRadio.setBounds(330,150,100,30);
        panel.add(femaleRadio);

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(maleRadio);
        btnGroup.add(femaleRadio);

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(90,200,100,30);
        panel.add(submitBtn);

        //add function on Btn
        submitBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("Hello Event");
                if(maleRadio.isSelected()){
                    gender_msg = "male";
                } else if(femaleRadio.isSelected()) {
                    gender_msg = "female";
                }

                String msg = String.format("Name : %s\nNationality : %s\nDate : %s\nGender : %s", nameField.getText(),natField.getText(),dateField.getText(),gender_msg);
                JOptionPane.showMessageDialog(frame,msg,"Popup Name",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        resetBtn = new JButton("Reset");
        resetBtn.setBounds(130,200,100,30);


        frame.pack();
    }
}
