package io.oasp.gastronomy.restaurant.general.common.base;

import javax.inject.Inject;

import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import io.oasp.gastronomy.restaurant.SpringBootApp;
import io.oasp.gastronomy.restaurant.general.common.DbTestHelper;
import io.oasp.gastronomy.restaurant.general.common.RestTestClientBuilder;
import io.oasp.gastronomy.restaurant.general.common.SecurityTestHelper;
import io.oasp.gastronomy.restaurant.general.service.impl.config.RestaurantTestConfig;
import io.oasp.module.basic.common.api.config.SpringProfileConstants;
import io.oasp.module.test.common.base.AbstractSubsystemTest;

/**
 * Abstract base class for {@link AbstractSubsystemTest}s which runs the tests within a local server. <br/>
 * <br/>
 * The local server's port is randomly assigned.
 *
 */

@SpringBootTest(classes = { RestaurantTestConfig.class,
SpringBootApp.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class AbstractRestServiceTest extends AbstractSubsystemTest {


  /**
   * The port of the web server during the test.
   */
  @LocalServerPort
  protected int port;

  /**
   * The {@code RestaurantTestHelper}.
   */
  @Inject
  private SecurityTestHelper securityTestHelper;

  @Inject
  private DbTestHelper dbTestHelper;

  /**
   * The {@code RestTestClientBuilder}.
   */
  @Inject
  private RestTestClientBuilder restTestClientBuilder;

  /**
   * The {@code JacksonJsonProvider}
   */
  @Inject
  private JacksonJsonProvider jacksonJsonProvider;

  /**
   * Sets up the test.
   */
  @Override
  protected void doSetUp() {

    super.doSetUp();
    this.restTestClientBuilder.setLocalServerPort(this.port);
    this.restTestClientBuilder.setJacksonJsonProvider(this.jacksonJsonProvider);

  }

  /**
   * Cleans up the test.
   */
  @Override
  protected void doTearDown() {

    super.doTearDown();
  }

  /**
   * @return the {@link SecurityTestHelper}
   */
  public SecurityTestHelper getSecurityTestHelper() {

    return this.securityTestHelper;
  }

  /**
   * @return the {@link DbTestHelper}
   */
  public DbTestHelper getDbTestHelper() {

    return this.dbTestHelper;
  }

  /**
   * @return the {@link RestTestClientBuilder}
   */
  public RestTestClientBuilder getRestTestClientBuilder() {

    return this.restTestClientBuilder;
  }

}
