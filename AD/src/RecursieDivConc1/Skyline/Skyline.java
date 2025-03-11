import java.util.List;

public interface Skyline {

    /**
     * Bereken de skyline gevormd door een enkel gebouw.
     */
    public List<SkylinePunt> gebouw(Gebouw gebouw);

    /**
     * Bereken de skyline gevormd door een lijst van gebouwen met behulp van
     * een verdeel-en-heersalgoritme. Deze methode maakt gebruik van de
     * gebouw en merge methoden uit deze interface.
     */
    public List<SkylinePunt> skyline(List<Gebouw> gebouwen);

    /**
     * Voeg de twee gegeven skylines samen tot een enkele skyline, door ze
     * visueel te overlappen. De resulterende skyline bevat geen overtollige
     * punten.
     */
    public List<SkylinePunt> merge(List<SkylinePunt> s1, List<SkylinePunt> s2);

}
