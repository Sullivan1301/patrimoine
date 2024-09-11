package school.hei.patrimoine.modele.possession;

import static school.hei.patrimoine.modele.possession.TypeAgregat.IMMOBILISATION;

import java.time.LocalDate;
import java.util.Set;
import school.hei.patrimoine.modele.Argent;

public final class AchatMaterielAuComptant extends Possession {

  private final GroupePossession achatCommeGroupe;

  public AchatMaterielAuComptant(
      String nom,
      LocalDate dateAchat,
      Argent valeurComptableALAchat,
      double tauxAppreciationAnnuelle,
      Compte financeur) {
    super(nom, dateAchat, valeurComptableALAchat);
    this.achatCommeGroupe =
        new GroupePossession(
            nom,
            dateAchat,
            Set.of(
                new Materiel(
                    nom, dateAchat, valeurComptableALAchat, dateAchat, tauxAppreciationAnnuelle),
                new FluxArgent(
                    "Financement AchatMaterielAuComptant: " + nom,
                    financeur,
                    dateAchat,
                    dateAchat,
                    valeurComptableALAchat.mult(-1),
                    dateAchat.getDayOfMonth())),
            valeurComptable.devise());
  }

  @Override
  public Possession projectionFuture(LocalDate tFutur) {
    return achatCommeGroupe.projectionFuture(tFutur);
  }

  @Override
  public TypeAgregat typeAgregat() {
    return IMMOBILISATION;
  }
}
