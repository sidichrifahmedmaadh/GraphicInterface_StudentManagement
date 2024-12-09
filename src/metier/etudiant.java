package metier;

public class etudiant {

    private int id;
    private String name;

    public etudiant(int id)
    {
        this.id = id;
        this.name = "NULL";
    }

    public etudiant(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId() {return id;}
    public String getName() {return name;}

    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}

    public String toString()
    {
        return "Etudiane [id = " + id + ", name = " + name + " ]";
    }

}
