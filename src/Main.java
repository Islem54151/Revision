public class Main {
    public static void main(String[] args) {
        Agence agence = new Agence("MaAgence");

        Voiture v1 = new Voiture(1, "marque", 100000);
        Voiture v2 = new Voiture(2, "marque1", 20000);


        Client c1 = new Client(3333, "Nasraoui", "Islem");
        Client c2 = new Client(9999, "Nasri", "Manel");

        try {
            System.out.println("Ajout de voitures à l'agence :");
            agence.ajoutVoiture(v1);
            agence.ajoutVoiture(v2);
        } catch (VoitureException ve) {
            System.err.println("Erreur : " + ve.getMessage());
        }

        try {
            System.out.println("Location d'une voiture par un client :");
            agence.loueClientVoiture(c1, v1);

            System.out.println("Retour de la voiture par le client :");
            agence.retourClientVoiture(c1, v1);
    } catch (VoitureException ve) {
        System.err.println("Erreur : " + ve.getMessage());
    }
        System.out.println("Affichage des clients et de leurs listes de voitures louées :");
        agence.afficheLesClientsEtLeursListesVoitures();
    }
}
