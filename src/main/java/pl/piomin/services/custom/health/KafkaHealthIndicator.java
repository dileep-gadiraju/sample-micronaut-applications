package pl.piomin.services.custom.health;

import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.async.publisher.Publishers;
import io.micronaut.health.HealthStatus;
import io.micronaut.management.endpoint.health.HealthEndpoint;
import io.micronaut.management.health.indicator.HealthIndicator;
import io.micronaut.management.health.indicator.HealthResult;
import jakarta.inject.Inject;
import org.reactivestreams.Publisher;
import pl.piomin.services.config.KafkaClientConfig;

import java.util.Collections;

@Replaces(KafkaHealthIndicator.class)
@Requires(property = HealthEndpoint.PREFIX + ".url.enabled", value = "true")
@Requires(beans = HealthEndpoint.class)
public class KafkaHealthIndicator implements HealthIndicator {

    @Inject
    private KafkaClientConfig config;

    @Property(name = "kafka.health-indicator-topic")
    private String healthIndicatorTopic;

    @Override
    public Publisher<HealthResult> getResult() {
        HealthStatus healthStatus = HealthStatus.UP;
        HealthResult healthResult=null;
        String message="success";
        try {
            config.sendHeartBeat(healthIndicatorTopic, "key", "❥");
        }catch (Exception e){
            e.printStackTrace();
            message=e.getMessage();
            healthStatus=HealthStatus.DOWN;
        }
        healthResult= HealthResult.builder("kafka", healthStatus)
                .details(Collections.singletonMap("details", message))
                .build();
        return Publishers.just(healthResult);
    }
}
