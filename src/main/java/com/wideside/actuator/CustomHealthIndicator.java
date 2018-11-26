package com.wideside.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class CustomHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        Health.Builder down = Health.down();
        Health.Builder outOfService = Health.outOfService();
        Health.Builder unknown = Health.unknown();
        Health.Builder up = Health.up();

        List<Health.Builder> b = new ArrayList<>();
        b.add(down);
        b.add(outOfService);
        b.add(unknown);
        b.add(up);

        int i = ThreadLocalRandom.current().nextInt(0, 4);
        return b.get(i).build();
    }
}
