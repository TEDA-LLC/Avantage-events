package com.example.avantageevents.component;

import com.example.avantageevents.model.Bot;
import com.example.avantageevents.model.Category;
import com.example.avantageevents.model.Company;
import com.example.avantageevents.model.Department;
import com.example.avantageevents.repository.BotRepository;
import com.example.avantageevents.repository.CategoryRepository;
import com.example.avantageevents.repository.CompanyRepository;
import com.example.avantageevents.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Malikov Azizjon  *  17.01.2023  *  22:16   *  IbratClub
 */

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final BotRepository botRepository;
    @Value("${spring.sql.init.mode}")
    String mode;
    private final DepartmentRepository departmentRepository;
    private final CompanyRepository companyRepository;

    @Override
    public void run(String... args) {
        if (mode.equals("always")) {

//            Bot bot = new Bot();
//            bot.setToken("5432072116:AAHHjQHDP-IBzzQdiRyzHhqValr5tKQ6tlI");
//            bot.setUsername("tedauz_bot");
            Bot bot = new Bot();
            bot.setUsername("avantageEvents_bot");
            bot.setToken("6189750542:AAHumZZIJbwfwrdBtSwzsTffCCxboIAGVRo");
//            botRepository.save(bot);
            botRepository.save(bot);
            Bot save = botRepository.save(bot);
            Category service = Category.builder()
                    .nameUz("Xizmatlar \uD83D\uDEE0")
                    .nameRu("Услуги \uD83D\uDEE0")
                    .nameEn("Services \uD83D\uDEE0")
                    .build();
            Category system = Category.builder()
                    .nameUz("Tadbirlar \uD83D\uDCBB")
                    .nameRu("Выставки \uD83D\uDCBB")
                    .nameEn("Events \uD83D\uDCBB")
                    .build();
//            system.setBot(save);
//            service.setBot(save);
            Department department = new Department();
            department.setBot(save);
            Department departmentSave = departmentRepository.save(department);
            system.setDepartment(departmentSave);
            service.setDepartment(departmentSave);
            save.setDepartment(departmentSave);
            botRepository.save(bot);
            categoryRepository.save(service);
            categoryRepository.save(system);
            Company company = new Company();
            company.setActive(true);
            company.setName("Avantage");
            company.setDepartmentList(List.of(departmentSave));
            companyRepository.save(company);
//            company.setBotList(List.of(save));

        }
    }

}
