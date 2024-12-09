package metier;

public class professeur {

    private int id;
    private String name;
    private String grade;
    private String nomDep;

    public professeur(int id)
    {
        this.id = id;
        this.name = "NULL";
    }

    public professeur(int id, String name; String name; String grade; String nomDep;)
    {
        this.id = id;
        this.name = name;
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public String getName() {return grade;}
    public String getName() {return nomDep;}

    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setName(String name) {this.grade = grade;}
    public void setName(String name) {this.nomDep = nomDep;}

    public String toString()
    {
        return "Professeur [id = " + id + ", Nom = " + name + ", Grade = " + grade + ", Departement = " + departement +" ]";
    }

}
