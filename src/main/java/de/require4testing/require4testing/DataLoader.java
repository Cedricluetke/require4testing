package de.require4testing.require4testing;

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
            Requirement req = new Requirement("Login muss funktionieren", "Benutzer soll sich einloggen können");
            requirementRepo.save(req);

            // Testcases
            Testcase tc1 = testcaseRepo.save(new Testcase("Login mit gültigen Daten"));
            Testcase tc2 = testcaseRepo.save(new Testcase("Login mit falschem Passwort"));

            req.getTestCases().add(tc1);
            req.getTestCases().add(tc2);
            requirementRepo.save(req);

            // Testruns
            testrunRepo.save(new Testrun(LocalDate.now(),"PASSED",nele,tc1));
            testrunRepo.save(new Testrun(LocalDate.now(),"FAILED",cedric,tc2));

            System.out.println("Testdaten wurden geladen");
        };
    }
}