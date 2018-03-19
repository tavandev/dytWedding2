package me.wedding.dytwedding;

import lombok.Getter;
import me.wedding.dytwedding.domain.*;
import me.wedding.dytwedding.repositories.WeddingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;

@Getter
public class BootDatasTests {

    @Autowired
    private WeddingRepository repository;


    private Wedding wedding1, wedding2 = null;
    private Address address1 = null;
    private Address address2 = null;
    private Contract contract1 = null;
    private Appointment engagementSession = null;
    private Appointment appointment1 = null;
    private Appointment appointment2 = null;
    private Person bride = null;
    private Person groom = null;
    private Person witness1 = null;
    private Person witness2 = null;
    private Planning planning1 = null;
    private Couple couple, couple2 = null;

    private Appointment gettingReady;
    private Appointment coupleShotsLocation;
    private Appointment ReligiousCeremony;
    private Appointment townhallLocation;
    private Appointment civilCeremonyLocation;
    private Appointment cocktailLocation;
    private Appointment receptiobnLocation;

    public BootDatasTests() {

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

        this.ReligiousCeremony = Appointment.builder()
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
                .firstName("Juliette")
                .lastName("Capulet")
                .email("juju@shakespeare.co.uk")
                .phoneNumbers(Arrays.asList("un", "deux"))
                .build();


        this.groom = Person.builder()
                .firstName("Romeo")
                .lastName("Montaigu")
                .email("roro@shakespeare.co.uk")
                .phoneNumbers(Collections.singletonList("nu"))
                .build();

        this.witness1 = Person.builder()
                .firstName("William")
                .lastName("Shakespeare")
                .email("willy@shakespeare.co.uk")
                .phoneNumbers(Collections.singletonList("123"))
                .build();

        this.witness2 = Person.builder()
                .firstName("Frère")
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

        this.engagementSession = Appointment.builder()
                .appointmentDate(LocalDateTime.of(2018, 1, 1, 13, 34))
                .appointmentLocation("Potiers")
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
                .civilCeremony(civilCeremonyLocation)
                .cocktail(cocktailLocation)
                .coupleShots(coupleShotsLocation)
                .gettingReady(gettingReady)
                .reception(receptiobnLocation)
                .religiousCeremony(ReligiousCeremony)
                .townhall(townhallLocation)
                .build();

        this.couple = Couple.builder()
                .bride(bride)
                .groom(groom)
                .address(address1)
                .addressAfterWedding(address2)
                .build();

        this.couple2 = Couple.builder()
                .bride(witness1)
                .groom(witness2)
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

        this.wedding2 = Wedding.builder()
                .couple(couple2)
                .notes("nada")
                .contract(contract1)
                .weddingPlanning(planning1)
                .appointments(Arrays.asList(appointment1, appointment2))
                .weddingDate(LocalDate.of(2018, 2, 2))
                .engagementSession(engagementSession)
                .witnesses(Arrays.asList(witness1, witness2))
                .build();

    }

}
