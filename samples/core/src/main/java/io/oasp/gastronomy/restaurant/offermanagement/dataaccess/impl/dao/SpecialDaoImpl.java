package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.impl.dao;

import static com.querydsl.core.alias.Alias.$;

import java.time.LocalDateTime;

import javax.inject.Named;

import com.querydsl.core.alias.Alias;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQuery;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.SpecialDao;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.SpecialSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * @author KMASLOWS
 *
 */
@Named
public class SpecialDaoImpl extends ApplicationMasterDataDaoImpl<SpecialEntity> implements SpecialDao {

  @Override
  public PaginatedListTo<SpecialEntity> findSpecials(SpecialSearchCriteriaTo criteria) {

    SpecialEntity special = Alias.alias(SpecialEntity.class);
    EntityPathBase<SpecialEntity> alias = $(special);
    JPAQuery<SpecialEntity> query = new JPAQuery<SpecialEntity>(getEntityManager()).from(alias);

    String name = criteria.getName();
    if (name != null) {
      query.where($(special.getName()).eq(name));
    }

    Long offerId = criteria.getOfferId();
    if (offerId != null) {
      query.where($(special.getOffer().getId()).eq(offerId));
    }

    LocalDateTime dateOfChecking = criteria.getDateOfChecking();
    if (dateOfChecking != null) {
      query.where($(special.getActivePeriod().getStartingDay()).loe(dateOfChecking.getDayOfWeek())
          .and($(special.getActivePeriod().getEndingDay()).goe(dateOfChecking.getDayOfWeek())
              .and($(special.getActivePeriod().getStartingHour()).loe(dateOfChecking.getHour())
                  .and($(special.getActivePeriod().getEndingHour()).gt(dateOfChecking.getHour())))));
    }

    Money specialPrice = criteria.getSpecialPrice();
    if (specialPrice != null) {
      query.where($(special.getSpecialPrice()).goe(specialPrice));
    }

    return findPaginated(criteria, query);
  }

  @Override
  protected Class<SpecialEntity> getEntityClass() {

    return SpecialEntity.class;

  }

}
