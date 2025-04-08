
package school.hei.patrimoine.cas;

import school.hei.patrimoine.cas.pro3.BakoCas;
import school.hei.patrimoine.modele.Argent;
import school.hei.patrimoine.modele.Devise;

import java.util.Set;
import java.util.function.Supplier;

public class CasSetSupplier implements Supplier<CasSet> {
  @Override
  public CasSet get() {
    Argent deviseAsArgent = new Argent(0, Devise.MGA);
    return new CasSet(Set.of(new BakoCas()), deviseAsArgent);
  }
}