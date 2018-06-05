package io.oasp.gastronomy.restaurant.offermanagement.common.api;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.OfferEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.WeeklyPeriodEmbeddable;

/**
 * @author KMASLOWS
 *
 */
public interface Special {

  public String getName();

  public void setName(String name);

  public OfferEntity getOffer();

  public void setOffer(OfferEntity offer);

  public WeeklyPeriodEmbeddable getActivePeriod();

  public void setActivePeriod(WeeklyPeriod activePeriod);

  public Money getSpecialPrice();

  public void setSpecialPrice(Money specialPrice);

}
