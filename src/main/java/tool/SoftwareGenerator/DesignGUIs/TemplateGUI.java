package tool.SoftwareGenerator.DesignGUIs;

import tool.MyToolWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TemplateGUI {
    public static JPanel panel = new JPanel();
    public static JTextField template_name = new JTextField();

    private static JTextField new_methodAbstract = new JTextField();
    private static JTextField new_method = new JTextField();
    private static JTextField new_class = new JTextField();
    private static JButton add_methodAbstract = new JButton("Add field");
    private static JButton add_method = new JButton("Add method");
    private static JButton add_class = new JButton("Add class");
    private static JButton generate = new JButton("Generate");

    //For creation of compilation unit
    public static ArrayList<String> classes = new ArrayList<>();
    public static ArrayList<String> methods = new ArrayList<>();
    public static ArrayList<String> methodsAbstract = new ArrayList<>();


    static{
        // ************ Setting sizes and layouts ***************
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        template_name.setMaximumSize(new Dimension(600, 200));
        new_methodAbstract.setMaximumSize(new Dimension(600, 200));
        new_method.setMaximumSize(new Dimension(600, 200));
        new_class.setMaximumSize(new Dimension(600, 200));

        panel.add(new JLabel("Name of the abstract template class:")).setFont(new Font("Courier New", Font.ITALIC, 14));
        panel.add(template_name);


        //Adding Methods
        panel.add(new JLabel("\nAdd methods that the template will use:")).setFont(new Font("Courier New", Font.ITALIC, 14));
        panel.add(new JLabel("\nReturnType MethodName(Type1 name1, ...)\n")).setFont(new Font("Courier New", Font.ITALIC, 14));
        panel.add(new_method);
        panel.add(add_method);
        add_method.addActionListener(e -> {
            String method = new_method.getText();
            new_method.setText("");
            if (method.equals("")){
                System.out.println("invalid entry of field");
            }
            else{
                //validate with split??
                methods.add(method);
            }
        });


        //Adding Methods
        panel.add(new JLabel("\nAdd abstract methods that will need to be implemented:")).setFont(new Font("Courier New", Font.ITALIC, 14));
        panel.add(new JLabel("\nReturnType MethodName(Type1 name1, ...)\n")).setFont(new Font("Courier New", Font.ITALIC, 14));
        panel.add(new_methodAbstract);
        panel.add(add_methodAbstract);
        add_methodAbstract.addActionListener(e -> {
            String method = new_methodAbstract.getText();
            new_methodAbstract.setText("");
            if (method.equals("")){
                System.out.println("invalid entry of field");
            }
            else{
                //validate with split??
                methodsAbstract.add(method);
            }
        });


        //Adding Classes
        panel.add(new JLabel("\nAdd classes that extend the template class:")).setFont(new Font("Courier New", Font.ITALIC, 14));
        panel.add(new_class);
        panel.add(add_class);
        add_class.addActionListener(e -> {
            String Class = new_class.getText();
            new_class.setText("");
            if (Class.equals("")){
                System.out.println("invalid entry of field");
            }
            else{
                //validate with split??
                classes.add(Class);
            }
        });

        //Generate button
        panel.add(generate);
        generate.addActionListener(e -> {
            //validate first!!!
            MyToolWindow.designFactory.getDesign("Template");
        });
    }
}
