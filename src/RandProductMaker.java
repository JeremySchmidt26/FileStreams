import javax.swing.*;
import java.awt.*;
import java.io.RandomAccessFile;

public class RandProductMaker extends JFrame
{
    private JTextField nameField;
    private JTextField descriptionField;
    private JTextField idField;
    private JTextField costField;
    private JTextField countField;

    private int recordCount = 0;

    public RandProductMaker()
    {
        setTitle("Random Product Maker");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildGUI();
        setVisible(true);
    }

    private void buildGUI()
    {
        JPanel panel = new JPanel(new GridLayout(6,2));

        panel.add(new JLabel("Name"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Description"));
        descriptionField = new JTextField();
        panel.add(descriptionField);

        panel.add(new JLabel("ID"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Cost"));
        costField = new JTextField();
        panel.add(costField);

        panel.add(new JLabel("Record Count"));
        countField = new JTextField("0");
        countField.setEditable(false);
        panel.add(countField);

        JButton addButton = new JButton("Add");
        JButton quitButton = new JButton("Quit");

        panel.add(addButton);
        panel.add(quitButton);

        add(panel);

        addButton.addActionListener(e -> addRecord());

        quitButton.addActionListener(
                e -> System.exit(0));
    }

    private void addRecord()
    {
        try
        {
            String name = nameField.getText().trim();
            String description =
                    descriptionField.getText().trim();
            String id = idField.getText().trim();

            double cost =
                    Double.parseDouble(
                            costField.getText());

            if(name.isEmpty() ||
                    description.isEmpty() ||
                    id.isEmpty())
            {
                JOptionPane.showMessageDialog(
                        this,
                        "All fields are required");
                return;
            }

            Product p =
                    new Product(name,
                            description,
                            id,
                            cost);

            RandomAccessFile raf =
                    new RandomAccessFile(
                            "ProductData.dat",
                            "rw");

            raf.seek(raf.length());

            raf.writeChars(
                    Product.pad(name,35));

            raf.writeChars(
                    Product.pad(description,75));

            raf.writeChars(
                    Product.pad(id,6));

            raf.writeDouble(cost);

            raf.close();

            recordCount++;

            countField.setText(
                    String.valueOf(recordCount));

            nameField.setText("");
            descriptionField.setText("");
            idField.setText("");
            costField.setText("");

            JOptionPane.showMessageDialog(
                    this,
                    "Record Saved");
        }

        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage());
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(
                RandProductMaker::new);
    }
}