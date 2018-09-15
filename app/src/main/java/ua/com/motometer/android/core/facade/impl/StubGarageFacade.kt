package ua.com.motometer.android.core.facade.impl

import ua.com.motometer.android.core.facade.GarageFacade
import ua.com.motometer.android.core.facade.model.ImmutableVehicle
import ua.com.motometer.android.core.facade.model.Vehicle

class StubGarageFacade : GarageFacade {
    override fun vehicles(): List<Vehicle> {
        return listOf<Vehicle>(
                ImmutableVehicle.of("Passat B5", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Volkswagen_Logo_till_1995.svg/193px-Volkswagen_Logo_till_1995.svg.png", 2002),
                ImmutableVehicle.of("Passat B6", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Volkswagen_Logo_till_1995.svg/193px-Volkswagen_Logo_till_1995.svg.png", 2002),
                ImmutableVehicle.of("Passat B7", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Volkswagen_Logo_till_1995.svg/193px-Volkswagen_Logo_till_1995.svg.png", 2002),
                ImmutableVehicle.of("Passat B8", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Volkswagen_Logo_till_1995.svg/193px-Volkswagen_Logo_till_1995.svg.png", 2002),
                ImmutableVehicle.of("Touareg", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Volkswagen_Logo_till_1995.svg/193px-Volkswagen_Logo_till_1995.svg.png", 2002),
                ImmutableVehicle.of("Caddy", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Volkswagen_Logo_till_1995.svg/193px-Volkswagen_Logo_till_1995.svg.png", 2002),
                ImmutableVehicle.of("Crafter", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Volkswagen_Logo_till_1995.svg/193px-Volkswagen_Logo_till_1995.svg.png", 2002),
                ImmutableVehicle.of("Arteon", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Volkswagen_Logo_till_1995.svg/193px-Volkswagen_Logo_till_1995.svg.png", 2002),
                ImmutableVehicle.of("Porsche Cayenne", "https://upload.wikimedia.org/wikipedia/ru/5/55/Porsche_logo.png", 2002),
                ImmutableVehicle.of("Porsche Panamera", "https://upload.wikimedia.org/wikipedia/ru/5/55/Porsche_logo.png", 2002),
                ImmutableVehicle.of("Skoda Superb", "http://www.carlogos.org/logo/Skoda-logo-2016-1920x1080.png", 2002),
                ImmutableVehicle.of("Skoda Fabia", "http://www.carlogos.org/logo/Skoda-logo-2016-1920x1080.png", 2002),
                ImmutableVehicle.of("Skoda Kodiaq", "http://www.carlogos.org/logo/Skoda-logo-2016-1920x1080.png", 2002),
                ImmutableVehicle.of("Skoda Karoq", "http://www.carlogos.org/logo/Skoda-logo-2016-1920x1080.png", 2002)
        )
    }
}