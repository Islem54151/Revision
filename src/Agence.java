import java.util.*;

public class Agence {
    private String nom;
    public ListVoitures vs;
    private Map<Client, ListVoitures> ClientVoitureLoue;
    public Agence(String nom)
    {
        this.nom = nom;
        this.vs = new ListVoitures();
        this.ClientVoitureLoue = new HashMap<>();
    }
    public void ajoutVoiture(Voiture v) throws VoitureException{
        vs.ajoutVoiture(v);
    }
    public void suppVoiture(Voiture v)throws VoitureException{
        vs.supprimeVoiture(v);
        for (ListVoitures lv : ClientVoitureLoue.values()) {
            lv.getVoitures().remove(v);
        }    }
    public void loueClientVoiture(Client cl, Voiture v)throws VoitureException{
        vs.supprimeVoiture(v);
        if (!ClientVoitureLoue.containsKey(cl)) {
            ClientVoitureLoue.put(cl, new ListVoitures());
        }
        ClientVoitureLoue.get(cl).ajoutVoiture(v);    }
    public void retourClientVoiture(Client cl , Voiture v) throws VoitureException{
        if (ClientVoitureLoue.containsKey(cl)) {
            ClientVoitureLoue.get(cl).supprimeVoiture(v);
            vs.ajoutVoiture(v);
        }    }
    public List<Voiture> selectVoitureSelonCritere(Critere c){
        List<Voiture> result = new ArrayList<>();
        for (Voiture v : vs.getVoitures()) {
            if (c.estSatisfaitPar(v)) {
                result.add(v);
            }
        }
        return result;    }
    public Set<Client> ensembleClientsLoueurs(){
        return ClientVoitureLoue.keySet();
    }
    public Collection<ListVoitures> collectionVoituresLouees(){
        return ClientVoitureLoue.values();

    }
    public void afficheLesClientsEtLeursListesVoitures(){
        for (Map.Entry<Client, ListVoitures> entry : ClientVoitureLoue.entrySet()) {
            Client client = entry.getKey();
            ListVoitures listVoitures = entry.getValue();

            System.out.println("Client: " + client.getNom() + " " + client.getPrenom());
            listVoitures.affiche();
            System.out.println();
        }
    }
    public Map<Client, ListVoitures> triCodeCroissant(){
        return new TreeMap<>(ClientVoitureLoue);

    }
    public Map<Client, ListVoitures> triNomCroissant(){
        Map<Client, ListVoitures> sortedMap = new TreeMap<>(
                (c1, c2) -> c1.getNom().compareTo(c2.getNom())
        );
        sortedMap.putAll(ClientVoitureLoue);
        return sortedMap;
    }
}