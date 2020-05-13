import javax.swing.*;
import javax.swing.border.Border;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GUI implements ActionListener {
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    Random random = new Random();
    public static ArrayList<Movie> choices = new ArrayList<>();
    private JLabel label = new JLabel();
    private static JFrame frame;
    static int count=0;

    public static void display() {
        frame = new JFrame();
        JLabel l1 = new JLabel();
        JLabel l2 = new JLabel();
        JLabel l3 = new JLabel();
        JLabel l4 = new JLabel();
        JLabel l5 = new JLabel();
        JLabel l6 = new JLabel("Enjoy Movie Night! :)");

        Matrix.numericalAnalysis(choices);
        Matrix.textualAnalysis(choices);
        Matrix.findIndex();
        Collections.sort(Matrix.dataset, Movie::compareTo);

        l1.setText(Matrix.dataset.get(0).getTitle());
        l2.setText(Matrix.dataset.get(1).getTitle());
        l3.setText(Matrix.dataset.get(2).getTitle());
        l4.setText(Matrix.dataset.get(3).getTitle());
        l5.setText(Matrix.dataset.get(4).getTitle());
        Border border = BorderFactory.createLineBorder(Color.RED, 3);
        l1.setBorder(border);
        l2.setBorder(border);
        l3.setBorder(border);
        l4.setBorder(border);
        l5.setBorder(border);
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        panel.add(l5);
        panel.add(l6);
        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("RECOMMENDED MOVIES");
        frame.pack();
        frame.setVisible(true);
    }

    public GUI() {
        frame = new JFrame();
        Movie m1 = Matrix.dataset.get(random.nextInt(Matrix.dataset.size()));
        Movie m2 = Matrix.dataset.get(random.nextInt(Matrix.dataset.size()));
        Movie m3 = Matrix.dataset.get(random.nextInt(Matrix.dataset.size()));

        // the clickable button
        button1 = new JButton(m1.getTitle());
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(count < 2) {
                    count++;
                    choices.add(m1);
                    new GUI();
                } else {
                    choices.add(m1);
                    display();
                }
            }
        });
        button2 = new JButton(m2.getTitle());
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(count < 2) {
                    count++;
                    choices.add(m2);
                    new GUI();
                } else {
                    choices.add(m2);
                    display();
                }
            }
        });
        button3 = new JButton(m3.getTitle());
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(count < 2) {
                    count++;
                    choices.add(m3);
                    new GUI();
                } else {
                    choices.add(m3);
                    display();
                }
            }
        });
        button4 = new JButton("None Of The Above");
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GUI();
            }
        });

        // the panel with the button and text
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        label.setText("Choose Your Favorite Movie!");
        panel.add(label);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);
    }


    // process the button clicks
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }

    // create one Frame
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        Matrix.populateDataSet();
        Matrix.numericalNormalize();
        new GUI();
    }
}
