package tool.SoftwareGenerator.DesignGUIs;

import com.intellij.openapi.ui.ComboBox;
import tool.MyToolWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FactoryGUI {
    public static JPanel panel = new JPanel();
    public static JTextField factory_name = new JTextField();
    public static JTextField common_name = new JTextField();

    private static JTextField new_field = new JTextField();
    private static JTextField new_method = new JTextField();
    private static JButton add_field = new JButton("Add field");
    private static JButton add_method = new JButton("Add method");
    private static JButton generate = new JButton("Generate");

    //For creation of compilation unit
    public static ArrayList<String> Factory_fields = new ArrayList<>();
    public static ArrayList<String> Factory_methods = new ArrayList<>();
    public static ArrayList<String> Common_methods = new ArrayList<>();

    //list of classes and interfaces
    private static String[] classesAndInterfaces = new String[] {"factory class", "common interface"};
    private static ComboBox<String> EnhanceList = new ComboBox<>(classesAndInterfaces);
    private static ActionListener[] action = new ActionListener[2];
    private static  ActionListener currentActionListener;

    static{
        // ************ Setting sizes and layouts ***************
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        factory_name.setMaximumSize(new Dimension(600, 200));
        new_field.setMaximumSize(new Dimension(600, 200));
        new_method.setMaximumSize(new Dimension(600, 200));
        common_name.setMaximumSize(new Dimension(600, 200));

        // ************ Getting names of related Classes/Interfaces ***************
        panel.add(new JLabel("Name of the factory class:")).setFont(new Font("Courier New", Font.ITALIC, 14));
        panel.add(factory_name);

        panel.add(new JLabel("Please enter the name of the common interface:")).setFont(new Font("Courier New", Font.ITALIC, 14));
        panel.add(new JLabel("(implemented by objects created by the factory)")).setFont(new Font("Courier New", Font.ITALIC, 14));
        panel.add(common_name);

        //*************************************************************************
        //******************   Adding Fields to Factory   **************************
        //Adding Fields
        panel.add(new JLabel("\nAdd fields to the factory class:")).setFont(new Font("Courier New", Font.ITALIC, 14));
        panel.add(new JLabel("\nClassType FieldName")).setFont(new Font("Courier New", Font.ITALIC, 14));
        panel.add(new_field);
        panel.add(add_field);
        add_field.addActionListener(e -> {
            String field = new_field.getText();
            new_field.setText("");

            if (field.equals("")){
                System.out.println("invalid entry of field");
            }
            else{
                //validate??
                Factory_fields.add(field);
            }
        });

        //*************************************************************************
        //************* Adding Methods To Different Classes/Interfaces ************
        panel.add(new JLabel("\nAdd methods to")).setFont(new Font("Courier New", Font.ITALIC, 14));
        panel.add(EnhanceList);

        action[0] = e -> {
            String method = new_method.getText();
            new_method.setText("");
            if (method.equals("")){
                System.out.println("invalid entry of field");
            }
            else{
                //validate with split??
                Factory_methods.add(method);
            }
        };

        action[1] = e -> {
            String method = new_method.getText();
            new_method.setText("");
            if (method.equals("")){
                System.out.println("invalid entry of field");
            }
            else{
                //validate with split??
                Common_methods.add(method);
            }
        };

        currentActionListener = action[0];

        EnhanceList.addActionListener(e -> {
            switch (EnhanceList.getSelectedItem().toString()){
                case "factory class":
                    add_method.removeActionListener(currentActionListener);
                    add_method.addActionListener((currentActionListener = action[0]));
                    break;
                case "common interface":
                    add_method.removeActionListener(currentActionListener);
                    add_method.addActionListener((currentActionListener = action[1]));
                    break;
                default:
            }
        });

        panel.add(new JLabel("\nReturnType MethodName(Type1 name1, ...)\n")).setFont(new Font("Courier New", Font.ITALIC, 14));
        panel.add(new_method);
        panel.add(add_method);
        add_method.addActionListener(currentActionListener);

        //*************************************************************************
        //**************************   Generate button   **************************
        panel.add(generate);
        generate.addActionListener(e -> {
            //TODO: validate input before calling factory
            MyToolWindow.designFactory.getDesign("Factory");
        });
        //*************************************************************************
    }
}
