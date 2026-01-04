/* package de.require4testing.require4testing;

import de.require4testing.require4testing.model.*;
import de.require4testing.require4testing.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(
            RequirementRepository requirementRepo,
            TestcaseRepository testcaseRepo,
            TestrunRepository testrunRepo,
            TesterRepository testerRepo
    ) {
        return args -> {

            // Tester
            Tester cedric = testerRepo.save(new Tester("Cedric"));
            Tester nele = testerRepo.save(new Tester("Nele"));

            // Requirement
            Requirement req = new Requirement(
                    "Login muss funktionieren",
                    "Benutzer soll sich einloggen können"
            );

            Testcase tc1 = new Testcase("Login mit gültigen Daten");
            Testcase tc2 = new Testcase("Login mit falschem Passwort");

            tc1.setRequirement(req);
            tc2.setRequirement(req);

            req.getTestCases().add(tc1);
            req.getTestCases().add(tc2);

            requirementRepo.save(req);

            testrunRepo.save(new Testrun(LocalDate.now(),  nele, tc1));
            testrunRepo.save(new Testrun(LocalDate.now(),  cedric, tc2));

            System.out.println("Testdaten wurden geladen");
        };
    }
} */
//Data Loader würde wenn "spring.jpa.hibernate.ddl-auto=update" duplikate bei jedem starte erstellen, da jetzt persistent