package io.oasp.gastronomy.restaurant.offermanagement.logic.api.to;

import java.time.LocalDateTime;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * @author KMASLOWS
 *
 */
public class SpecialSearchCriteriaTo extends SearchCriteriaTo {

  private String name;

  private Long offerId;

  private LocalDateTime dateOfChecking;

  private Money specialPrice;

  public SpecialSearchCriteriaTo() {

    super();
  }

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return offerId
   */
  public Long getOfferId() {

    return this.offerId;
  }

  /**
   * @param offerId new value of {@link #getofferId}.
   */
  public void setOfferId(Long offerId) {

    this.offerId = offerId;
  }

  /**
   * @return dateOfChecking
   */
  public LocalDateTime getDateOfChecking() {

    return this.dateOfChecking;
  }

  /**
   * @param dateOfChecking new value of {@link #getdateOfChecking}.
   */
  public void setDateOfChecking(LocalDateTime dateOfChecking) {

    this.dateOfChecking = dateOfChecking;
  }

  /**
   * @return specialPrice
   */
  public Money getSpecialPrice() {

    return this.specialPrice;
  }

  /**
   * @param specialPrice new value of {@link #getspecialPrice}.
   */
  public void setSpecialPrice(Money specialPrice) {

    this.specialPrice = specialPrice;
  }

}
