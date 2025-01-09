package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.Misiune;
import org.example.models.Raufacator;
import org.example.models.SuperErou;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ManagerDeSupereroi {
    private static List<SuperErou> supereroi = new ArrayList<>();
    private static List<Raufacator> raufacatori = new ArrayList<>();
    private static List<Misiune> misiuni = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean ruleaza = true;

        while (ruleaza) {
            System.out.println("\n=== Manager de Supereroi ===");
            System.out.println("1. Adauga un supererou");
            System.out.println("2. Afiseaza echipa de supereroi");
            System.out.println("3. Adauga un raufacator");
            System.out.println("4. Afiseaza echipa de raufacatori");
            System.out.println("5. Simuleaza o lupta");
            System.out.println("6. Salveaza echipele");
            System.out.println("7. Incarca echipele");
            System.out.println("8. Adauga o misiune");
            System.out.println("9. Afiseaza misiunile");
            System.out.println("10. Supererou finalizeaza misiune");
            System.out.println("11. Cauta supererou");
            System.out.println("12. Sterge supererou");
            System.out.println("13. Sterge raufacator");
            System.out.println("14. Iesire");

            System.out.print("Alege o optiune: ");

            int optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1 -> adaugaSupererou();
                case 2 -> afiseazaSupereroi();
                case 3 -> adaugaRaufacator();
                case 4 -> afiseazaRaufacatori();
                case 5 -> simuleazaLupta();
                case 6 -> salveazaEchipe();
                case 7 -> incarcaEchipe();
                case 8 -> adaugaMisiune();
                case 9 -> afiseazaMisiuni();
                case 10 -> finalizeazaMisiune();
                case 11 -> cautaSupererou();
                case 12 -> stergeSupererou();
                case 13 -> stergeRaufacator();
                case 14 -> {
                    System.out.println("La revedere!");
                    ruleaza = false;
                }
                default -> System.out.println("Optiune invalida. Incearca din nou.");
            }
        }
    }

    private static void stergeSupererou() {
        System.out.print("Introdu numele supereroului pe care doresti sa-l stergi: ");
        String nume = scanner.nextLine();

        boolean sters = supereroi.removeIf(supererou -> supererou.getNume().equalsIgnoreCase(nume));
        if (sters) {
            System.out.println("Supereroul " + nume + " a fost sters.");
        } else {
            System.out.println("Supereroul " + nume + " nu a fost gasit.");
        }
    }

    private static void stergeRaufacator() {
        System.out.print("Introdu numele raufacatorului pe care doresti sa-l stergi: ");
        String nume = scanner.nextLine();

        boolean sters = raufacatori.removeIf(raufacator -> raufacator.getNume().equalsIgnoreCase(nume));
        if (sters) {
            System.out.println("Raufacatorul " + nume + " a fost sters.");
        } else {
            System.out.println("Raufacatorul " + nume + " nu a fost gasit.");
        }
    }

    private static void cautaSupererou() {
        System.out.print("Introdu numele supereroului: ");
        String nume = scanner.nextLine();
        boolean gasit = false;

        for (SuperErou supererou : supereroi) {
            if (supererou.getNume().equalsIgnoreCase(nume)) {
                System.out.println("Supererou gasit: ");
                supererou.prezentare();
                gasit = true;
                break;
            }
        }

        if (!gasit) {
            System.out.println("Supereroul nu a fost gasit.");
        }
    }

    private static void adaugaMisiune() {
        System.out.print("Nume misiune: ");
        String nume = scanner.nextLine();
        System.out.print("Dificultate (1-100): ");
        int dificultate = scanner.nextInt();
        System.out.print("Recompensa: ");
        int recompensa = scanner.nextInt();
        scanner.nextLine();

        Misiune misiune = new Misiune(nume, dificultate, recompensa);
        misiuni.add(misiune);
        System.out.println("Misiune adaugata cu succes!");
    }

    private static void afiseazaMisiuni() {
        if (misiuni.isEmpty()) {
            System.out.println("Nu există misiuni disponibile.");
        } else {
            System.out.println("\n=== Lista Misiunilor ===");
            for (Misiune misiune : misiuni) {
                misiune.prezentare();
                System.out.println();
            }
        }
    }

    private static void finalizeazaMisiune() {
        if (supereroi.isEmpty()) {
            System.out.println("Nu exista supereroi disponibili pentru a finaliza misiuni.");
            return;
        }
        if (misiuni.isEmpty()) {
            System.out.println("Nu exista misiuni disponibile.");
            return;
        }

        System.out.println("Selecteaza un supererou:");
        for (int i = 0; i < supereroi.size(); i++) {
            System.out.println((i + 1) + ". " + supereroi.get(i).getNume());
        }
        int indexErou = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indexErou < 0 || indexErou >= supereroi.size()) {
            System.out.println("Supererou invalid.");
            return;
        }

        System.out.println("Selecteaza o misiune:");
        for (int i = 0; i < misiuni.size(); i++) {
            System.out.println((i + 1) + ". " + misiuni.get(i).getNume());
        }
        int indexMisiune = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indexMisiune < 0 || indexMisiune >= misiuni.size()) {
            System.out.println("Misiune invalida.");
            return;
        }

        SuperErou erou = supereroi.get(indexErou);
        Misiune misiune = misiuni.get(indexMisiune);

        misiune.finalizeazaMisiune(erou);
    }


    private static void adaugaSupererou() {
        System.out.print("Nume supererou: ");
        String nume = scanner.nextLine();
        System.out.print("Putere (1-100): ");
        int putere = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Slabiciune: ");
        int slabiciune = scanner.nextInt();

        SuperErou supererou = new SuperErou(nume, putere, slabiciune);
        supereroi.add(supererou);
        System.out.println("Supererou adaugat cu succes!");
    }

    private static void afiseazaSupereroi() {
        if (supereroi.isEmpty()) {
            System.out.println("Nu exista supereroi in echipa.");
        } else {
            System.out.println("\n=== Echipa de Supereroi ===");
            for (SuperErou supererou : supereroi) {
                supererou.prezentare();
            }
        }
    }

    private static void adaugaRaufacator() {
        System.out.print("Nume raufacator: ");
        String nume = scanner.nextLine();
        System.out.print("Putere (1-100): ");
        int putere = scanner.nextInt();
        scanner.nextLine();

        Raufacator raufacator = new Raufacator(nume, putere);
        raufacatori.add(raufacator);
        System.out.println("Raufacator adaugat cu succes!");
    }

    private static void afiseazaRaufacatori() {
        if (raufacatori.isEmpty()) {
            System.out.println("Nu exista raufacatori in echipa.");
        } else {
            System.out.println("\n=== Echipa de Raufacatori ===");
            for (Raufacator raufacator : raufacatori) {
                raufacator.prezentare();
            }
        }
    }

    private static void simuleazaLupta() {
        if (supereroi.isEmpty() || raufacatori.isEmpty()) {
            System.out.println("Ai nevoie de cel putin un supererou si un raufacator pentru a simula o lupta.");
            return;
        }

        Random random = new Random();

        SuperErou erou = supereroi.get(random.nextInt(supereroi.size()));
        Raufacator raufacator = raufacatori.get(random.nextInt(raufacatori.size()));

        System.out.println("\n=== Lupta ===");
        erou.ataca();
        raufacator.seApara();

        if(erou.getSlabiciune()==raufacator.getPutere()) {
            System.out.println(raufacator.getNume() + " a castigat lupta impotriva " + erou.getNume() + "!");
            return;
        }

        if (erou.getPutere() > raufacator.getPutere()) {
            System.out.println(erou.getNume() + " a castigat lupta impotriva " + raufacator.getNume() + "!");
        } else if (erou.getPutere() < raufacator.getPutere()) {
            System.out.println(raufacator.getNume() + " a castigat lupta impotriva " + erou.getNume() + "!");
        } else {
            System.out.println("Lupta s-a terminat egal!");
        }
    }

    private static void salveazaEchipe() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("supereroi.json"), supereroi);
            mapper.writeValue(new File("raufacatori.json"), raufacatori);
            mapper.writeValue(new File("misiuni.json"), misiuni);
            System.out.println("Echipele si misiunile au fost salvate cu succes in format JSON!");
        } catch (IOException e) {
            System.out.println("Eroare la salvarea echipelor sau misiunilor: " + e.getMessage());
        }
    }

    private static void incarcaEchipe() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            supereroi = mapper.readValue(new File("supereroi.json"), new TypeReference<List<SuperErou>>() {});
            raufacatori = mapper.readValue(new File("raufacatori.json"), new TypeReference<List<Raufacator>>() {});
            misiuni = mapper.readValue(new File("misiuni.json"), new TypeReference<List<Misiune>>() {});
            System.out.println("Echipele si misiunile au fost incarcate cu succes din format JSON!");
        } catch (IOException e) {
            System.out.println("Eroare la incarcarea echipelor sau misiunilor: " + e.getMessage());
        }
    }
}
