import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Temparature extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextField tempBox1, tempBox2, result_c_f, result_f_c;
    JButton c_f, f_c;
    JFrame f = new JFrame();
    Image icon = Toolkit.getDefaultToolkit()
            .getImage("icon.png");

    Temparature() {
        super("Temparature Converter");

        l1 = new JLabel("Celcius to Fahrenheit");
        l2 = new JLabel("Fahrenheit to Celsius");
        tempBox1 = new JTextField(10);
        tempBox2 = new JTextField(10);
        result_c_f = new JTextField(15);
        result_f_c = new JTextField(15);

        result_c_f.setEditable(false);
        result_f_c.setEditable(false);

        c_f = new JButton("Convert to Fahrenheit");
        f_c = new JButton("Convert to Celsius");
        c_f.addActionListener(this);
        f_c.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(icon);
        setLayout(new GridLayout(5, 5));
        setVisible(true);
        setSize(361, 280);
        setResizable(false);

        add(l1);
        add(tempBox1);
        add(c_f);
        add(result_c_f);
        add(l2);
        add(tempBox2);
        add(f_c);
        add(result_f_c);
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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Temparature::new);
    }
}
