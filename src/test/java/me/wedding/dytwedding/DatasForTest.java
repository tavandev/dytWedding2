//package me.wedding.dytwedding;
//
//
//import me.wedding.dytwedding.domain.*;
//import me.wedding.dytwedding.repositories.WeddingRepository;
//import org.junit.jupiter.api.BeforeEach;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.EnumSet;
//
//public class DatasForTest {
//    public final Address address1=
//            Address.builder()
//            .street1("rue du chaudron")
//            .street2("d'or")
//            .zipCode(86000)
//            .city("Poitiers")
//            .build();
//    public final  Address address2=
//            Address.builder()
//            .street1("rue de la paix")
//            .street2("apt 23")
//            .zipCode(75000)
//            .city("Paris")
//            .build();
//
//    public final  Person bride1=
//            Person.builder()
//            .fistName("Juliette")
//            .lastName("Capulet")
//            .email("juliette@jesuisfoutue@co.uk")
//            .phoneNumbers(Collections.singletonList("0102030405"))
//            .build();
//
//    public final  Person groom1=
//            Person.builder()
//            .fistName("Romeo")
//            .lastName("Montaigu")
//            .email("romeo@shakespeare.co.uk")
//            .phoneNumbers(Arrays.asList("ER","ZE"))
//            .build();
//
//    public final Person witness1=
//            Person.builder()
//            .fistName("Mercutio")
//            .lastName("Trevis")
//            .phoneNumbers(Arrays.asList("ERR","EEE","23"))
//            .build();
//
//    public final Person witness2=
//            Person.builder()
//                    .fistName("Tybalt")
//                    .lastName("Troboa")
//                    .phoneNumbers(Collections.singletonList("ERR"))
//                    .build();
//
//    public final Contract contract1=
//            Contract.builder()
//            .deposit(200.00)
//            .forfait(Forfait.FORFAIT1)
//            .options(EnumSet.of(WeddingOptions.LARGEPRINT,WeddingOptions.SEANCEDAYAFTER))
//            .remise(0.00)
//            .build();
//
//    public final Planning planning1=
//            Planning.builder()
//            .civilCeremonyLocation("Verone")
//            .civilCeremonyHour(LocalDate.of(2018,1,1))
//            .build();
//
//    public final Appointment appointment1=
//            Appointment.builder()
//            .appointmentDate(LocalDate.of(2018,1,1))
//            .appointmentLocation("Poitiers")
//            .build();
//
//    public final Appointment appointment2=
//            Appointment.builder()
//                    .appointmentDate(LocalDate.of(2018,1,2))
//                    .appointmentLocation("Londres")
//                    .build();
//
//    public final Couple couple1=
//            Couple.builder()
//            .groom(groom1)
//            .bride(bride1)
//            .address(address1)
//            .addressAfterWedding(address2)
//            .build();
//
//    public final EngagementSession engagementSession1=
//            EngagementSession.builder()
//            .sessionDate(LocalDate.of(2018,3,3))
//            .sessionLocation("Poitiers")
//            .build();
//
//    public final Wedding wedding1=
//            Wedding.builder()
//            .couple(couple1)
//            .weddingDate(LocalDate.of(2018,1,2))
//            .appointments(Arrays.asList(appointment1,appointment2))
//            .weddingPlanning(planning1)
//            .contract(contract1)
//            .engagementSession(engagementSession1)
//            .notes("nada")
//            .build();
//
//}
