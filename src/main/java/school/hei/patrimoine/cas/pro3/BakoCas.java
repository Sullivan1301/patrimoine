package school.hei.patrimoine.cas.pro3;


import school.hei.patrimoine.cas.Cas;
import school.hei.patrimoine.modele.Devise;
import school.hei.patrimoine.modele.Personne;
import school.hei.patrimoine.modele.possession.Compte;
import school.hei.patrimoine.modele.possession.FluxArgent;
import school.hei.patrimoine.modele.possession.Materiel;
import school.hei.patrimoine.modele.possession.Possession;

import java.util.Set;
import java.time.LocalDate;

import static java.time.Month.APRIL;
import static java.time.Month.DECEMBER;
import static school.hei.patrimoine.modele.Argent.ariary;
import static school.hei.patrimoine.modele.Devise.MGA;

public class BakoCas extends Cas {
    private final Compte bni;
    private final Compte bmoi;
    private final Compte coffreFort;

        public BakoCas() {
        super(LocalDate.of(2025, DECEMBER, 31), LocalDate.MAX, new Personne("Bako"));
        bni = new Compte("BNI - Compte courant", LocalDate.MIN, ariary(2_000_000));
        bmoi = new Compte("BMOI - Épargne", LocalDate.MIN, ariary(625_000));
        coffreFort = new Compte("Coffre à la maison", LocalDate.MIN, ariary(1_750_000));

    }

    @Override
    protected Devise devise() {
        return MGA;
    }

    @Override
    protected String nom() {
        return "Cas de Bako ";
    }

    @Override
    protected void init() {

    }

    @Override
    protected void suivi() {

    }

    @Override
    public Set<Possession> possessions() {
        var ajd = LocalDate.of(2025, APRIL, 8);

var salaire = new FluxArgent(
                "Salaire mensuel",
                bni,
                LocalDate.of(2025, APRIL, 2),
                LocalDate.of(2025, DECEMBER, 2),
                9,
                ariary(2_125_000));

var virementSortant = new FluxArgent(
                "Virement sortant vers BMOI",
                bni,
                LocalDate.of(2025, APRIL, 3),
                LocalDate.of(2025, DECEMBER, 3),
                9,
                ariary(-200_000));

var virementEntrant = new FluxArgent(
                "Virement reçu depuis BNI",
                bmoi,
                LocalDate.of(2025, APRIL, 3),
                LocalDate.of(2025, DECEMBER, 3),
                9,
                ariary(200_000));

var loyer = new FluxArgent(
                "Loyer colocation",
                bni,
                LocalDate.of(2025, APRIL, 26),
                LocalDate.of(2025, DECEMBER, 26),
                9,
                ariary(-600_000));

var depensesVie = new FluxArgent(
                "Dépenses de vie",
                bni,
                LocalDate.of(2025, APRIL, 1),
                LocalDate.of(2025, DECEMBER, 1),
                9,
                ariary(-700_000));

        var ordinateur = new Materiel(
                "Ordinateur portable",
                ajd,
                ajd,
                ariary(3_000_000),
                -0.12);

        return Set.of(
                bni, bmoi, coffreFort,
                salaire, virementSortant, virementEntrant,
                loyer, depensesVie,
                ordinateur
        );
    }
}
