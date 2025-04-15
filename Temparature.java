import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Temparature extends JFrame implements ActionListener {
    JLabel lbl, l1, l2;
    JTextField tempBox1, tempBox2, result_c_f, result_f_c;
    JButton c_f, f_c, d_w;
    Image icon = Toolkit.getDefaultToolkit()
            .getImage("icon.png");

    Temparature() {
        super("Temparature Converter");

        l1 = new JLabel("Celsius to Fahrenheit:", JLabel.CENTER);
        l2 = new JLabel("Fahrenheit to Celsius", JLabel.CENTER);
        tempBox1 = new JTextField();
        tempBox2 = new JTextField();
        result_c_f = new JTextField();
        result_f_c = new JTextField();

        result_c_f.setEditable(false);
        result_f_c.setEditable(false);

        c_f = new JButton("Convert to Fahrenheit");
        f_c = new JButton("Convert to Celsius");
        d_w = new JButton("Dark Mode");
        c_f.addActionListener(this);
        f_c.addActionListener(this);
        d_w.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(icon);
        setLayout(new GridLayout(5, 3));
        setVisible(true);
        setSize(361, 280);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);

        getContentPane().setBackground(Color.WHITE);
        l1.setForeground(Color.BLACK);
        l2.setForeground(Color.BLACK);
        tempBox1.setForeground(Color.BLACK);
        tempBox2.setForeground(Color.BLACK);
        result_c_f.setForeground(Color.BLACK);
        result_f_c.setForeground(Color.BLACK);
        c_f.setForeground(Color.BLACK);
        f_c.setForeground(Color.BLACK);

        tempBox1.setBackground(Color.WHITE);
        tempBox2.setBackground(Color.WHITE);
        result_c_f.setBackground(Color.WHITE);
        result_f_c.setBackground(Color.WHITE);
        c_f.setBackground(new Color(234, 234, 234));
        f_c.setBackground(new Color(234, 234, 234));

        add(l1);
        add(tempBox1);
        add(c_f);
        add(result_c_f);
        add(l2);
        add(tempBox2);
        add(f_c);
        add(result_f_c);
        add(d_w);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Convert to Fahrenheit") {
            try {
                double celsius = 0, res_c_f = 0;

                celsius = Double.parseDouble(tempBox1.getText());
                res_c_f = celsius * 9 / 5 + 32;

                result_c_f.setText(res_c_f + "°F");

            } catch (NumberFormatException e1) {
                String output = "Error: " + e1
                        + " \nTry this steps:\n1) Check wheather all input are filled\n2) Check if you typed string if yes then change to number";
                JOptionPane.showMessageDialog(null, output);
            }
        } else if (e.getActionCommand() == "Convert to Celsius") {
            try {
                double farenheit = 0, res_f_c = 0;

                farenheit = Double.parseDouble(tempBox2.getText());
                res_f_c = ((farenheit - 32) * (5.0 / 9.0));
                result_f_c.setText(res_f_c + "°C");

            } catch (NumberFormatException e1) {
                String output = "Error: " + e1
                        + " \nTry this steps:\n1) Check wheather all input are filled\n2) Check if you typed string if yes then change to number";
                JOptionPane.showMessageDialog(null, output);
            }
        }

        if (e.getActionCommand() == "Dark Mode") {
            getContentPane().setBackground(new Color(18, 18, 18));
            l1.setForeground(Color.WHITE);
            l2.setForeground(Color.WHITE);
            tempBox1.setForeground(Color.WHITE);
            tempBox2.setForeground(Color.WHITE);
            result_c_f.setForeground(Color.WHITE);
            result_f_c.setForeground(Color.WHITE);
            c_f.setForeground(Color.WHITE);
            f_c.setForeground(Color.WHITE);

            tempBox1.setBackground(new Color(18, 18, 18));
            tempBox2.setBackground(new Color(18, 18, 18));
            result_c_f.setBackground(new Color(18, 18, 18));
            result_f_c.setBackground(new Color(18, 18, 18));
            c_f.setBackground(new Color(63, 63, 63));
            f_c.setBackground(new Color(63, 63, 63));
            d_w.setText("Light Mode");

        } else if (e.getActionCommand() == "Light Mode") {
            getContentPane().setBackground(Color.WHITE);
            l1.setForeground(Color.BLACK);
            l2.setForeground(Color.BLACK);
            tempBox1.setForeground(Color.BLACK);
            tempBox2.setForeground(Color.BLACK);
            result_c_f.setForeground(Color.BLACK);
            result_f_c.setForeground(Color.BLACK);
            c_f.setForeground(Color.BLACK);
            f_c.setForeground(Color.BLACK);

            tempBox1.setBackground(Color.WHITE);
            tempBox2.setBackground(Color.WHITE);
            result_c_f.setBackground(Color.WHITE);
            result_f_c.setBackground(Color.WHITE);
            c_f.setBackground(new Color(234, 234, 234));
            f_c.setBackground(Color.WHITE);
            d_w.setText("Dark Mode");

        }
    }

    public static void main(String[] args) {
        new Temparature();
    }
}
