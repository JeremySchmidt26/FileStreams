import java.util.Objects;

public class Product
{
    public static final int NAME_LENGTH = 35;
    public static final int DESCRIPTION_LENGTH = 75;
    public static final int ID_LENGTH = 6;

    private String name;
    private String description;
    private String ID; // should never change
    private double cost;

    public Product(String name, String description,
                   String ID, double cost)
    {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    public Product(String name, String ID, double cost)
    {
        this(name, "", ID, cost);
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String getID()
    {
        return ID;
    }

    public double getCost()
    {
        return cost;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    // REQUIRED FOR RANDOM ACCESS FILES
    public static String pad(String str, int length)
    {
        StringBuilder sb = new StringBuilder(str);

        while (sb.length() < length)
        {
            sb.append(" ");
        }

        if (sb.length() > length)
        {
            return sb.substring(0, length);
        }

        return sb.toString();
    }

    public String toCSV()
    {
        return name + "," + description + "," + ID + "," + cost;
    }

    public String toJSON()
    {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"description\": \"" + description + "\",\n" +
                "  \"ID\": \"" + ID + "\",\n" +
                "  \"cost\": " + cost + "\n" +
                "}";
    }

    public String toXML()
    {
        return "<Product>\n" +
                "  <Name>" + name + "</Name>\n" +
                "  <Description>" + description + "</Description>\n" +
                "  <ID>" + ID + "</ID>\n" +
                "  <Cost>" + cost + "</Cost>\n" +
                "</Product>";
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ID='" + ID + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (!(o instanceof Product))
        {
            return false;
        }

        Product product = (Product) o;

        return Double.compare(product.cost, cost) == 0
                && Objects.equals(name, product.name)
                && Objects.equals(description, product.description)
                && Objects.equals(ID, product.ID);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, description, ID, cost);
    }
}