package me.wedding.dytwedding.bootstrap;

import me.wedding.dytwedding.domain.*;
import me.wedding.dytwedding.repositories.WeddingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;

@Component
public class BootDatas implements CommandLineRunner {
    private Wedding wedding1 = null;
    private Address address1 = null;
    private Address address2 = null;
    private Contract contract1 = null;
    private EngagementSession engagementSession = null;
    private Appointment appointment1 = null;
    private Appointment appointment2 = null;
    private Person bride = null;
    private Person groom = null;
    private Person witness1 = null;
    private Person witness2 = null;
    private Planning planning1 = null;
    private Couple couple = null;

    private Appointment gettingReady;
    private Appointment coupleShotsLocation;
    private Appointment ReligiousCeremonyLocation;
    private Appointment townhallLocation;
    private Appointment civilCeremonyLocation;
    private Appointment cocktailLocation;
    private Appointment receptiobnLocation;
    private WeddingRepository repository;

    public BootDatas(WeddingRepository repository) {
        this.repository = repository;
        this.gettingReady = Appointment.builder()
                .appointmentDate(LocalDateTime.of(2018, 1, 1, 1, 1))
                .appointmentLocation("Maison")
                .build();

        this.coupleShotsLocation = Appointment.builder()
                .appointmentDate(LocalDateTime.of(2018, 1, 1, 1, 1))
                .appointmentLocation("Lieu des photos")
                .build();

        this.receptiobnLocation = Appointment.builder()
                .appointmentDate(LocalDateTime.of(2018, 1, 1, 1, 1))
                .appointmentLocation("Reception")
                .build();

        this.ReligiousCeremonyLocation = Appointment.builder()
                .appointmentDate(LocalDateTime.of(2018, 1, 1, 1, 1))
                .appointmentLocation("Eglise")
                .build();

        this.townhallLocation = Appointment.builder()
                .appointmentDate(LocalDateTime.of(2018, 1, 1, 1, 1))
                .appointmentLocation("Mairie")
                .build();

        this.civilCeremonyLocation = Appointment.builder()
                .appointmentDate(LocalDateTime.of(2018, 1, 1, 1, 1))
                .appointmentLocation("Civil")
                .build();

        this.cocktailLocation = Appointment.builder()
                .appointmentDate(LocalDateTime.of(2018, 1, 1, 1, 1))
                .appointmentLocation("Coktail")
                .build();

        this.bride = Person.builder()
                .fistName("Juliette")
                .lastName("Capulet")
                .email("juju@shakespeare.co.uk")
                .phoneNumbers(Arrays.asList("un", "deux"))
                .build();


        this.groom = Person.builder()
                .fistName("Romeo")
                .lastName("Montaigu")
                .email("roro@shakespeare.co.uk")
                .phoneNumbers(Collections.singletonList("nu"))
                .build();

        this.witness1 = Person.builder()
                .fistName("William")
                .lastName("Shakespeare")
                .email("willy@shakespeare.co.uk")
                .phoneNumbers(Collections.singletonList("123"))
                .build();

        this.witness2 = Person.builder()
                .fistName("Frère")
                .lastName("Laurent")
                .email("lolo@shakespeare.co.uk")
                .phoneNumbers(Collections.singletonList("134523"))
                .build();

        this.address1 = Address.builder()
                .street1("Love street")
                .zipCode(12345)
                .city("Vérone")
                .build();

        this.address2 = Address.builder()
                .street1("Fond")
                .street2("Hell")
                .zipCode(2345)
                .city("Vérone")
                .build();

        this.engagementSession = EngagementSession.builder()
                .sessionDate(LocalDateTime.of(2018, 1, 1, 13, 34))
                .sessionLocation("Potiers")
                .build();

        this.appointment1 = Appointment.builder()
                .appointmentDate(LocalDateTime.of(2018, 1, 1, 23, 4))
                .appointmentLocation("Poitiers")
                .build();

        this.appointment2 = Appointment.builder()
                .appointmentDate(LocalDateTime.of(2018, 2, 2, 12, 00))
                .appointmentLocation("Londres")
                .build();

        this.planning1 = Planning.builder()
                .civilCeremonyLocation(civilCeremonyLocation)
                .cocktailLocation(cocktailLocation)
                .coupleShotsLocation(coupleShotsLocation)
                .gettingReady(gettingReady)
                .receptiobnLocation(receptiobnLocation)
                .ReligiousCeremonyLocation(ReligiousCeremonyLocation)
                .townhallLocation(townhallLocation)
                .build();

        this.couple = Couple.builder()
                .bride(bride)
                .groom(groom)
                .address(address1)
                .addressAfterWedding(address2)
                .build();

        this.contract1 = Contract.builder()
                .remise(10.00)
                .options(EnumSet.of(WeddingOptions.LARGEPRINT, WeddingOptions.LIVRELUXE))
                .forfait(Forfait.FORFAIT1)
                .deposit(100.00)
                .build();

        this.wedding1 = Wedding.builder()
                .couple(couple)
                .notes("nada")
                .contract(contract1)
                .weddingPlanning(planning1)
                .appointments(Arrays.asList(appointment1, appointment2))
                .weddingDate(LocalDate.of(2018, 2, 2))
                .engagementSession(engagementSession)
                .witnesses(Arrays.asList(witness1, witness2))
                .build();
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll()
                .thenMany(Flux.just(wedding1).flatMap(repository::save))
                .subscribe(System.out::println);
    }
}
