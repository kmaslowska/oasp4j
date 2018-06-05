package io.oasp.gastronomy.restaurant.salesmanagement.dataaccess.impl.dao;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import io.oasp.gastronomy.restaurant.SpringBootApp;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.WeeklyPeriodEmbeddable;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.SpecialDao;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.SpecialSearchCriteriaTo;
import io.oasp.module.test.common.base.ComponentTest;

/**
 * @author KMASLOWS
 *
 */
@Transactional
@SpringBootTest(classes = { SpringBootApp.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpecialDaoTest extends ComponentTest {

  @Inject
  private SpecialDao specialDao;

  @PersistenceContext
  private EntityManager entityManager;

  @Test
  public void create() {

    SpecialEntity special = new SpecialEntity();
    special.setName("specjalna");
    special.setModificationCounter(0);
    assertThat(special.getId()).isNull();
    special = this.specialDao.save(special);

  }

  @Test
  public void findSpecialforMonday() {

    SpecialEntity special = new SpecialEntity();
    special.setName("specjalnaMonday");
    special.setModificationCounter(0);
    WeeklyPeriodEmbeddable weeklyPeriod = new WeeklyPeriodEmbeddable();
    weeklyPeriod.setStartingDay(DayOfWeek.MONDAY);
    weeklyPeriod.setEndingDay(DayOfWeek.FRIDAY);
    weeklyPeriod.setStartingHour(8);
    weeklyPeriod.setStartingHour(16);
    special.setActivePeriod(weeklyPeriod);

    this.specialDao.save(special);
    SpecialSearchCriteriaTo criteria = new SpecialSearchCriteriaTo();
    criteria.setDateOfChecking(LocalDateTime.now());
    assertThat(this.specialDao.findSpecials(criteria)).isNotNull();

  }
}
