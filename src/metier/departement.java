package metier;

public class departement {

    private int idDep;
    private String nomDep;

    public departement(int idDep)
    {
        this.idDep = idDep;
        this.nomDep = "NULL";
    }

    public departement(int idDep, String nomDep)
    {
        this.idDep = idDep;
        this.nomDep = nomDep;
    }

    public int getId() {return idDep;}
    public String getName() {return nomDep;}

    public void setId(int idDep) {this.idDep = idDep;}
    public void setName(String nomDep) {this.name = nomDep;}

    public String toString()
    {
        return "Departement [id = " + idDep + ", Nom du Departement = " + nomDep + " ]";
    }

}
