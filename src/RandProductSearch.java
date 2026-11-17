import javax.swing.*;
import java.awt.*;
import java.io.RandomAccessFile;

public class RandProductSearch extends JFrame
{
    private JTextField searchField;
    private JTextArea resultsArea;

    public RandProductSearch()
    {
        setTitle("Random Product Search");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildGUI();

        setVisible(true);
    }

    private void buildGUI()
    {
        JPanel topPanel = new JPanel();

        searchField = new JTextField(20);

        JButton searchButton =
                new JButton("Search");

        JButton quitButton =
                new JButton("Quit");

        topPanel.add(
                new JLabel("Product Name"));

        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(quitButton);

        resultsArea = new JTextArea();
        resultsArea.setEditable(false);

        add(topPanel, BorderLayout.NORTH);

        add(new JScrollPane(resultsArea),
                BorderLayout.CENTER);

        searchButton.addActionListener(
                e -> searchProducts());

        quitButton.addActionListener(
                e -> System.exit(0));
    }

    private void searchProducts()
    {
        resultsArea.setText("");

        String searchString =
                searchField.getText()
                        .trim()
                        .toLowerCase();

        try
        {
            RandomAccessFile raf =
                    new RandomAccessFile(
                            "ProductData.dat",
                            "r");

            while(raf.getFilePointer()
                    < raf.length())
            {
                char[] nameChars =
                        new char[35];

                char[] descChars =
                        new char[75];

                char[] idChars =
                        new char[6];

                for(int i=0;i<35;i++)
                {
                    nameChars[i] =
                            raf.readChar();
                }

                for(int i=0;i<75;i++)
                {
                    descChars[i] =
                            raf.readChar();
                }

                for(int i=0;i<6;i++)
                {
                    idChars[i] =
                            raf.readChar();
                }

                double cost =
                        raf.readDouble();

                String name =
                        new String(nameChars).trim();

                String description =
                        new String(descChars).trim();

                String id =
                        new String(idChars).trim();

                if(name.toLowerCase()
                        .contains(searchString))
                {
                    resultsArea.append(
                            "Name: " + name +
                                    "\nDescription: " +
                                    description +
                                    "\nID: " + id +
                                    "\nCost: $" + cost +
                                    "\n--------------------\n");
                }
            }

            raf.close();
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
                RandProductSearch::new);
    }
}